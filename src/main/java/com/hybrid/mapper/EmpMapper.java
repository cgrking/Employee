package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public interface EmpMapper {
	
	List<Emp> selectAll();
	Emp selectByEmpno();
	List<Emp> selectByDeptno(int deptno); //primary key가 아니기 때문에 List로 조회
	
	List<Emp> selectAllWithDept();
	Emp selectByEmpnoWithDept();
	
	int insert(Emp emp);
	int delete(Emp emp);
		
	
	
}
