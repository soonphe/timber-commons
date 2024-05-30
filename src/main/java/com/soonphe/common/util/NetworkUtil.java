package com.soonphe.common.util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络工具类
 *
 * @author soonphe
 * @since 1.0
 */
public class NetworkUtil {

    private static URL urlStr;
    private static HttpURLConnection connection;
    private static int state = -1;
    private static boolean succ;

    /**
     * 功能描述 : 检测当前URL是否可连接或是否有效,
     * 最多连接网络 5 次, 如果 5 次都不成功说明该地址不存在或视为无效地址.
     *
     * @param url 指定URL网络地址
     * @return String
     */
    public static synchronized boolean isConnect(String url) {
        int counts = 0;
        succ = false;
        if (url == null || url.length() <= 0) {
            return succ;
        }
        while (counts < 5) {
            try {
                urlStr = new URL(url);
                connection = (HttpURLConnection) urlStr.openConnection();
                state = connection.getResponseCode();
                if (state == 200) {
                    succ = true;
                }
                break;
            } catch (Exception ex) {
                continue;
            }
        }
        return succ;
    }

}
