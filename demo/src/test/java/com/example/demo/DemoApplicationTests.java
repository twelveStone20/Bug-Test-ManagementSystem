package com.example.demo;

//import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;

//import com.example.demo.mapper.UserMapper;
//import com.example.demo.pojo.user.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//@SpringBootTest
class DemoApplicationTests {
	
    //@Autowired(required = false)
	//private UserMapper userMapper;

	@Test
	public void testGenJwt(){
		Map<String,Object> claims = new HashMap<>();
		claims.put("id",1);
		claims.put("name","Tom");
		String jwt = Jwts.builder()
		.signWith(SignatureAlgorithm.HS256,"BugMS")
		.setClaims(claims)
		.setExpiration(new Date(System.currentTimeMillis()+3600*1000))
		.compact();
		System.out.println(jwt);
	}

}
