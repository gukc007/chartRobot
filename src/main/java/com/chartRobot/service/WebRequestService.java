package com.chartRobot.service;

import com.chartRobot.common.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/26.
 */
public class WebRequestService {

    private static HttpClient client = HttpClients.createDefault();
    private static ObjectMapper mapper = new ObjectMapper();

    public static String getTuLingMessage(String info) throws Exception {
//        String url = Constants.TU_LING_URL + URLEncoder.encode(info, "utf-8");
        Map<String, String> param = new HashMap<>();
        param.put("key", Constants.TU_LING_KEY);
        param.put("info", info);
        HttpGet httpGet = createGet(Constants.TU_LING_URL, toFormData(param));
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");

        JsonNode jsonNode = mapper.readTree(str);
        return jsonNode.get("text").asText();
    }

//    public static String getTuLingMessage(String info, String userId) throws Exception {
//        String url = Constants.TU_LING_URL + URLEncoder.encode(info, "utf-8");
//        HttpGet httpGet = createGet(url);
//        HttpResponse response = client.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        String str = EntityUtils.toString(entity, "UTF-8");
//
//        JsonNode jsonNode = mapper.readTree(str);
//        return jsonNode.get("text").asText();
//    }

    public static HttpGet createGet(String url, List<NameValuePair> para) throws Exception {
        HttpGet httpGet;

        if (para != null) {
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(para, Charset.forName("UTF-8")));
        }

        httpGet = new HttpGet(url);

        return httpGet;
    }

    public static HttpPost createPost(String url, List<NameValuePair> para) throws Exception {
        HttpPost httpPost;
        httpPost = new HttpPost(url);
        if (para != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(para, Charset.forName("UTF-8")));
        }
        return httpPost;
    }

    /**
     * 格式化数据
     *
     * @param map
     * @return
     * @throws Exception
     */
    private static List<NameValuePair> toFormData(Map<String, String> map) throws Exception {
        List<NameValuePair> formData = new ArrayList<>();
        if (map != null) {
            for (String key : map.keySet()) {
                formData.add(new BasicNameValuePair(key, map.get(key)));
            }
        }
        return formData;
    }
}
