package JAXBTest;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//import org.springframework.format.annotation.DateTimeFormat;

/**
*
*  @author zsc
*/
//@XmlRootElement(name="tbClient")
public class TbClient implements Serializable {

    private static final long serialVersionUID = 1520180487709L;


    /**
    * 主键
    * 自增
    * isNullAble:0
    */
    private Integer id;
    
    /**
     * entity更新：增加主机唯一标识
     */
    private String clientId;

	/**
    * 用户名
    * isNullAble:1
    */
   
    private String username;

    /**
    * 密码
    * isNullAble:1
    */
 
    private String password;
    
    /**
     * 唯一标识和username对应状态，0-正常，1-登录异常
     */
    private int cuStatus;

    /**
    * 使用状态，权限：1锁定、0正常、2删除、3永久离线',
    * isNullAble:1
    */
    //@XmlAttribute(name="auth")
    private Integer authStatus;
    
    /**
     * 离线时间
     */
    //@DateTimeFormat
    private Date offlineTime;

    /**
    * 机构名称
    * isNullAble:1
    */
    private String organizationName;

    /**
    * 机构分区
    * isNullAble:1
    */
    private String organizationSort;

    /**
    * 联系电话
    * isNullAble:1
    */
    private String organizationPhone;

    /**
    * 注册日期
    * isNullAble:1
    */
    //@DateTimeFormat
    private Date registerTime;

    /**
    * 使用次数
    * isNullAble:1
    */
    private Integer useTimes;

    /**
    * 是否在线，0不在，1在
    * isNullAble:1
    */
    private Integer onlineStatus;

    /**
    * 登录ip
    * isNullAble:1
    */
    private String ip;
    
    /**
     * 之前登录的ip
     */
    private String oldIp;
    
    /**
     * 新ip登录的次数
     */
    private int newIpCount;

    /**
    * 备注
    * isNullAble:1
    */
    private String remark;
    
    private String city;
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
     * 最后一次心跳时间
     * @param id
     */
    //@DateTimeFormat
    private Date lastACKTime;
    
    

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setAuthStatus(Integer authStatus){
        this.authStatus = authStatus;
    }
    @XmlAttribute(name="auth")
    public Integer getAuthStatus(){
        return this.authStatus;
    }

    public void setOrganizationName(String organizationName){
        this.organizationName = organizationName;
    }

    public String getOrganizationName(){
        return this.organizationName;
    }

    public void setOrganizationSort(String organizationSort){
        this.organizationSort = organizationSort;
    }

    public String getOrganizationSort(){
        return this.organizationSort;
    }

    public void setOrganizationPhone(String organizationPhone){
        this.organizationPhone = organizationPhone;
    }

    public String getOrganizationPhone(){
        return this.organizationPhone;
    }

    public void setRegisterTime(Date registerTime){
        this.registerTime = registerTime;
    }

    public Date getRegisterTime(){
        return this.registerTime;
    }

    public void setUseTimes(Integer useTimes){
        this.useTimes = useTimes;
    }

    public Integer getUseTimes(){
        return this.useTimes;
    }

    public void setOnlineStatus(Integer onlineStatus){
        this.onlineStatus = onlineStatus;
    }

    public Integer getOnlineStatus(){
        return this.onlineStatus;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    public String getIp(){
        return this.ip;
    }

    public String getOldIp() {
		return oldIp;
	}

	public void setOldIp(String oldIp) {
		this.oldIp = oldIp;
	}

	public int getNewIpCount() {
		return newIpCount;
	}

	public void setNewIpCount(int newIpCount) {
		this.newIpCount = newIpCount;
	}

	public void setRemark(String remark){
        this.remark = remark;
    }

    public String getRemark(){
        return this.remark;
    }

	public int getCuStatus() {
		return cuStatus;
	}

	public void setCuStatus(int cuStatus) {
		this.cuStatus = cuStatus;
	}

	public Date getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}

	public Date getLastACKTime() {
		return lastACKTime;
	}

	public void setLastACKTime(Date lastACKTime) {
		this.lastACKTime = lastACKTime;
	}

	@Override
	public String toString() {
		return "TbClient [id=" + id + ", clientId=" + clientId + ", username=" + username + ", password=" + password
				+ ", cuStatus=" + cuStatus + ", authStatus=" + authStatus + ", offlineTime=" + offlineTime
				+ ", organizationName=" + organizationName + ", organizationSort=" + organizationSort
				+ ", organizationPhone=" + organizationPhone + ", registerTime=" + registerTime + ", useTimes="
				+ useTimes + ", onlineStatus=" + onlineStatus + ", ip=" + ip + ", oldIp=" + oldIp + ", newIpCount="
				+ newIpCount + ", remark=" + remark + ", lastACKTime=" + lastACKTime + "]";
	}
}
