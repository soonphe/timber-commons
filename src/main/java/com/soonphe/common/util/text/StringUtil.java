package com.soonphe.common.util.text;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author soonphe
 * @since 1.0
 */
public class StringUtil {

    private static Pattern pattern = Pattern.compile("[^0-9]");

    /**
     * 字符串判空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return !isNotEmpty(str);
    }

    /**
     * 字符串判断不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if (str == null || "".equals(str)){
            return false;
        }
        return true;
    }

    /**
     * 判断是否是整数
     *
     * @param integer
     * @return
     */
    public static boolean isInteger(String integer) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher(integer);
        boolean b = m.matches();
        return b;
    }

    /**
     * 判断是否是正整数
     *
     * @param integer
     * @return
     */
    public static boolean isPositiveInteger(String integer) {
        Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        Matcher m = p.matcher(integer);
        boolean b = m.matches();
        return b;
    }

    /**
     * 把前台传过来的含中文的url字符串转换成标准中文，比如%25E5%258C%2597%25E4%25BA%25AC转换成北京
     */
    public static String decodeUrl(String url) {
        if (isEmpty(url)){
            return "";
        }
        String str = "";
        try {
            str = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 把比如北京转换成%25E5%258C%2597%25E4%25BA%25AC
     */
    public static String encodeUrl(String url) {
        if (isEmpty(url)){
            return "";
        }
        String str = "";
        try {
            str = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 把字符串里面的\r \n \\替换掉，json处理
     *
     * @param str
     * @return
     */
    public static String dealJsonFormat(String str) {
        str = str.replace("\r", "");
        str = str.replace("\n", "");
        str = str.replace("\\\\", "");
        return str;
    }

    /**
     * 把字符串里面的"-"和空格" "替换掉，并截取年月日成八位数日期字符串（18点日期格式），日期处理
     *
     * @param str
     * @return
     */
    public static String dealDateFormat(String str) {
        str = str.replace("-", "");
        str = str.replace(" ", "");
        str = str.substring(0, 8);
        return str;
    }

    /**
     * 格式化小数
     *
     * @param val
     * @param point 小数位
     * @return
     */
    public static String formatDouble(String val, int point) {
        String str = "";
        DecimalFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(point);
        str = nf.format(Double.parseDouble(val));
        return str.replace(",", "");
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length int 设定所取出随机数的长度
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 获取指定长度日期字符串
     *
     * @param length
     * @return
     */
    public static String getDateStr(int length) {
        DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateformat.format(new Date());
        String strTime = strDate.substring(length);
        return strTime;
    }

    /**
     * 获取指定长度日期字符串+随机字符串
     *
     * @return
     */
    public static String getDateNonceStr(int dateLength, int length) {
        String dateStr = getDateStr(dateLength);
        String strRandom = buildRandom(length) + "";
        return dateStr + strRandom;
    }

    /**
     * 格式化金钱，默认四舍五入
     *
     * @param val
     * @param point 小数位
     * @return
     */
    public static String formatMoney(double val, int point) {
        String patten = "#,###";
        if (point>0){
            patten = patten + ".";
        }
        for (int i=0;i<point;i++){
            patten = patten + "#";
        }
        NumberFormat nf = new DecimalFormat(patten);
        String str = nf.format(val);
        return str;
    }

    /**
     * 元转换成分
     *
     * @param amount
     * @return
     */
    public static int getMoney(float amount) {
        Float f = new Float(Math.round(amount * 100));
        int fen = f.intValue();
        return fen;
    }

    /**
     * 过滤表情
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (isNotEmpty(source)) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
        } else {
            return source;
        }
    }

    /**
     * 十六进制字符串转数字
     *
     * @param str
     * @return
     */
    public static int hexTrans(String str) {
        return Integer.parseInt(str.replaceAll("^0[x|X]", ""), 16);
    }

    /**
     * 获取16位uuid
     * @return
     */
    public static String genSixteenUUId() {
        //最大支持1-9个集群机器部署
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if(hashCodeV < 0) {
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

}
