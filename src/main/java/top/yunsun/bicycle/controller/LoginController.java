package top.yunsun.bicycle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import top.yunsun.bicycle.core.redis.RedisUtils;


@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/index.html")
    public ModelAndView login(ModelMap modelMap) {
        logger.info("跳转首页");
        redisUtils.set("mykey","这是我的redis使用测试");
        return new ModelAndView("index");
    }

    @RequestMapping("/list.html")
    public String list(ModelMap modelMap) {
        logger.info("跳转集合页面");
        logger.info("redis得到的mykey的value：{}",redisUtils.get("mykey"));
        return "404";
    }

}
