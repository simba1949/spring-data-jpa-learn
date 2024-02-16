package vip.openpark.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import vip.openpark.domain.UserEntity;

import java.util.List;

/**
 * @author anthony
 * @version 2024/2/16 14:55
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@Resource
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void insertTest() {
		UserEntity userEntity =
			UserEntity.builder()
				.username("屈原")
				.password("quyuan")
				.realName("屈原")
				.phone("12345678900")
				.email("12345678900@chu.com")
				.build();
		
		String result = testRestTemplate.postForObject("/user", userEntity, String.class);
		log.info("result: {}", result);
	}
	
	@Test
	public void updateTest() {
		UserEntity userEntity =
			UserEntity.builder()
				.id(216L)
				.nickName("屈原1")
				.build();
		
		testRestTemplate.put("/user", userEntity);
	}
	
	@Test
	public void delete() {
		testRestTemplate.delete("/user/216");
	}
	
	@Test
	public void getTest() {
		UserEntity userEntity = testRestTemplate.getForObject("/user/1", UserEntity.class);
		log.info("查询到数据: {}", userEntity);
	}
	
	@Test
	public void listTest() {
		List dataList = testRestTemplate.getForObject("/user/list", List.class);
		log.info("查询到数据: {}", dataList);
	}
	
	@Test
	public void sortAllTest() {
		List dataList = testRestTemplate.getForObject("/user/sortAll", List.class);
		log.info("查询到数据: {}", dataList);
	}
}