package cn.liu.moiveticket.controller;

import cn.liu.moiveticket.pojo.User;
import cn.liu.moiveticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Controller
public class MovieController {
    @Autowired
    UserService userService;


    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    @GetMapping("/movieDetail")
    public String detail() {
        return "shopTicket";
    }



}
