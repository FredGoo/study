package huiyu.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

/**
 * http请求帮助类
 * by kevin.yao
 */

public class HttpUtil {

    public static String post(String urlPath, String requestParams, String ContentType,
                              Map<String, String> headParams) {
        String result = "";
        BufferedReader reader = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new NonAuthenticationX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(urlPath);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(200000);
            conn.setReadTimeout(200000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            if (headParams != null) {
                for (String key : headParams.keySet()) {
                    conn.setRequestProperty(key, headParams.get(key));
                }
            }
            conn.setRequestProperty("Content-Type", ContentType);
            conn.setRequestProperty("accept", "*/*");

            // 往服务器里面发送数据
            if (requestParams != null && requestParams.length() > 0) {
                byte[] writebytes = requestParams.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(requestParams.getBytes());
                outwritestream.flush();
                outwritestream.close();

            } else {
                conn.setRequestProperty("Content-Length", "0");
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(0);
                outwritestream.flush();
                outwritestream.close();

            }
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}