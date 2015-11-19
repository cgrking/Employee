package com.hybrid.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 횡단적 관심사를 긁어서 컷팅 코드 중복 최소화
public class LogDaoAspect {
	// static Log log = LogFactory.getLog(LogDaoAspect.class);

	@Pointcut("execution(public * com.hybrid.dao.*Dao.*(..))")
	public void dao() {

	}

	@Pointcut("execution(public * com.hybrid.dao.*Service.*(..))")
	public void service() {

	}

	@Before("dao() || service()") // public 메소드에만 적용 .. = 파라미터가 있건 없건 다 적용
	public void before(JoinPoint jp) {
		Log log = LogFactory.getLog(jp.getTarget().getClass()); // DeptDao get!
		log.info("### " + jp.getSignature().getName() + "(" + Arrays.toString(jp.getArgs()) + ")" + "START"); // 파라미터
																												// 정보
	}

	@After("dao() || service()")
	public void after(JoinPoint jp) {
		Log log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("### " + jp.getSignature().getName() + "(" + Arrays.toString(jp.getArgs()) + ")" + "END");
	}

}
