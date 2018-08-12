package JAXBTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyStore.Entry.Attribute;
import java.sql.Timestamp;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

@XmlRootElement(name="client_custom")
/**  
* <p>Title: ClientCustom</p>  
* <p>Description: </p>  
* @author CQZ  
* @date 2018年3月6日  
*/  
public class ClientCustom extends TbClient{

	/** serialVersionUID*/ 
	private static final long serialVersionUID = 1L;
	

	//锁定/解锁按钮的返回结果（操作成功或者操作失败）
	private String result;
	//查询条件：创建起始时间
	private Timestamp dateStart;
	//查询条件：终止时间
	private Timestamp dateEnd;
	//当前页数
	private Integer pageNumber;
	//每页显示的条数
	private Integer pageSize;
	//开始查询的id
	private Integer idStart;
	//TbClient
	//@XmlElement(name="TbClient")
	private TbClient tbclient;
	//@XmlElement(name="TbUser")
	private TbUser tbUser;
	
	
	@XmlElement(name="TbClientNameTest")
	public TbClient getTbclient() {
		return tbclient;
	}

	public void setTbclient(TbClient tbclient) {
		this.tbclient = tbclient;
	}

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getIdStart() {
		return idStart;
	}

	public void setIdStart(Integer idStart) {
		this.idStart = idStart;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getDateStart() {
		return dateStart;
	}

	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}
	//
	@Override
	public String toString() {
		return "ClientCustom [ result=" + result + ",idStart=" + idStart + ",pageNumber=" + pageNumber + ",pageSize=" + pageSize + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", getId()="
				+ getId() + ", getClientId()=" + getClientId() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getAuthStatus()=" + getAuthStatus() + ", getOrganizationName()="
				+ getOrganizationName() + ", getOrganizationSort()=" + getOrganizationSort()
				+ ", getOrganizationPhone()=" + getOrganizationPhone() + ", getRegisterTime()=" + getRegisterTime()
				+ ", getUseTimes()=" + getUseTimes() + ", getOnlineStatus()=" + getOnlineStatus() + ", getIp()="
				+ getIp() + ", getOldIp()=" + getOldIp() + ", getNewIpCount()=" + getNewIpCount() + ", getRemark()="
				+ getRemark() + ", getCuStatus()=" + getCuStatus() + ", getOfflineTime()=" + getOfflineTime() + "]";

	}

	/**  
	 * <p>Title: listAllByXMLEventReader</p>  
	 * <p>Description: </p>  
	 * @date 2018年7月29日 下午2:31:36  
	 */  
	@SuppressWarnings("unchecked")
	public static void listAllByXMLEventReader() {
		// TODO Auto-generated method stub
		// 列出所有信息
	 	
	 	
	 		String xmlFile = ClientCustom.class.getResource("/src/xml").getFile()
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
		
	

	
}
