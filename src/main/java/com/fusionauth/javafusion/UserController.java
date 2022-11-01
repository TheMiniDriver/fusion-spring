package com.fusionauth.javafusion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  @RequestMapping("/user")
  public String userPage(Model model) {
      model.addAttribute("name", "SUPER USER");
      return "user";
  }
  
}
