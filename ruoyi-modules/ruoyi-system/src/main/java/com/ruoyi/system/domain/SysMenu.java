package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 菜单权限表 sys_menu
 *
 * @author ruoyi
 */
@Data
public class SysMenu extends BaseEntity<SysMenu> {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId
    private Integer menuId;

    /**
     * 菜单名称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String menuName;

    /**
     * 父菜单名称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String parentName;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 路由参数
     */
    private String query;

    /**
     * 是否为外链（0是 1否）
     */
    private String isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    private String isCache;

    /**
     * 类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 显示状态（0显示 1隐藏）
     */
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;

    /**
     * 权限字符串
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<SysMenu>();

}
