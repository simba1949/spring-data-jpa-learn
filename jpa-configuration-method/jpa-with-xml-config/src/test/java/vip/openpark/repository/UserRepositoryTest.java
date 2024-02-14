package vip.openpark.repository;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import vip.openpark.domain.UserEntity;

import java.util.Date;
import java.util.UUID;

/**
 * @author anthony
 * @version 2023/3/29
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:spring-data-jpa.xml")
@SpringJUnitConfig(locations = "classpath:spring-data-jpa.xml")
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void insertTest(){
        UserEntity userEntity = UserEntity.builder()
                .username("屈原")
                .password("quyuan")
                .realName("屈原")
                .phone("12345678900")
                .email("12345678900@chu.com")
                .build();
        this.fillData4Insert(userEntity);

        userRepository.save(userEntity);
    }

    // =============================================
    // ================ private ====================
    // =============================================

    private void fillData4Insert(UserEntity userEntity){
        userEntity.setCode(UUID.randomUUID().toString());
        userEntity.setBlEnable((byte)1);
        userEntity.setBlDelete((byte)0);
        userEntity.setVersion(0L);
        userEntity.setGmtCreate(new Date());
        userEntity.setCreator("SYSTEM");
        userEntity.setCreatorId(0L);

        fillData4Update(userEntity);
    }

    private void fillData4Update(UserEntity userEntity){
        userEntity.setGmtModified(new Date());
        userEntity.setModifier("SYSTEM");
        userEntity.setModifierId(0L);
    }
}