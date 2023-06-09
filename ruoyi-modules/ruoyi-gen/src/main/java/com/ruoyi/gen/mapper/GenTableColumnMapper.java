package com.ruoyi.gen.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.gen.domain.GenTableColumn;

/**
 * 业务字段 数据层
 *
 * @author ruoyi
 */
public interface GenTableColumnMapper extends BaseMapper<GenTableColumn> {
    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @return 列信息
     */
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName);

}