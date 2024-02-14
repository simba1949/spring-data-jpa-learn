package vip.openpark.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vip.openpark.domain.UserEntity;
import vip.openpark.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author anthony
 * @version 2023/3/28
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    public String insert(@RequestBody UserEntity userEntity){
        this.fillData4Insert(userEntity);

        userService.insert(userEntity);

        return "SUCCESS";
    }

    @PutMapping
    public String update(@RequestBody UserEntity userEntity){
        this.fillData4Update(userEntity);

        userService.update(userEntity);

        return "SUCCESS";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")long id){

        userService.delete(id);

        return "SUCCESS";
    }

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable("id")long id){
        return userService.get(id);
    }

    @GetMapping("list")
    public List<UserEntity> list(){
        return userService.list();
    }

    @GetMapping("sortAll")
    public List<UserEntity> sortAll(){
        return userService.sortAll();
    }

    @GetMapping("findUserEntityById")
    public UserEntity findUserEntityById(long id){
        return userService.findUserEntityById(id);
    }

    @GetMapping("findUserEntitiesByCreator")
    public List<UserEntity> findUserEntitiesByCreator(String creator){
        return userService.findUserEntitiesByCreator(creator);
    }

    @GetMapping("updateUserEntity")
    public int updateUserEntity(String username,long id){
        return userService.updateUserEntity(username, id);
    }

    @GetMapping("deleteUserEntityById")
    public int deleteUserEntityById(long id){
        return userService.deleteUserEntityById(id);
    }

    @GetMapping("insertUserEntityBySelect")
    public int insertUserEntityBySelect(long id){
        return userService.insertUserEntityBySelect(id);
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