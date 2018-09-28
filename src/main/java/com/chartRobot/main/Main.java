package com.chartRobot.main;

import com.chartRobot.common.Constants;
import com.chartRobot.model.TuLingMessage;
import com.chartRobot.service.WebRequestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.scienjus.smartqq.callback.MessageCallback;
import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.model.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
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
            info = sc.nextLine();
            TuLingMessage tuLingMessage = WebRequestService.getTuLingMessage(info, "2337017911233");
            System.out.println(name + " : " + tuLingMessage.getText());
//            info = answer;
            count ++;
        }

//        Receiver receiver = new Receiver();
    }

    private static void testQQ2() throws Exception {
        //创建一个新对象时需要扫描二维码登录，并且传一个处理接收到消息的回调，如果你不需要接收消息，可以传null
        SmartQQClient client = new SmartQQClient(new MessageCallback() {
            public void onMessage(Message message) {
                System.out.println(message.getContent());
            }

            public void onGroupMessage(GroupMessage message) {
                System.out.println(message.getContent());
            }

            public void onDiscussMessage(DiscussMessage message) {
                System.out.println(message.getContent());
            }
        });
        //登录成功后便可以编写你自己的业务逻辑了
        List<Category> categories = client.getFriendListWithCategory();
        for (Category category : categories) {
            System.out.println(category.getName());
            for (Friend friend : category.getFriends()) {
                System.out.println("————" + friend.getNickname());
            }
        }
        //使用后调用close方法关闭，你也可以使用try-with-resource创建该对象并自动关闭
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 不推荐使用帐号密码登录
     *
     * @throws Exception
     */
    @Deprecated
    private static void testQQ() throws Exception {
        BasicHttpContext localContext = new BasicHttpContext();
        CloseableHttpClient client = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        String url = Constants.IDENTIFYING_CODE_TEST;
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = client.execute(httpGet, localContext);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");
        String[] strs = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).split(",");
        if (strs[0].equals("\'0\'")) {
            //不需要图片验证码，直接提取
            String verifyCode = strs[1].replaceAll("\'", "");
            httpGet = new HttpGet(getLoginUrl("123456", verifyCode));
            response = client.execute(httpGet, localContext);

        }
        System.out.println(str);
    }

    private static String getLoginUrl(String password, String verifyCode) throws Exception {
        String url = Constants.LOGIN_URL;
        return String.format(url, password, verifyCode);
    }
}
