package com.ruoyi.system.api.domain;

import java.util.Set;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 角色表 sys_role
 *
 * @author ruoyi
 */
@Data
public class SysRole extends BaseEntity<SysRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String roleName;

    /**
     * 角色权限
     */
    @TableField(condition = SqlCondition.LIKE)
    private String roleKey;

    /**
     * 角色排序
     */
    private Integer roleSort;

    /**
     * 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限）
     */
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）
     */
    private boolean menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）
     */
    private boolean deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 用户是否存在此角色标识 默认不存在
     */
    @TableField(exist = false)
    private boolean flag = false;

    /**
     * 菜单组
     */
    @TableField(exist = false)
    private Integer[] menuIds;

    /**
     * 部门组（数据权限）
     */
    @TableField(exist = false)
    private Integer[] deptIds;

    /**
     * 角色菜单权限
     */
    @TableField(exist = false)
    private Set<String> permissions;

    public SysRole() {

    }

    public SysRole(Integer roleId) {
        this.roleId = roleId;
    }
}
