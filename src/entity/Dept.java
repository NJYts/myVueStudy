package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPT")
public class Dept {
	@Id
	@Column(name="DEPTNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deptNo;
	@Column(name="DNAME")
	private String deptName;
	@Column(name="LOC")
	private String location;
	@Column(name="DEPT_STATUS")
	private String status;
	public Dept() {
		super();
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName
				+ ", location=" + location + ", status=" + status + "]";
	}
	
	

}
