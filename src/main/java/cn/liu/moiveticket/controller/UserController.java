package cn.liu.moiveticket.controller;

import cn.liu.moiveticket.pojo.User;
import cn.liu.moiveticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/register"})
    public String register() {
        return "register";
    }

    /**
     * 用户注册
     */
    @PostMapping({"/register"})
    public String newUserReg(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String email = httpServletRequest.getParameter("email");
        String password1 = httpServletRequest.getParameter("password1");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(password1)) {
            model.addAttribute("errMsg", "用户名、密码或邮箱不能为空😥");
            return "register";
        }

        if (!password.equals(password1)) {
            model.addAttribute("errMsg", "两次密码不一致😥");
            return "register";
        }

        User userByEmail = userService.findUserByEmail(email);
        if (userByEmail != null) {
            model.addAttribute("errMsg", "此邮箱已注册过😥");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAccess_type(0);
        user.setEmail(email);

        // 注册用户
        userService.registerUser(user);

        // 存入session
        User loginUser = userService.findUserByEmail(email);
        httpSession.setAttribute("user", loginUser);
        return "redirect:/";
    }

    // 登录
    @PostMapping("/login")
    public String userLogin(HttpServletRequest request, HttpSession httpSession, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.findUserByEmail(email);
        if (user == null) {
            return "redirect:/"+ "?err=0";
        }

        if (!user.getPassword().equals(password)) {
            return "redirect:/"+"?err=0";
        }

        httpSession.setAttribute("user", user); // 登录信息放入session
        return "redirect:/";
    }
}
