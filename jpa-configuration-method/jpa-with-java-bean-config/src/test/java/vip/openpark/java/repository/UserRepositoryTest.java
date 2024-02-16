package vip.openpark.java.repository;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import vip.openpark.java.config.SpringDataJpaConfig;
import vip.openpark.java.domain.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author anthony
 * @version 2023/3/29
 */
@Slf4j
@SpringJUnitConfig(classes = SpringDataJpaConfig.class)
public class UserRepositoryTest {
	
	@Resource
	private UserRepository userRepository;
	
	@Test
	public void insertTest() {
		UserEntity userEntity = UserEntity.builder()
			                        .username("GaoShi")
			                        .password("GaoShi123")
			                        .realName("高适")
			                        .phone("12345678901")
			                        .email("12345678901@tang.com")
			                        .build();
		this.fillData4Insert(userEntity);
		
		UserEntity save = userRepository.save(userEntity);
		log.info("{}", save);
	}
	
	// =============================================
	// ================ private ====================
	// =============================================
	
	private void fillData4Insert(UserEntity userEntity) {
		userEntity.setCode(UUID.randomUUID().toString().substring(0, 32));
		userEntity.setBlEnable((byte) 1);
		userEntity.setBlDelete((byte) 0);
		userEntity.setVersion(0L);
		userEntity.setGmtCreate(LocalDateTime.now());
		userEntity.setCreator("SYSTEM");
		userEntity.setCreatorId(0L);
		userEntity.setCreatorCode("0");
		
		fillData4Update(userEntity);
	}
	
	private void fillData4Update(UserEntity userEntity) {
		userEntity.setGmtModify(LocalDateTime.now());
		userEntity.setModifier("SYSTEM");
		userEntity.setModifierId(0L);
		userEntity.setModifierCode("0");
	}
}