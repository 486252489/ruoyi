package com.ruoyi.gen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.gen.service.IGenTableColumnService;
import org.springframework.stereotype.Service;
import com.ruoyi.gen.domain.GenTableColumn;
import com.ruoyi.gen.mapper.GenTableColumnMapper;

import java.util.List;

/**
 * 业务字段 服务层实现
 *
 * @author ruoyi
 */
@Service
public class GenTableColumnServiceImpl extends ServiceImpl<GenTableColumnMapper, GenTableColumn> implements IGenTableColumnService {

    @Override
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName) {
        return baseMapper.selectDbTableColumnsByName(tableName);
    }
}