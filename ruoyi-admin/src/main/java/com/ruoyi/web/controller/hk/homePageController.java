package com.ruoyi.web.controller.hk;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName
 * @Data 2022/10/8
 * @Created DuanJiashuai
 */
@Controller
@Anonymous
public class homePageController {
   @GetMapping("/homePage")
    public String homePage()
   {
       return "index";
   }

}
