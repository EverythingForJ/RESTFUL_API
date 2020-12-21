package com.example.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MemberTest {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	void test() {
		assertNotNull(this.sqlSession);
	}

}
