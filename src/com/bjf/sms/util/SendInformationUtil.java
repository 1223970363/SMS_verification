package com.bjf.sms.util;

import com.google.gson.Gson;

import java.text.DecimalFormat;

public class SendInformationUtil {
    //用户名
    private static String Uid = "1223970363@qq.com";
    //接口安全秘钥
    private static String Key = "d41d8cd98f00b204e980";
    //手机号码，多个号码如13800000000,13800000001,13800000002    (private static String smsMob = "15390916742";)
    private static String smsMob = null;
    //短信内容 (private static String smsText = "白家福SMSSDK用例成功，验证码:557500";)
    private static String smsText = null;

    public static String getPhoneSendInformation(String Phone) {
        String head="您的验证码为:";
        String tail="欢迎您对SMS的测试";
        double num=Math.random()*89999+10000;
        //把double变为String
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String numstr=decimalFormat.format(num);

        HttpClientUtil client = HttpClientUtil.getInstance();
        //短信拼接
        smsMob=Phone;
        smsText=Phone+head+numstr+tail;
        System.out.println(smsText);
        //UTF发送
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
        return numstr;
    }
}
