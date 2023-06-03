package com.ruoyi.gen.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.gen.domain.GenTable;
import org.apache.ibatis.annotations.Param;

/**
 * 业务 数据层
 *
 * @author ruoyi
 */
public interface GenTableMapper extends BaseMapper<GenTable> {
    /**
     * 查询业务列表
     *
     * @param genTable 业务信息
     * @return 业务集合
     */
    public Page<GenTable> selectGenTableList(Page<GenTable>page,@Param("query") GenTable genTable);

    /**
     * 查询据库列表
     *
     * @return 数据库集合
     */
    public List<GenTable> selectDbSchemaList();

    /**
     * 查询据库表列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    public Page<GenTable> selectDbTableList(Page<GenTable> page,@Param("query") GenTable genTable);

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查询所有表信息
     *
     * @return 表信息集合
     */
    public List<GenTable> selectGenTableAll();

    /**
     * 查询表ID业务信息
     *
     * @param id 业务ID
     * @return 业务信息
     */
    public GenTable selectGenTableById(Integer id);

    /**
     * 查询表名称业务信息
     *
     * @param tableName 表名称
     * @return 业务信息
     */
    public GenTable selectGenTableByName(String tableName);

}