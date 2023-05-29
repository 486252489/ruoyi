package com.ruoyi.system.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.utils.SpringUtils;
import com.ruoyi.common.redis.service.RedisService;
import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.api.domain.SysRole;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.system.service.ISysPermissionService;
import com.ruoyi.system.service.ISysRoleService;

/**
 * 用户权限处理
 *
 * @author ruoyi
 */
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    /**
     * 获取角色数据权限
     *
     * @param user 用户
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(SysUser user) {
        Set<String> roles = roleService.selectRolePermissionByUserId(user.getUserId());
        // 管理员拥有所有权限
        if (SecurityUtils.isAdmin(roles)) {
            roles.clear();
            roles.add(Convert.toStr(SpringUtils.getBean(RedisService.class).getCacheObject(CacheConstants.SYS_ROLE_ADMIN)));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     *
     * @param user 用户
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(SysUser user) {
        Set<String> perms = new HashSet<String>();
        Set<String> roleKeys = roleService.selectRolePermissionByUserId(user.getUserId());
        // 管理员拥有所有权限
        if (SecurityUtils.isAdmin(roleKeys)) {
            perms.add("*:*:*");
        } else {
            List<SysRole> roles = user.getRoles();
            if (!roles.isEmpty() && roles.size() > 1) {
                // 多角色设置permissions属性，以便数据权限匹配权限
                for (SysRole role : roles) {
                    Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
                    role.setPermissions(rolePerms);
                    perms.addAll(rolePerms);
                }
            } else {
                perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
            }
        }
        return perms;
    }
}
