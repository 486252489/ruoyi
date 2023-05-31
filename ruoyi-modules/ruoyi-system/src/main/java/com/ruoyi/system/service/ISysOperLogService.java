package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.api.domain.SysOperLog;

/**
 * 操作日志 服务层
 *
 * @author ruoyi
 */
public interface ISysOperLogService extends IService<SysOperLog> {

    /**
     * 清空操作日志
     */
    void cleanOperLog();
}
