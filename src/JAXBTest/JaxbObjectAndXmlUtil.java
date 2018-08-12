/**  
* <p>Title: JaxbObjectAndXmlUtil.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: </p>  
* @author CQZ 
* @date 2018年7月29日 下午12:20:44 
* @version 1.0  
*/  
package JAXBTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.KeyStore.Entry.Attribute;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

//import com.google.gson.Gson;

/**  
* <p>Title: JaxbObjectAndXmlUtil</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年7月29日 下午12:20:44 
*/
public class JaxbObjectAndXmlUtil {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @date 2018年7月29日 下午12:20:44
	 * @param args  
	 * @throws XMLStreamException 
	 */
	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub
	         /** 构造测试报Client对象 */
	     	TbClient tbClient = new TbClient();
	     	tbClient.setAuthStatus(1);
	     	tbClient.setCity("青岛市");
	     	tbClient.setClientId("305865088");
	     	tbClient.setOrganizationName("青岛科技大学");
	     	
	        /** 构造测试报User对象 */
	     	TbUser user = new TbUser();
	     	user.setId(123);
	        user.setName("Avalon");
	        user.setPassword("66666666305");
	        user.setRemark("JAXB测试");
	        user.setPhone("我的电话号码");
	        
	        ClientCustom clientCustom = new ClientCustom();
	        clientCustom.setTbclient(tbClient);
	        clientCustom.setTbUser(user);
	         
	        //Gson gson = new Gson();
	        
	        String xmlStr = JaxbObjectAndXmlUtil.object2Xml(clientCustom);//构造报文 XML 格式的字符串
	        System.out.println("对象转xml报文： \n"+xmlStr);
	        //创建一个输出流
	        Writer out;
	        try {
	        	//用于格式化xml内容和设置头部标签
	        	OutputFormat format = OutputFormat.createPrettyPrint();
	        	out = new FileWriter("D://eclipse ee//workspace//ThreadPoolDemo//src//xml//ClientCustom5.xml");
	        	//将xml转为document文件
				Document document = DocumentHelper.parseText(xmlStr);
				//创建一个dom4j创建xml的对象
				XMLWriter writer = new XMLWriter(out, format);
				
				
				//调用dom4j的write方法将doc文档写到指定路径
				writer.write(document);
				//dom4j用close
				writer.close();
				
				//使用IO流生成XML文件
				FileOutputStreamTest(xmlStr);
				
				System.out.println("生成XML文件成功");
//				//XMLStreamWriter创建XML对象
//				XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
//				//XML头  
//	            writer.writeStartDocument("UTF-8", "1.0");  
//				//正文  
//	            writer.writeStartElement("person");  
//	            writer.writeStartElement("id");  
//	            writer.writeCharacters("1");  
//	            writer.writeEndElement();  
//	            writer.writeEndElement();  
//	            //刷新流到目标  
//	            writer.flush();  
				
				
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("生成xml文件失败");
				e.printStackTrace();
			} 
	        
	        ClientCustom msgBean2 = JaxbObjectAndXmlUtil.xml2Object(xmlStr, ClientCustom.class);
	       // System.out.println("报文转xml转对象： \n"+gson.toJson(msgBean2));
	        //StAX写XML文档
	        StAXTest();
	        //msgBean2.listAllByXMLEventReader();
	    }
	
	/**
     * @param xmlStr 字符串
     * @param c 对象Class类型
     * @return 对象实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T xml2Object(String xmlStr,Class<T> c){
     
        try
        {
            JAXBContext context = JAXBContext.newInstance(c); 
            Unmarshaller unmarshaller = context.createUnmarshaller(); 
             
            T t = (T) unmarshaller.unmarshal(new StringReader(xmlStr)); 
             
            return t; 
             
        } catch (JAXBException e) {
        	e.printStackTrace();  return null; 
        	} 
         
    } 
       
    /**
     * @param object 对象
     * @return 返回xmlStr
     */
    public static String object2Xml(Object object)
    { 
        try
        {   
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(object.getClass()); 
            Marshaller  marshal = context.createMarshaller();
             
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //是否格式化输出 即按标签自动换行，否则即是一行的xml
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8 
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息 
            marshal.setProperty("jaxb.encoding", "utf-8"); 
            marshal.marshal(object,writer);
             
            return new String(writer.getBuffer());
             
        } catch (Exception e) { e.printStackTrace(); return null;}    
         
    } 

    // 列出所有信息
 	@SuppressWarnings("unchecked")
 	public static void listAllByXMLEventReader() {
 		String xmlFile = ClientCustom.class.getResource("/").getFile()
 				+ "ClientCustom.xml";
 		XMLInputFactory factory = XMLInputFactory.newInstance();
 		try {
 			// 创建基于迭代器的事件读取器对象
 			XMLEventReader reader = factory
 					.createXMLEventReader(new FileReader(xmlFile));
 			// 遍历XML文档
 			while (reader.hasNext()) {
 				XMLEvent event = reader.nextEvent();
 				// 如果事件对象是元素的开始
 				if (event.isStartElement()) {
 					// 转换成开始元素事件对象
 					StartElement start = event.asStartElement();
 					// 打印元素标签的本地名称
 					System.out.print(start.getName().getLocalPart());
 					// 取得所有属性
 					Iterator attrs = start.getAttributes();
 					while (attrs.hasNext()) {
 						// 打印所有属性信息
 						Attribute attr = (Attribute) attrs.next();
 						System.out.print(":" + attr.getName()
 								+ "=" + attr.getValue());
 					}
 					System.out.println();
 				}
 			}
 			reader.close();
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (XMLStreamException e) {
 			e.printStackTrace();
 		}
 	}
	
 	public static void StAXTest() {
		try {
			XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
			xsw.writeStartDocument("UTF-8", "1.0");
			xsw.writeEndDocument();
			//正文  
			xsw.writeStartElement("person");
			xsw.writeCharacters("CQZ"); 
			xsw.writeEndElement();
			xsw.writeStartElement("id");  
			xsw.writeCharacters("1"); 
			xsw.writeEndElement();
			xsw.flush();
			xsw.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	public static void FileOutputStreamTest(String str) throws FileNotFoundException {
		File file =new File("D:\\eclipse ee\\workspace\\ThreadPoolDemo\\src\\xml","Stream.xml");
		
		//创建FileOutputStream流对象
		FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(file);
			//写入数据
			fos.write(str.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//关闭输出流
			try {
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
