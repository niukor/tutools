package com.tutools.tutools.util;


import com.tutools.tutools.util.baidu.Base64Util;
import com.tutools.tutools.util.baidu.FileUtil;
import com.tutools.tutools.util.baidu.HttpUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;

/**
 * 通用文字识别
 */
public class GeneralBasic {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String generalBasic() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        try {
            // 本地文件路径
            String filePath = "src/image.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.d544e143270a6823f7c2ab56e77bea05.2592000.1617263192.282335-23726594";

            String result = HttpUtil.post(url, accessToken, param);
            FileOutputStream fo = new FileOutputStream(new File("aa.txt"));
            fo.write(result.getBytes());
            fo.flush();
            fo.close();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        GeneralBasic.generalBasic();
    }
}