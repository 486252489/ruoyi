package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.api.domain.SysLogininfor;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author ruoyi
 */
public interface SysLogininforMapper extends BaseMapper<SysLogininfor> {

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    public int cleanLogininfor();
}
