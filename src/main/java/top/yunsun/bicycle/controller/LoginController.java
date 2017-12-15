package top.yunsun.bicycle.controller;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.yunsun.bicycle.controller.result.UserInfo;
import top.yunsun.bicycle.core.redis.RedisUtils;
import top.yunsun.bicycle.entity.user.UserInfoDO;

import javax.jws.WebParam;
import java.util.Date;


@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/index.html")
    public ModelAndView login(ModelMap modelMap) {
        logger.info("跳转首页");
        return new ModelAndView("index");
    }

    @RequestMapping("/list.json")
    public UserInfo list(ModelMap modelMap) {
        logger.info("跳转集合页面");
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setSex("男");
        userInfo.setCreateTime(new Date());
        return userInfo;
    }

    @RequestMapping("/result.html")
    public String result(ModelMap modelMap) {
        return "404";
    }

}
