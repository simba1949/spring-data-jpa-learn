package vip.openpark.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import vip.openpark.domain.UserEntity;
import vip.openpark.repository.UserRepository;

import java.util.List;

/**
 * @author anthony
 * @version 2023/3/28
 */
@Slf4j
@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	
	@Transactional(rollbackFor = Throwable.class)
	public void insert(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	
	@Transactional(rollbackFor = Throwable.class)
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
	@Transactional(rollbackFor = Throwable.class)
	public void update(UserEntity userEntity) {
		UserEntity userEntityFromDb = get(userEntity.getId());
		if (null == userEntityFromDb) {
			return;
		}
		
		if (StringUtils.hasText(userEntity.getUsername())) {
			userEntityFromDb.setUsername(userEntity.getUsername());
		}
		if (StringUtils.hasText(userEntity.getPassword())) {
			userEntityFromDb.setPassword(userEntity.getPassword());
		}
		if (StringUtils.hasText(userEntity.getRealName())) {
			userEntityFromDb.setRealName(userEntity.getRealName());
		}
		if (StringUtils.hasText(userEntity.getPhone())) {
			userEntityFromDb.setPhone(userEntity.getPhone());
		}
		if (StringUtils.hasText(userEntity.getEmail())) {
			userEntityFromDb.setEmail(userEntity.getEmail());
		}
		if (StringUtils.hasText(userEntity.getNickName())) {
			userEntityFromDb.setNickName(userEntity.getNickName());
		}
		
		userRepository.save(userEntityFromDb);
	}
	
	public UserEntity get(long id) {
		return userRepository.getById(id);
	}
	
	public List<UserEntity> list() {
		return userRepository.findAll();
	}
	
	public List<UserEntity> sortAll() {
		Sort.TypedSort<UserEntity> typedSort = Sort.sort(UserEntity.class);
		// 先按照创建时间降序排序，再按照生日升序排序
		Sort sort = typedSort.by(UserEntity::getGmtCreate).descending()
			            .and(typedSort.by(UserEntity::getBirthday).ascending());
		return userRepository.findAll(sort);
	}
}