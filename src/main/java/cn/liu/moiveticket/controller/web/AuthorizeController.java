package cn.liu.moiveticket.controller.web;

import cn.liu.moiveticket.dto.AccessTokenDTO;
import cn.liu.moiveticket.dto.GithubUser;
import cn.liu.moiveticket.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AuthorizeController {

    @Autowired // 自动将实例加载
    private GithubProvider githubProvider;

//    把application.properties的值注入进来
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.redirect_uri}")
    private String clientRedirect;

    @GetMapping("/logincb")
    public String loginCb(@RequestParam(name="code") String code,
                          @RequestParam(name="state") String state,
                          HttpServletRequest request) throws IOException {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(clientRedirect);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);

        // 运用session保存登录态
        if(user != null) {
            // 登录成功
            request.getSession().setAttribute("user",user);
            return "redirect:/"; // 将地址清空，重新进入index
        }else {
            // 登录失败
            return "redirect:/";
        }
    }
}
