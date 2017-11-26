package top.yunsun.bicycle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/index.html")
    public ModelAndView login(ModelMap modelMap) {
        logger.info("跳转首页");
        return new ModelAndView("index");
    }

    @RequestMapping("/list.html")
    public String list(ModelMap modelMap) {
        logger.info("跳转集合页面");
        return "404";
    }

}
