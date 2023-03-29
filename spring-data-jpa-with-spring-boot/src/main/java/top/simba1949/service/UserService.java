package top.simba1949.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.simba1949.domain.UserEntity;
import top.simba1949.repository.UserRepository;

import java.util.List;

/**
 * @author anthony
 * @date 2023/3/28
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Throwable.class)
    public void insert(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void delete(long id){
        userRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void update(UserEntity userEntity){
        UserEntity userEntityFromDb = get(userEntity.getId());

        if (StringUtils.hasText(userEntity.getUsername())){
            userEntityFromDb.setUsername(userEntity.getUsername());
        }
        if (StringUtils.hasText(userEntity.getPassword())){
            userEntityFromDb.setPassword(userEntity.getPassword());
        }
        if (StringUtils.hasText(userEntity.getRealName())){
            userEntityFromDb.setRealName(userEntity.getRealName());
        }
        if (StringUtils.hasText(userEntity.getPhone())){
            userEntityFromDb.setPhone(userEntity.getPhone());
        }
        if (StringUtils.hasText(userEntity.getEmail())){
            userEntityFromDb.setEmail(userEntity.getEmail());
        }

        userRepository.save(userEntityFromDb);
    }

    public UserEntity get(long id){
        return userRepository.getReferenceById(id);
    }

    public List<UserEntity> list(){
        return userRepository.findAll();
    }
}
