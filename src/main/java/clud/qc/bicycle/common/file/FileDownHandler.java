package clud.qc.bicycle.common.file;

import clud.qc.bicycle.common.constant.ConstantConfig;

import java.io.File;

public class FileDownHandler {

    /**
     * 默认下载到../classes/file_handler/，文件最大为1M(1024 KB)
     */
    public void down() {
        StringBuilder fileStoragePath = new StringBuilder(this.getClass().getResource(File.separator).getPath());
        fileStoragePath.append(ConstantConfig.FILE_HANDLER_PATH).append(File.separator).append(ConstantConfig.FILE_DOWN);
        this.down(fileStoragePath.toString(), 1024);
    }

    /**
     * @param fileStoragePath 下载文件保存路径
     * @param fileMaxSize     单位KB
     */
    public void down(String fileStoragePath, int fileMaxSize) {

    }

}
