package com.ruoyi.gen.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.gen.domain.GenTableColumn;

/**
 * 业务字段 服务层
 *
 * @author ruoyi
 */
public interface IGenTableColumnService extends IService<GenTableColumn> {
    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @return 列信息
     */
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName);
}
