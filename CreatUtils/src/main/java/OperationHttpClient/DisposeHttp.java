package OperationHttpClient;

import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class DisposeHttp {
    public static Logger logger = Logger.getLogger(DisposeHttp.class);


    /**
     * 传给action访问内容，返回json格式，并解析ResponseHandlerh获取结果
     * @param arg
     * @throws IOException
     */
    public  static  void main(String[] arg) throws IOException {
//        HttpClient httpclient = HttpClients.createDefault();
        String url = "http://www.baidu.com";
        Map<String,String> map= new HashMap<String, String>();
        map.put("name","张三");
        JSONObject s=   action(url,map);
        resolve(s);
//        HttpPost post=new HttpPost(url);
//
//        post.addHeader("name","张三");
//        HttpRequest request=null;
//         HttpResponse response= httpclient.execute(post);

    }
    /**
     * 获取request
     * @throws IOException
     */
    @Test
    public     void testgetresponse() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = httpclient.execute(httpget);  //获取响应对象
        try {
          System.out.println(response.getAllHeaders());
        }catch (Exception ex)
        { }
        finally{
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取url
     */
    @Test
     public  void  testhttp()
     {
         try {
             URI uri=new URIBuilder().setScheme("HTTP").setHost("wwww.baidu.com").setPath("/sss").build();
             HttpGet httpGet=new HttpGet(uri);
             HttpPost httpPost=new HttpPost(uri);
             logger.debug("Git:"+httpGet);
             logger.info("Post:"+httpPost);
         } catch (URISyntaxException e) {
             e.printStackTrace();
         }

     }
    /**
     * 返回404状态
     */
    @Test
    public void  testresponse()
    {   CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.baidu.com");
        try {
            CloseableHttpResponse response = httpclient.execute(httpget);  //获取响应对象
            response.setStatusCode(404);
            logger.trace(response.getStatusLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 抓取页面
     */
    @Test
    public  void testgethtml()
    {
        //目标页面
        String url = "http://localhost:8080/devoops/index.html#ajax/page_invoices.html?station=1&name=1";
        //创建一个默认的HttpClient
        HttpClient httpclient = new DefaultHttpClient();
        try {
            //以get方式请求网页http://www.yshjava.cn
            HttpGet httpget = new HttpGet(url);
            //打印请求地址
            System.out.println("executing request " + httpget.getURI());
            //创建响应处理器处理服务器响应内容
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            //执行请求并获取结果
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
            httpclient.getConnectionManager().shutdown();
        }

    }

    /**
     * 获取请求信息，返回json格式
     */
    public static JSONObject action(String url ,Map<String,String> map)
    {
         JSONObject obj = new JSONObject();
         obj.put("url",url);
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
            obj.put(key,map.get(key));
        }
        obj.toString();
        return obj;
    }

    /**
     * 获取json格式请求，并进行相应
     * @param request
     */
    public  static void resolve(JSONObject request)
    {        HttpClient httpclient = HttpClients.createDefault();
        //以post方式请求网页
        HttpPost httppost = new HttpPost(request.getString("url"));
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Iterator iterator= request.keys();
        while(iterator.hasNext()){
            int i=0;
            String  key = (String) iterator.next();
            nvps.add(new BasicNameValuePair((String) iterator.next(),request.getString(key)));
        }

        //将POST参数以UTF-8编码并包装成表单实体对象
        try {
            httppost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //打印请求地址
        logger.info("executing request " + httppost.getRequestLine().getUri());
        //创建响应处理器处理服务器响应内容
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        //执行请求并获取结果
        String responseBody = null;
        try {
            responseBody = httpclient.execute(httppost, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("----------------------------------------");
        logger.info(responseBody);
        logger.info("----------------------------------------");
}
    /**
     * log4j应用
     */
    @Test
     public  void  testlog4j()
     {
         PropertyConfigurator.configure("D:\\ideaproject\\CreatUtils\\src\\main\\resources\\log4j2.xml");
         logger.trace("trace：    1");
         logger.debug("debug：     2");
         logger.info("info:        3");
         logger.warn("warn:        4");
         logger.error("error:      5");
         logger.fatal("fatal        6");
     }

}
