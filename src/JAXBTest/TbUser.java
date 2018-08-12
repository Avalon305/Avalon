package JAXBTest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author zsc
 */
public class TbUser implements Serializable {

	private static final long serialVersionUID = 1520180490144L;

	/**
	 * 主键 用户名自增id isNullAble:0
	 */
	
	private Integer id;

	/**
	 * 用户名 isNullAble:0
	 */
	
	private String username;

	/**
	 * 密码 isNullAble:0
	 */

	private String password;

	/**
	 * 姓名 isNullAble:1
	 */
	private String name;

	/**
	 * 电话号码 isNullAble:1
	 */
	private String phone;

	/**
	 * 性别 isNullAble:1
	 */
	private Integer sex;

	/**
	 * 角色 isNullAble:1
	 */
	private Integer role;

	/**
	 * 工作 isNullAble:1
	 */
	private String job;

	/**
	 * 备注 isNullAble:1
	 */
	private String remark;

	public void setId(Integer id) {
		this.id = id;
	}
	@XmlAttribute(name="Id")
	public Integer getId() {
		return this.id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="userName")
	public String getName() {
		return this.name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlAttribute
	public String getPhone() {
		return this.phone;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return this.job;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	@Override
	public String toString() {
		return "TbUser{" + "id='" + id + '\'' + "username='" + username + '\'' + "password='" + password + '\''
				+ "name='" + name + '\'' + "phone='" + phone + '\'' + "sex='" + sex + '\'' + "role='" + role + '\''
				+ "job='" + job + '\'' + "remark='" + remark + '\'' + '}';
	}

}