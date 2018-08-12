/**  
* <p>Title: PathTest.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年8月4日 下午7:08:01 
* @version 1.0  
*/  
package java7;

/**  
* <p>Title: PathTest</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年8月4日 下午7:08:01 
*/

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        //在传统java.io中， 文件和目录都被抽象成File对象， 即 File file = new File(".");
        //NIO.2中则引入接口Path代表与平台无关的路径，文件和目录都用Path对象表示
        //通过路径工具类Paths返回一个路径对象Path
        Path path = Paths.get("D:\\eclipse ee\\workspace\\ThreadPoolDemo\\Stream.xml");
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径： "+path.getRoot());
        //path的绝对路径
        //对比传统java.io, 取绝对路径 file.getAbsoluteFile()
        Path absolutePath = path.toAbsolutePath();
        System.out.println("path的绝对路径：");
        System.out.println(absolutePath);
        System.out.println("absolutePath的根路径： "+absolutePath.getRoot());
        System.out.println("absolutePath里包含的路径数量：" + absolutePath.getNameCount());
        
        System.out.println("根据元素序号获得路径名："+absolutePath.getName(0));
        //以多个String来构建path
        Path path2 = Paths.get("d:", "publish" , "codes");
        System.out.println(path2);
        

        
    }
}