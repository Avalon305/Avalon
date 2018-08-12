/**  
* <p>Title: HttpServerDemo.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月29日 下午5:54:35 
* @version 1.0  
*/  
package HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

/**  
* <p>Title: HttpServerDemo</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月29日 下午5:54:35 
*/

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
 
//jdk自带轻量级http server例子  http://127.0.0.1:8080/server
public class HttpServerDemo {
    public static void main(String[] args) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(8084);
        HttpServer server = HttpServer.create(addr, 0);
 
        server.createContext("/server", new MyHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server is listening on port 8080");
    }
}
 
class MyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("GET")) {
            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.set("Content-Type", "text/plain;charset=utf-8");
            // responseHeaders.set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, 0);
            
            OutputStream responseBody = exchange.getResponseBody();
            Headers requestHeaders = exchange.getRequestHeaders();
            Set<String> keySet = requestHeaders.keySet();
            Iterator<String> iter = keySet.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                List values = requestHeaders.get(key);
                String s = key + " = " + values.toString() + "\n";
                responseBody.write(s.getBytes());
            }
            responseBody.write("Hello world!测试中文字体这是自带的Http Server".getBytes());
            
            //接受请求的参数并处理
            URI requestedUri = exchange.getRequestURI();
            String query = requestedUri.getRawQuery();
            if(("password=123").equals(query)) {
            	responseBody.write("密码正确".getBytes());
            }
            
            responseBody.close();
        }
    }
}
