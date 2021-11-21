package com.BlogApp.Blog;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class BlogApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	void testThatDatabaseIsConnected(){
		assertThat(dataSource).isNotNull();
		try{
			Connection connection = dataSource.getConnection();
			assertThat(connection).isNotNull();
		}catch(SQLException ex){
			log.info("connection -> {}", ex.getMessage());
		}
	}

}
