package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.SysPost;

/**
 * 岗位信息 服务层
 *
 * @author ruoyi
 */
public interface ISysPostService extends IService<SysPost> {

    /**
     * 根据用户ID获取岗位选择框列表
     *
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    public List<Integer> selectPostListByUserId(Integer userId);

    /**
     * 校验岗位名称
     *
     * @param post 岗位信息
     * @return 结果
     */
    public boolean checkPostNameUnique(SysPost post);

    /**
     * 校验岗位编码
     *
     * @param post 岗位信息
     * @return 结果
     */
    public boolean checkPostCodeUnique(SysPost post);

    /**
     * 批量删除岗位信息
     *
     * @param postIds 需要删除的岗位ID
     * @return 结果
     */
    public boolean deletePostByIds(Integer[] postIds);

}
