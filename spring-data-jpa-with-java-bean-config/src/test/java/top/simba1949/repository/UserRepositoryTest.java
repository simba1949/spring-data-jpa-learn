package top.simba1949.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import top.simba1949.config.SpringDataJpaConfig;
import top.simba1949.domain.UserEntity;

import java.util.Date;
import java.util.UUID;

/**
 * @author anthony
 * @date 2023/3/29
 */
@SpringJUnitConfig(classes = SpringDataJpaConfig.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertTest(){
        UserEntity userEntity = UserEntity.builder()
                .username("宋玉")
                .password("songyu")
                .realName("宋玉")
                .phone("12345678901")
                .email("12345678901@chu.com")
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
