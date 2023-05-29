package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户和角色关联 sys_user_role
 *
 * @author ruoyi
 */
@Data
public class SysUserRole extends Model<SysUserRole> {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;
}
