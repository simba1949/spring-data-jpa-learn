package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.simba1949.domain.UserEntity;
import top.simba1949.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author anthony
 * @date 2023/3/28
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
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
