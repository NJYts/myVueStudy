package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="uId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uId;
	@Column(name="user_name")
	private String name;
	@Column(name="user_password")
	private String password;

	public User() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LoginController [name=" + name + ", password=" + password + "]";
	}
	
	public Integer getuId() {
		return uId;
	}
	
	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public void setRoles(String string) {
		// TODO Auto-generated method stub
		
	}
}
