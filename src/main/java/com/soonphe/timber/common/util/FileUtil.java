package com.soonphe.timber.common.util;

import java.io.*;

/**
 * 文件操作工具类
 *
 * @author soonphe
 * @since 1.0
 */
public class FileUtil {

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * @param path 文件路径
     * @param fileName 文件名称
     * @return
     */
    public static String readFile(String path, String fileName) {
        String substring = path.substring(path.length()-1);
        if (!"/".equals(substring)){
            path = path + "/";
        }
        return readFile(path+fileName);
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * @param fileName 文件全限定名（包含文件路径）
     * @return
     */
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString).append("\r\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }
        return sb.toString();
    }

    /**
     * 文件写入
     * @param fileName 文件全限定名
     * @param fileContent 问价内容
     * @return
     */
    public static int writeFile(String fileName, String fileContent) {
        String path = fileName.substring(0, fileName.lastIndexOf("/"));
        return writeFile(path,  fileName, fileContent, true);
    }

    /**
     * 文件写入
     *
     * @param path        文件存放地址
     * @param fileName    文件名称
     * @param fileContent 文件内容
     * @param append 是否追加写入 true表示追加
     * @return
     */
    public static int writeFile(String path, String fileName, String fileContent, boolean append) {
        int flag = 0;
        try {
            createFileDir(path);
            File file = new File(path + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file, append), "UTF-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(fileContent);
            writer.newLine();
            writer.close();
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 文件路径标准化处理
     * @param path
     * @param fileName
     * @return
     */
    public static String filePathStandard(String path, String fileName){
        String substring = path.substring(path.length()-1);
        if (!"/".equals(substring)){
            path = path + "/";
        }
        return path + fileName;
    }

    /**
     * 校验文件是否存在
     * @param path 文件路径
     * @param fileName 文件名
     * @return
     */
    public static boolean checkFileExist(String path, String fileName) {
        return checkFileExist(path + fileName);
    }

    /**
     * 校验文件是否存在
     * @param path 文件全限定名
     * @return
     */
    public static boolean checkFileExist(String path) {
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 新建文件夹，不存在则创建
     * @param path
     */
    public static void createFileDir(String path) {
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
    }

    /**
     * 删除文件
     *
     * @param pathName 文件路径名称
     */
    public static void delete(String pathName) {
        File dest = new File(pathName);
        if (dest.exists()){
            dest.delete();
        }
    }

}
