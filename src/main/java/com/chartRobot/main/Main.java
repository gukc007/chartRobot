package com.chartRobot.main;

import com.chartRobot.common.Constants;
import com.chartRobot.service.WebRequestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Scanner;

/**
 * Created by admin on 2018/9/26.
 */
public class Main {

    public static void main(String[] agrs) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int i = 1;
        String name;
        String info = "你好";
        while (count < 30) {
            if (i == 1) {
                name = "A";
                i = 2;
            } else {
                name = "B";
                i = 1;
            }
//            String info = sc.nextLine();
            String answer = WebRequestService.getTuLingMessage(info);
            System.out.println(name + " : " +answer);
            info = answer;
            count ++;
        }
    }
}
