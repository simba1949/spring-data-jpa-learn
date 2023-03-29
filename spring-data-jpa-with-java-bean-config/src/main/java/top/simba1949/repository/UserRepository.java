package top.simba1949.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.simba1949.domain.UserEntity;

/**
 * @author anthony
 * @date 2023/3/29
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
