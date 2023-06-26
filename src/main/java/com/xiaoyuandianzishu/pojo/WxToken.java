package com.xiaoyuandianzishu.pojo;

import lombok.Data;

@Data
public class WxToken {

    private String openid; // 用户唯一标识
    private String session_key; // 会话密钥
    private String unionid;
    private String errcode; // 错误码
    private String errmsg; // 错误信息

    @Override
    public String toString() {
        return "openid="+openid+"\nsession_key="+session_key+"\nunionid="+unionid+"\nerrcode="+errcode+"\nerrmsg="+errmsg;
    }

}
