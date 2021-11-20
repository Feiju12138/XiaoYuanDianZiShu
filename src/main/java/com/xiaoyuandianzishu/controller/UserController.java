package com.xiaoyuandianzishu.controller;

import com.xiaoyuandianzishu.pojo.ResultHistory;
import com.xiaoyuandianzishu.pojo.ResultLike;
import com.xiaoyuandianzishu.pojo.ResultObj;
import com.xiaoyuandianzishu.pojo.ResultUser;
import com.xiaoyuandianzishu.pojo.WxToken;
import com.xiaoyuandianzishu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends MappingJackson2HttpMessageConverter {

    @Autowired
    private UserService userService;

    /**
     * 获取openid
     * @param js_code
     * @return
     */
    @RequestMapping("/getOpenId")
    public Object getOpenId(String js_code) {

        RestTemplate restTemplate = new RestTemplate();

        String appid = ""; // 写自己的小程序appid
        String secret = ""; // 写自己的小程序secret

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&grant_type=authorization_code&js_code="+js_code;

        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        WxToken wxToken = restTemplate.getForObject(url, WxToken.class);

        System.out.println(wxToken);
        return wxToken;

    }

    /**
     * 获取用户信息
     */
    @RequestMapping("/getUserInfo")
    public ResultUser getUserInfo(String openid) {
        return userService.getUserInfo(openid);
    }

    /**
     * 用户登录
     *  如果是已注册，就修改时间戳
     *  如果是未注册，就添加时间戳和用户信息
     * @param openid
     * @param time_stamp
     * @param avatarUrl
     * @param gender
     * @param nickName
     * @return
     */
    @RequestMapping("/login")
    public ResultObj login(String openid, String time_stamp, String avatarUrl, Integer gender, String nickName) {
        return userService.login(openid, time_stamp, avatarUrl, gender, nickName);
    }

    /**
     * 获取用户的收藏记录
     */
    @RequestMapping("/getUserLike")
    public ResultLike getUserLike(String openid) {
        return userService.getUserLike(openid);
    }

    /**
     * 获取用户的浏览记录
     */
    @RequestMapping("/getUserHistory")
    public ResultHistory getUserHistory(String openid) {
        return userService.getUserHistory(openid);
    }

}

class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public WxMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);
        setSupportedMediaTypes(mediaTypes);
    }

}
