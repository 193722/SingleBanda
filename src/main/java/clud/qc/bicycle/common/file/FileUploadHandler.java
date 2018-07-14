package clud.qc.bicycle.common.file;

import clud.qc.bicycle.common.exception.ResultCode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clud.qc.bicycle.common.asserts.AssertUtils;
import clud.qc.bicycle.common.constant.ConstantConfig;
import clud.qc.bicycle.common.constant.SbootConstantConfig;
import clud.qc.bicycle.common.exception.BusinessException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.UUID;

public class FileUploadHandler {

    private static Logger logger = LoggerFactory.getLogger(FileUploadHandler.class);

    /**
     * 默认上传到../classes/file_handler/，文件最大为1M(1024 KB)
     */
    public String upload(HttpServletRequest request) throws BusinessException {
        StringBuilder fileStoragePath = new StringBuilder(this.getClass().getResource("/").getPath());
        fileStoragePath.append(ConstantConfig.FILE_HANDLER_PATH).append(File.separator).append(ConstantConfig.FILE_UPLOAD);
        return this.upload(request, fileStoragePath.toString(), ConstantConfig.FILE_SIZE_DEFAULT);
    }

    /**
     * @param fileStoragePath 上传文件保存路径
     * @param fileMaxSize     单位KB
     */
    public String upload(HttpServletRequest request, String fileStoragePath, int fileMaxSize) throws BusinessException {
        //定义缓冲区文件对象
        String tempPath = fileStoragePath.substring(0, fileStoragePath.lastIndexOf(File.separator) + 1) + "temp";
        File tempFile = new File(tempPath);
        //临时文件不存在，创建
        if (!tempFile.exists() && !tempFile.isDirectory()) {
            tempFile.mkdirs();
        }
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            diskFileItemFactory.setSizeThreshold(ConstantConfig.FILE_SIZE_DEFAULT * 100);
            //设置上传时生成的临时文件的保存目录
            diskFileItemFactory.setRepository(tempFile);
            //2、创建一个文件上传解析器
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决上传文件名的中文乱码
            fileUpload.setHeaderEncoding("UTF-8");
            //监听文件上传进度
            fileUpload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                }
            });
            //3、判断提交上来的数据是否是上传表单的数据
            if (!fileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return null;
            }
            //设置上传单个文件的大小的最大值,单位是 KB
            fileUpload.setFileSizeMax(fileMaxSize);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            fileUpload.setSizeMax(fileMaxSize * 10);
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = fileUpload.parseRequest((RequestContext) request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    String value1 = new String(name.getBytes("iso8859-1"), "UTF-8");
                    System.out.println(name + "  " + value);
                    System.out.println(name + "  " + value1);
                } else {
                    //如果fileitem中封装的是上传文件，得到上传的文件名称，
                    String fileName = item.getName();
                    AssertUtils.notBlank(fileName, ResultCode.FILE_NAME_IS_BLANK);
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
                    // 如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                    //得到上传文件的扩展名
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    AssertUtils.isTrue(suffixCheck(fileExtName), ResultCode.FILE_UPLOAD_TYPE_NO_MATCH);
                    //获取item中的上传文件的输入流
                    InputStream fis = item.getInputStream();
                    //得到文件保存的名称
                    fileName = mkFileName(fileName);
                    //得到文件保存的路径
                    String savePathStr = mkFilePath(fileStoragePath, fileName);
                    System.out.println("保存路径为:" + savePathStr);
                    //创建一个文件输出流
                    FileOutputStream fos = new FileOutputStream(fileStoragePath + File.separator + fileName);
                    //获取读通道
                    FileChannel readChannel = ((FileInputStream) fis).getChannel();
                    //获取写通道
                    FileChannel writeChannel = fos.getChannel();
                    //创建一个缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(ConstantConfig.FILE_SIZE_DEFAULT);
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while (true) {
                        buffer.clear();
                        int len = readChannel.read(buffer);//读入数据
                        if (len < 0) {
                            break;//读取完毕
                        }
                        buffer.flip();
                        writeChannel.write(buffer);//写入数据
                    }
                    //关闭输入流
                    fis.close();
                    //关闭输出流
                    fos.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                }
            }
        } catch (FileUploadException e) {
            logger.error("上传文件异常：{}", e);
            throw new BusinessException(ResultCode.FILE_UPLOAD_EXCEPTION);
        } catch (IOException e) {
            logger.error("上传文件异常：{}", e);
        } catch (Exception e) {
            logger.error("上传文件异常：{}", e);
        }
        return null;
    }

    /**
     * @param uploadPath  上传文件路径
     * @param storagePath 保存文件路径
     * @param maxFileSize 允许文件最大
     * @return
     */
    public String upload(String uploadPath, String storagePath, int maxFileSize) throws BusinessException {
        return "";
    }

    /**
     * @param uploadPath 上传文件路径
     * @return
     */
    public String upload(String uploadPath) throws BusinessException {
        StringBuilder fileStoragePath = new StringBuilder(this.getClass().getResource("/").getPath());
        fileStoragePath.append(ConstantConfig.FILE_HANDLER_PATH).append(File.separator).append(ConstantConfig.FILE_UPLOAD);
        return this.upload(uploadPath, fileStoragePath.toString(), ConstantConfig.FILE_SIZE_DEFAULT);
    }

    /**
     * 校验上传文件是否满足要求
     *
     * @param suffix
     * @return
     */
    private boolean suffixCheck(String suffix) {
        logger.info("文件类型：{}", suffix);
        if (SbootConstantConfig.file_suffix.contains(suffix)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    //生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
    private String mkFileName(String fileName) {
        return UUID.randomUUID().toString() + "_" + fileName;
    }

    private String mkFilePath(String storagePath, String fileName) {
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = fileName.hashCode();
        int dir1 = hashcode & 0xf;
        int dir2 = (hashcode & 0xf0) >> 4;
        //构造新的保存目录
        StringBuilder dir = new StringBuilder(storagePath).append(File.separator).append(dir1)
                .append(File.separator).append(dir2);
        //File既可以代表文件也可以代表目录
        File file = new File(dir.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir.toString();
    }
}
