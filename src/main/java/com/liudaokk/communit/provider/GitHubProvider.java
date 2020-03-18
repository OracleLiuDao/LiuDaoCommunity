package com.liudaokk.communit.provider;
import com.alibaba.fastjson.JSON;
import com.liudaokk.communit.dto.AccessTokenDto;
import com.liudaokk.communit.dto.GitHubUser;
import netscape.javascript.JSObject;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/17 - 19:02
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        //这里就需要okhttp去请求github的access_token的接口拿到令牌
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //分割string,拿到tocken
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public GitHubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string,GitHubUser.class);
            return gitHubUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
}
