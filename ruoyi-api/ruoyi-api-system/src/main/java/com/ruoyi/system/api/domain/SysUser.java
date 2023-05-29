package com.ruoyi.system.api.domain;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
@Data
public class SysUser extends BaseEntity<SysUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Integer userId;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 用户账号
     */
    @TableField(condition = SqlCondition.LIKE)
    private String userName;

    /**
     * 用户昵称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String nickName;

    /**
     * 用户邮箱
     */
    @TableField(condition = SqlCondition.LIKE)
    private String email;

    /**
     * 手机号码
     */
    @TableField(condition = SqlCondition.LIKE)
    private String phonenumber;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 部门对象
     */
    @TableField(exist = false)
    private SysDept dept;

    /**
     * 角色对象
     */
    @TableField(exist = false)
    private List<SysRole> roles;

    /**
     * 角色组
     */
    @TableField(exist = false)
    private Integer[] roleIds;

    /**
     * 岗位组
     */
    @TableField(exist = false)
    private Integer[] postIds;

    /**
     * 角色ID
     */
    @TableField(exist = false)
    private Integer roleId;

    public SysUser() {

    }

    public SysUser(Integer userId) {
        this.userId = userId;
    }

}
