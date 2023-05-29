package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 参数配置表 sys_config
 *
 * @author ruoyi
 */
@Data
public class SysConfig extends BaseEntity<SysConfig> {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    @TableId
    private Integer configId;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    private String configType;

}
