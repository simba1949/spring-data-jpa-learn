package top.simba1949.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.simba1949.domain.UserEntity;

import java.util.List;

/**
 * @author anthony
 * @date 2023/3/28
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("from UserEntity where id=?1") // 使用问号需要指定参数序列，从左到右从1开始
    UserEntity findUserEntityById(long id);

    @Query("from UserEntity where creator=:creator") // 使用具名，需要配合@Param
    List<UserEntity> findUserEntitiesByCreator(@Param("creator") String creator);

    @Modifying // 用于通知 SpringDataJpa 是增删改的操作
    @Query("UPDATE UserEntity SET username=:username where id=:id")
    int updateUserEntity(@Param("username")String username, @Param("id")long id);

    @Modifying
    @Query("DELETE UserEntity WHERE id=:id")
    int deleteUserEntityById(@Param("id")long id);

    @Modifying
    @Query("INSERT INTO UserEntity(code, username, password, realName, phone, email)" +
            "SELECT u.code, u.username, u.password, u.realName, u.phone, u.email " +
            "FROM UserEntity u where u.id=?1")
    int insertUserEntityBySelect(long id);
}
