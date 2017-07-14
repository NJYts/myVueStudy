package dao;

import java.util.List;

import entity.Dept;

public interface DeptDao {
	void save(Dept dept);
	void delete(Dept dept);
	Dept get(Dept dept);
	void update(Dept dept);
	List<Dept> select();
	
}
