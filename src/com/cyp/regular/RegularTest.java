package com.cyp.regular;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/29.
 */
public class RegularTest {
    public static void main(String[] args) {
        String baseUrl = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=100&nc=1488791629610&pid=hp&video=1";

        String ss = getJsonByInternet(baseUrl);
        System.out.println(ss);
        Pattern pattern = Pattern.compile("url\\\":\\\"(.*?)\\\"");
        Matcher matcher = pattern.matcher(ss);
        int g = matcher.groupCount();
        System.out.println(g);
        while(matcher.find()){
            String picUrl = "http://cn.bing.com"+matcher.group(1);
            System.out.println(picUrl);
            savePic(getInputStream(picUrl),picUrl.substring(picUrl.lastIndexOf("/")));
        }
    }
    public static String getJsonByInternet(String path){
        try {
                InputStream is =getInputStream(path);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while(-1 != (len = is.read(buffer))){
                    baos.write(buffer,0,len);
                    baos.flush();
                }
                return baos.toString("utf-8");
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static InputStream getInputStream(String path){
        try {
            URL url = new URL(path.trim());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(200 == urlConnection.getResponseCode()){
                return  urlConnection.getInputStream();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void savePic(InputStream inputStream, String fileName) {

        OutputStream os = null;
        try {
            String path = "D:\\testFile\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
