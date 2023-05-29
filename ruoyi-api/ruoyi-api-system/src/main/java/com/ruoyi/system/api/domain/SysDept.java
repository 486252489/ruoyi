package com.ruoyi.system.api.domain;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 部门表 sys_dept
 *
 * @author ruoyi
 */
@Data
public class SysDept extends BaseEntity<SysDept> {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableId
    private Integer deptId;

    /**
     * 父部门ID
     */
    private Integer parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门状态:0正常,1停用
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 父部门名称
     */
    private String parentName;

    /**
     * 子部门
     */
    private List<SysDept> children = new ArrayList<SysDept>();
}
