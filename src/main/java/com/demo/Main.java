package com.demo;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        //URI uri = new URI("https%3A%2F%2Fwww.flipkart.com%2Fama%3Fid%3DSU-NF1DC%26moe_app_id%3D87XB87XQCJSFVDNDYN08355S_DEBUG%26gcm_notificationType%3Dgcm_webNotification%26moe_cid_attr%3D%257B%2522moe_campaign_id%2522%253A%2522000000000000000054083476%2522%252C%2522moe_campaign_channel%2522%253A%2522Push%2522%252C%2522moe_delivery_type%2522%253A%2522One%2520Time%2522%257D%26push_from%3Dmoengage%26MOE_NOTIFICATION_ID%3D17995%26moe_isDefaultAction%3Dtrue%26MOE_MSG_RECEIVED_TIME%3D1686302493938%26gcm_alert%3DTest%2520notification%26gcm_title%3DTest%2520message%26gcm_webUrl%3Dhttps%253A%252F%252Fwww.shopsy.in%252Fama%253Fid%253DSU-NF1DC%26gcm_campaign_id%3D000000000000000054083476_L_0%26moe_channel_id%3Dmoe_default_channel");

        List<Test> mainList = new ArrayList<>();

        mainList.add(new Test());
        mainList.add(new Test());
        mainList.add(new Test());

        List<Test> subList = new ArrayList<>();

        subList.add(mainList.get(0));
        subList.add(mainList.get(1));

        System.out.println(mainList);
        mainList.clear();

        System.out.println(subList);

    }
}

class Test {
    public String ok = "hi";
}
