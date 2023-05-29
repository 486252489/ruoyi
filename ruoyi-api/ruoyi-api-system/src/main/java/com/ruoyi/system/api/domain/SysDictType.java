package com.ruoyi.system.api.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 字典类型表 sys_dict_type
 *
 * @author ruoyi
 */
@Data
public class SysDictType extends BaseEntity<SysDictType> {
    private static final long serialVersionUID = 1L;

    /**
     * 字典主键
     */
    @TableId
    private Integer dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

}
