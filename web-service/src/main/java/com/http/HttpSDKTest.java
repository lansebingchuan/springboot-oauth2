package com.http;

import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpCallerException;
import com.alibaba.fastjson.JSONObject;

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
        String API_NAME = "VisitorDataQueryService";
        String ak = "b9913276298642dea70515f18741d616";
        String sk = "E2Xh6ZiV9I5h1BjN/C/ExY+ohNM=";
        String result = null;

        System.out.println("testJson request url: " + httpUrl);
        System.out.println("reqMethod: " + reqMethod);
        System.out.println("ak: " + ak);
        System.out.println("sk: " + sk);
        System.out.println("params: " + params.toString());
        System.out.println("version: " + version);

        try {
            if("get".equals(reqMethod.toLowerCase())){
                result = HttpCaller.doGet(httpUrl, API_NAME, version, params, ak, sk);
            }else if("post".equals(reqMethod.toLowerCase())){
                result = HttpCaller.doPost(httpUrl, API_NAME, version, params, ak, sk);
            }

            if (result != null) {
                // 返回结果处理, 如转换为JSON对象
            }
        } catch (HttpCallerException e) {
            // 调用异常处理
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String httpUrl = "https://api-csb-broker.boe.com.cn:8086/test";
        // UAT
        String reqMethod = "POST";
        String version = "1.0.0";

        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("terrainName", "");
        jsonObject2.put("startTime", "2021-12-11 00:00:00");
        jsonObject2.put("endTime", "2021-12-12 23:00:00");
        jsonObject1.put("header", jsonObject2);

        Map<String, String> params = new HashMap<String, String>();
        params.put("startFKYYWebservice", jsonObject1.toString());

        try {
            String res1 = request(httpUrl, reqMethod, params, version);
            String res = new String(res1.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("返回结果："+res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
