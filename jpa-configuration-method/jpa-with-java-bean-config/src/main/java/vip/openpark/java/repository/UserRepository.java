package vip.openpark.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.openpark.java.domain.UserEntity;

/**
 * @author anthony
 * @version 2023/3/29
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}