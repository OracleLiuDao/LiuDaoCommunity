package com.liudaokk.communit.controller;

import com.liudaokk.communit.dto.AccessTokenDto;
import com.liudaokk.communit.dto.GitHubUser;
import com.liudaokk.communit.mapper.UserMapper;
import com.liudaokk.communit.model.User;
import com.liudaokk.communit.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/17 - 17:05
 */
@Controller
public class AuthorizedController {
    @Autowired
    private GitHubProvider gitHubProvider;
    //抽取参数到配置文件
        @Value("${github.Client.id}")
        private String ClientId;
        @Value("${github.Client.secret}")
        private String ClientSecret;
        @Value("${github.Redirect.uri}")
        private String RedirectUri;
        //引入user接口操作sql语句
        @Autowired
        private UserMapper userMapper;

        @GetMapping("/callback")
        public String callback(@RequestParam(name="code") String code,
                               @RequestParam(name="state") String state
                                , HttpServletRequest request){
            AccessTokenDto accessTokenDto = new AccessTokenDto();
            accessTokenDto.setClient_id(ClientId);
            accessTokenDto.setClient_secret(ClientSecret);
            accessTokenDto.setCode(code);
            accessTokenDto.setRedirect_uri(RedirectUri);
            accessTokenDto.setState(state);
            String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
            GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);
            if(gitHubUser!=null){
                User user = new User();
                user.setAccountId(String.valueOf(gitHubUser.getId()));
                user.setToken(UUID.randomUUID().toString());
                user.setName(gitHubUser.getName());
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreate());
                //持久化到数据库
                userMapper.insert(user);
                //登录成功,给cookie
                HttpSession session = request.getSession();
                session.setAttribute("user",gitHubUser);
                return "redirect:/"; //这里注意重定向 /
            }else {
                //登录失败返回首页
                return "redirect:/";
            }
        }
    }
