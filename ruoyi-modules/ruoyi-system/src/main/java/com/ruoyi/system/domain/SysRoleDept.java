package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 角色和部门关联 sys_role_dept
 *
 * @author ruoyi
 */
@Data
public class SysRoleDept extends Model<SysRoleDept> {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 部门ID
     */
    private Integer deptId;
}
