package com.liangrui.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//测试时希望和正式环境是一样的 使用配置类中的配置
class CommunityApplicationTests implements ApplicationContextAware {//通过实现接口获取spring容器
	private ApplicationContext applicationContext;//用一个成员变量记录一下 以便后续使用
	@Test
	void contextLoads() {
	}

	@Override//spring会扫描实现了接口的 会调用set把applicationContext传进来
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
	}
}
