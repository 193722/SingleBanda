package clud.qc.bicycle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
// 指定了项目访问名：singleBanda。此处如果指定value值为singleBanda；访问需为：/singleBanda/singleBanda/**
public class BaseController {
}
