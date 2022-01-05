package com.http;

import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpCallerException;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.utils.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个Http SDK编程示例，如何使用HttpCaller向服务端发送POST/GET的请求
 *
 * @author austin.zhang
 */
public class HttpSDKTest {

    /**
     * 服务调用
     * @param httpUrl 请求接口
     * @param reqMethod 使用get/post提交请求
     * @param params 请求参数
     * @return
     */
    public static String request(String httpUrl, String reqMethod, Map<String, String> params, String version) {
        if(httpUrl == null || reqMethod == null || params == null){
            return null;
        }
        String API_NAME = "QueryService";
        String ak = "ak";
        String sk = "sk";
        String result = "";

        System.out.println("testJson request url: " + httpUrl);
        System.out.println("reqMethod: " + reqMethod);
        System.out.println("ak: " + ak);
        System.out.println("sk: " + sk);
        System.out.println("params: " + params.toString());
        System.out.println("version: " + version);

        try {
            if("get".equalsIgnoreCase(reqMethod)){
                result = HttpCaller.doGet(httpUrl, API_NAME, version, params, ak, sk);
            }else if("post".equalsIgnoreCase(reqMethod)){
                result = HttpCaller.doPost(httpUrl, API_NAME, version, params, ak, sk);
            }

            if (!StringUtils.isEmpty(result)) {
                // 返回结果处理, 如转换为JSON对象
                result = new String(result.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            }
        } catch (HttpCallerException e) {
            // 调用异常处理
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String httpUrl = "网络地址";
        // UAT
        String reqMethod = "POST";
        String version = "1.0.0";

        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("terrainName", "");
        jsonObject2.put("startTime", "2021-12-11 00:00:00");
        jsonObject2.put("endTime", "2021-12-12 23:00:00");
        jsonObject1.put("header", jsonObject2);

        Map<String, String> params = new HashMap<>();
        params.put("startFKYYWebservice", jsonObject1.toString());

        try {
            String res1 = request(httpUrl, reqMethod, params, version);
            System.out.println("返回结果：" + res1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
