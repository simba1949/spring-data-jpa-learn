package vip.openpark.java.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息表
 */
@Builder
@Getter
@Setter
@Entity
@Table(name = "user", schema = "example")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -1328377636255716598L;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	/**
	 * 业务编码
	 */
	@Column(name = "code", nullable = false, length = 32)
	private String code;
	
	/**
	 * 用户登录名
	 */
	@Column(name = "username", nullable = false, length = 32)
	private String username;
	
	/**
	 * 真实姓名
	 */
	@Column(name = "real_name", length = 64)
	private String realName;
	
	/**
	 * 用户昵称
	 */
	@Column(name = "nick_name", length = 64)
	private String nickName;
	
	/**
	 * 密码
	 */
	@Column(name = "password", length = 32)
	private String password;
	
	/**
	 * 性别，0表示女，1表示男
	 */
	@Column(name = "gender")
	private Byte gender;
	
	/**
	 * 出生日期
	 */
	@Column(name = "birthday")
	private LocalDateTime birthday;
	
	/**
	 * 民族
	 */
	@Column(name = "nation", length = 256)
	private String nation;
	
	/**
	 * 国家
	 */
	@Column(name = "country_name", length = 64)
	private String countryName;
	
	/**
	 * 身份证信息
	 */
	@Column(name = "id_card", length = 64)
	private String idCard;
	
	/**
	 * 地址
	 */
	@Column(name = "address", length = 256)
	private String address;
	
	/**
	 * 手机号码
	 */
	@Column(name = "phone", length = 32)
	private String phone;
	
	/**
	 * 邮件
	 */
	@Column(name = "email", length = 64)
	private String email;
	
	/**
	 * 是否启用，0表示否，1表示是
	 */
	@Column(name = "bl_enable", columnDefinition = "tinyint UNSIGNED not null")
	private Byte blEnable;
	
	/**
	 * 是否删除，0表示否，1表示是
	 */
	@Column(name = "bl_delete", columnDefinition = "tinyint UNSIGNED not null")
	private Byte blDelete;
	
	/**
	 * 版本号
	 */
	@Column(name = "version", nullable = false)
	private Long version;
	
	/**
	 * 创建时间
	 */
	@Column(name = "gmt_create", nullable = false)
	private LocalDateTime gmtCreate;
	
	/**
	 * 创建人真实姓名
	 */
	@Column(name = "creator", nullable = false, length = 64)
	private String creator;
	
	/**
	 * 创建人ID
	 */
	@Column(name = "creator_id", nullable = false)
	private Long creatorId;
	
	/**
	 * 创建人code
	 */
	@Column(name = "creator_code", nullable = false, length = 32)
	private String creatorCode;
	
	/**
	 * 修改时间
	 */
	@Column(name = "gmt_modify", nullable = false)
	private LocalDateTime gmtModify;
	
	/**
	 * 修改人真实姓名
	 */
	@Column(name = "modifier", nullable = false, length = 64)
	private String modifier;
	
	/**
	 * 修改人ID
	 */
	@Column(name = "modifier_id", nullable = false)
	private Long modifierId;
	
	/**
	 * 修改人code
	 */
	@Column(name = "modifier_code", nullable = false, length = 32)
	private String modifierCode;
	
}