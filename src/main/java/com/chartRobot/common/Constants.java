package com.chartRobot.common;

/**
 * Created by admin on 2018/9/26.
 */
public class Constants {

    public static final String TU_LING_URL = "http://www.tuling123.com/openapi/api?key=77aa5b955fcab122b096f2c2dd8434c8&info=";

    public static final String QQ_NUMBER = "2337017911";

    //测试是否需要验证码 返回的第一个参数为1则需要验证码 第一个参数为0则不需要验证码
    public static final String IDENTIFYING_CODE_TEST = "https://ssl.ptlogin2.qq.com/check?pt_tea=1&uin=" + QQ_NUMBER
            + "&appid=501004106&js_ver=10124&js_type=0&login_sig=&u1=http%3A%2F%2Fw.qq.com%2Fproxy.html&r=0.7602819891180843";

    public static final String LOGIN_URL = "https://ssl.ptlogin2.qq.com/login?u=" + QQ_NUMBER
            + "&p=%s&verifycode=%s&webqq_type=10&remember_uin=1&login2qq=1&aid=501004106&u1=http%3A%2F%2Fw.qq.com%2Fproxy.html%3Flogin2qq%3D1%26webqq_type%3D10&h=1&ptredirect=0&ptlang=2052&daid=164&from_ui=1&pttype=1&dumy=&fp=loginerroralert&action=0-21-1678643&mibao_css=m_webqq&t=1&g=1&js_type=0&js_ver=10124&login_sig=&pt_randsalt=0&pt_vcode_v1=0&pt_verifysession_v1=h02b7eJxn9dCCZ7wQZlVNWbqweqLVaYgWImcVohr2v5ZchM7IPhi63jNnSDf3O5gQ7SErLwoT_CD_iJoNLBiZH3WypEcSVAUNo1";

}
