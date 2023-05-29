package com.ruoyi.system.api.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 字典数据表 sys_dict_data
 *
 * @author ruoyi
 */
@Data
public class SysDictData extends BaseEntity<SysDept> {
    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    @TableId
    private Integer dictCode;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 字典标签
     */
    @TableField(condition = SqlCondition.LIKE)
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典类型
     */
    @TableField(condition = SqlCondition.LIKE)
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格字典样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    private String isDefault;

    /**
     * 状态（0正常 1停用）
     */
    private String status;
}
