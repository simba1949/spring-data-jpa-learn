package vip.openpark.domain;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author anthony
 * @version 2023/3/28
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 3059956406401842955L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "bl_enable")
    private Byte blEnable;
    @Column(name = "bl_delete")
    private Byte blDelete;
    @Column(name = "version")
    private Long version;
    @Column(name = "gmt_create")
    private Date gmtCreate;
    @Column(name = "creator")
    private String creator;
    @Column(name = "creator_id")
    private Long creatorId;
    @Column(name = "gmt_modified")
    private Date gmtModified;
    @Column(name = "modifier")
    private String modifier;
    @Column(name = "modifier_id")
    private Long modifierId;
}