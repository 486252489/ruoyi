package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.domain.vo.TreeSelect;

/**
 * 菜单 业务层
 *
 * @author ruoyi
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
     List<SysMenu> selectMenuList(Integer userId);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param menu   菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
     List<SysMenu> selectMenuList(SysMenu menu, Integer userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
     Set<String> selectMenuPermsByUserId(Integer userId);

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
     Set<String> selectMenuPermsByRoleId(Integer roleId);

    /**
     * 根据用户ID查询菜单树信息
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
     List<SysMenu> selectMenuTreeByUserId(Integer userId);

    /**
     * 根据角色ID查询菜单树信息
     *
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
     List<Integer> selectMenuListByRoleId(Integer roleId);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
     List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
     List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
     List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 是否存在菜单子节点
     *
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
     boolean hasChildByMenuId(Integer menuId);

    /**
     * 查询菜单是否存在角色
     *
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
     boolean checkMenuExistRole(Integer menuId);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
     boolean checkMenuNameUnique(SysMenu menu);
}
