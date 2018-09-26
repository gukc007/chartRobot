package com.chartRobot.service;

import com.chartRobot.common.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

/**
 * Created by admin on 2018/9/26.
 */
public class WebRequestService {

    private static HttpClient client = HttpClients.createDefault();
    private static ObjectMapper mapper = new ObjectMapper();

    public static String getTuLingMessage(String info) throws Exception {
        String url = Constants.tuLingUrl + info;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");

        JsonNode jsonNode = mapper.readTree(str);
        return jsonNode.get("text").toString();
    }

    public static HttpGet createGet(String url) throws Exception {
        HttpGet httpGet;

        httpGet = new HttpGet();

        return httpGet;
    }
}
