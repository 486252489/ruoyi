package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.security.utils.DictUtils;
import com.ruoyi.system.api.domain.SysDictData;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISysDictDataService;

/**
 * 字典 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements ISysDictDataService {

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataList(SysDictData dictData) {
        return super.list(Wrappers.lambdaQuery(dictData).orderByAsc(SysDictData::getDictSort));
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        SysDictData sysDictData = super.getOne(Wrappers.<SysDictData>lambdaQuery().select(SysDictData::getDictLabel).eq(SysDictData::getDictType, dictType).eq(SysDictData::getDictValue, dictValue));
        return sysDictData != null ? sysDictData.getDictLabel() : null;
    }

    /**
     * 批量删除字典数据信息
     *
     * @param dictCodes 需要删除的字典数据ID
     */
    @Override
    public void deleteDictDataByIds(Integer[] dictCodes) {
        for (Integer dictCode : dictCodes) {
            SysDictData data = super.getById(dictCode);
            super.removeById(dictCode);
            List<SysDictData> dictDatas = this.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
    }

    /**
     * 新增保存字典数据信息
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(SysDictData data) {
        int row = baseMapper.insert(data);
        if (row > 0) {
            List<SysDictData> dictDatas = this.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }

    /**
     * 修改保存字典数据信息
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(SysDictData data) {
        int row = baseMapper.updateById(data);
        if (row > 0) {
            List<SysDictData> dictDatas = this.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }

    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        return super.list(Wrappers.<SysDictData>lambdaQuery().eq(SysDictData::getStatus, "0").eq(SysDictData::getDictType, dictType).orderByAsc(SysDictData::getDictSort));
    }
}
