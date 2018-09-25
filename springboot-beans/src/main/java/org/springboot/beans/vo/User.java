package org.springboot.beans.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;
/**
 * 下面介绍几个我常用的 lombok 注解：

@Data   ：注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Setter：注解在属性上；为属性提供 setting 方法
@Getter：注解在属性上；为属性提供 getting 方法
@Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
@NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
@AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
* <p>Title: User </p>
* <p>Description: </p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年9月20日 上午10:48:44
 */
@Data
public class User implements Serializable{
	
   private static final long serialVersionUID = 1L;

   private Integer id;
    /**
     * 头像
     */
   private String avatar;
    /**
     * 账号
     */
    @NotNull(message = "account不能为空!!!")
    private String account;
    /**
     * 电话
     */
     @NotNull(message = "telnum不能为空!!!")
     @Pattern(regexp = "^[1][3,4,5,7,8,9][0-9]{9}$", message = "手机号码格式错误!!!")
     private String phone;
    /**
     * 密码
     */
     private String password;
    /**
     * md5密码盐
     */
     private String salt;
    /**
     * 名字
     */
     private String name;
    /**
     * 生日
     */
     private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
     private Integer sex;
    /**
     * 电子邮件
     */
     private String email;
    /**
     * 角色id
     */
	 private String roleid;
    /**
     * 部门id
     */
	 private Integer deptid;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
	 private Integer status;
    /**
     * 创建时间
     */
	 private Date createtime;
    /**
     * 保留字段
     */
	 private Integer version;
	 
	 
}