package com.bjf.sms.test;

import com.bjf.sms.util.SendInformationUtil;

public class main {
     public static void main(String[] args) {
         String num=""+ SendInformationUtil.getPhoneSendInformation("15390916742");
         System.out.println(num);

     }
}
