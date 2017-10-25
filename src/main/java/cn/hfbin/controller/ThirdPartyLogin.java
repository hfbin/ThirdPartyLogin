package cn.hfbin.controller;

import cn.hfbin.beans.User;
import cn.hfbin.utils.AuthUtil;
import cn.hfbin.utils.Msg;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@Controller
public class ThirdPartyLogin {

    @RequestMapping("/index")
    public String  index(){
        return "index";
    }

    @RequestMapping("/wxlogin")
    public String  wxLogin(){
        System.out.println("wxLogin");
        String backUrl = "http://hfbin.iok.la/ThirdPaytyLogin/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + AuthUtil.APPID+
                "&redirect_uri=" + URLEncoder.encode(backUrl)+
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        return  "redirect:"+url;
    }

    @RequestMapping("/callBack")
    public String callBack(HttpServletRequest request , HttpServletResponse response) throws IOException {
        System.out.println("callBack");
        String code =request.getParameter("code");
        System.out.println("code = "+code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" +AuthUtil.APPID+
                "&secret=" + AuthUtil.APPSECRET+
                "&code=" +code+
                "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        System.out.println(jsonObject.toString());
        String openid = jsonObject.getString("openid");
        String access_token = jsonObject.getString("access_token");
        System.out.println("openid = "+ openid  +"access_token = "+access_token);
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" +access_token+
                "&openid=" +openid+
                "&lang=zh_CN";
        JSONObject userinfo = AuthUtil.doGetJson(infoUrl);
        User user = new User();
        user.setName(userinfo.getString("nickname"));
        user.setAddreas(userinfo.getString("country")+userinfo.getString("province")+userinfo.getString("city"));
        user.setSex(userinfo.getInteger("sex"));
        user.setData(new Date());
        user.setOpenid(openid);
        user.setHeadimgurl(userinfo.getString("headimgurl"));
        System.out.println(user);
        return "user";
    }
    //{"country":"中国","province":"广西","city":"钦州","openid":"onUWn0TUNElnlHwHliJBHokJh7Fw",
    // "sex":1,"nickname":"HUANGFUBIN",
    // "headimgurl":"http://wx.qlogo.cn/mmhead/3a3QxMHZ8Yxr5CHWJ3K0gFgcPvSR7NsYcjKv5hYP6j9bBa5Hhxs8Jw/0","language":"zh_CN","privilege":[]}

}
