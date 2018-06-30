package clud.qc.bicycle.common.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import clud.qc.bicycle.common.constant.ConstantConfig;
import clud.qc.bicycle.controller.result.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BandaInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(BandaInterceptor.class);

    @Value("#{'${interceptor.exclude.url}'.split(',')}")
    private List<String> exclude_url;

    @Value("${static.exclude.url}")
    private String static_url;

    /**
     * 重写preHandle方法，在请求发生之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        logger.info("请求开始:{}", url);
        request.setAttribute("start_time_millis", System.currentTimeMillis());
        //静态资源访问放行
        if (url.contains(static_url)) {
            return true;
        }
        //后台访问放行
        if (exclude_url.contains(url)) {
            return true;
        }
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(ConstantConfig.USER_LOGIN_SESSION);
        if (userInfo == null) {
            response.sendRedirect("/singleBanda/index.html");
            return false;
        }
        return true;
    }

    /**
     * 重写postHandle方法，执行请求
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion方法执行！");
        Long start_time_mills = (Long) request.getAttribute("start_time_millis");
        Long end_time_mills = System.currentTimeMillis();
        logger.info("当前请求耗时：{}毫秒", (end_time_mills - start_time_mills));
    }
}
