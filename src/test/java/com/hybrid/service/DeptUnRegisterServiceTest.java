package com.hybrid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptUnRegisterServiceTest {
	
	static Log log = LogFactory.getLog(DeptRegisterService.class);
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		DeptUnRegisterService service = ctx.getBean(DeptUnRegisterService.class);
		
		Dept dept = new Dept();
		dept.setDeptno(71);
		
		service.unregist(dept);
	}
}
