package cn.hfbin.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AuthUtil {
    public  static  final  String APPID ="wx40baff75b2fd6a91";
    public  static  final  String APPSECRET ="cf6d160c5cd4e43100e369a65af5734e";
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null ;

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet httpClient = new HttpGet(url);

        HttpResponse response = client.execute(httpClient);

        HttpEntity entity = response.getEntity();

        if(entity != null){
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
            System.out.println("AuthUtil(jsonObject) = "+jsonObject);

        }

        httpClient.releaseConnection();
        return jsonObject;
    }

}
