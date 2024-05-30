package com.soonphe.common.util;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

/**
 * IP工具类
 *
 * @author soonphe
 * @since 1.0
 */
public final class IPUtil {
    /**
     * 取到当前机器的IP地址
     */
    public static String getIp() {
        String hostIp;
        List<String> ips = new ArrayList<>();
        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = netInterfaces.nextElement();
                Enumeration<InetAddress> inteAddresses = netInterface.getInetAddresses();
                while (inteAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inteAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        ips.add(inetAddress.getHostAddress());
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        hostIp = collectionToDelimitedString(ips, ",");
        return hostIp;
    }

    private static String collectionToDelimitedString(Collection<String> coll, String delim) {
        if (coll == null || coll.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    /**
     * 获取服务器名称
     */
    public static String getHostName() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostName;
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
//    public static String getIp(HttpServletRequest request) {
//        String szClientIP = request.getHeader("x-forwarded-for");
//        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
//            szClientIP = request.getHeader("Proxy-Client-IP");
//        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
//            szClientIP = request.getHeader("WL-Proxy-Client-IP");
//        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
//            szClientIP = request.getRemoteAddr();
//        return szClientIP;
//    }
//
//    public static String getIp2(HttpServletRequest request) {
//        String ip = request.getHeader("X-Forwarded-For");
//        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
//            //多次反向代理后会有多个ip值，第一个ip才是真实ip
//            int index = ip.indexOf(",");
//            if (index != -1) {
//                return ip.substring(0, index);
//            } else {
//                return ip;
//            }
//        }
//        ip = request.getHeader("X-Real-IP");
//        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
//            return ip;
//        }
//        return request.getRemoteAddr();
//    }
}
