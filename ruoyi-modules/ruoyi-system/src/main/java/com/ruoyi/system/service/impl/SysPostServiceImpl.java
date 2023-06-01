package com.ruoyi.system.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.SysUserPost;
import com.ruoyi.system.service.ISysUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.constant.UserConstants;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.mapper.SysPostMapper;
import com.ruoyi.system.service.ISysPostService;

/**
 * 岗位信息 服务层处理
 *
 * @author ruoyi
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

    @Autowired
    private ISysUserPostService userPostService;

    /**
     * 根据用户ID获取岗位选择框列表
     *
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    @Override
    public List<Integer> selectPostListByUserId(Integer userId) {
        return baseMapper.selectPostListByUserId(userId);
    }

    /**
     * 校验岗位名称是否唯一
     *
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public boolean checkPostNameUnique(SysPost post) {
        Long count = super.count(Wrappers.<SysPost>lambdaQuery().ne(post.getPostId() != null, SysPost::getPostId, post.getPostId()).eq(SysPost::getPostName, post.getPostName()));
        if (count.intValue() > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验岗位编码是否唯一
     *
     * @param post 岗位信息
     * @return 结果
     */
    @Override
    public boolean checkPostCodeUnique(SysPost post) {
        Long count = super.count(Wrappers.<SysPost>lambdaQuery().ne(post.getPostId() != null, SysPost::getPostId, post.getPostId()).eq(SysPost::getPostCode, post.getPostCode()));
        if (count.intValue() > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 批量删除岗位信息
     *
     * @param postIds 需要删除的岗位ID
     * @return 结果
     */
    @Override
    public boolean deletePostByIds(Integer[] postIds) {
        for (Integer postId : postIds) {
            SysPost post = super.getById(postId);
            Long count = userPostService.count(Wrappers.<SysUserPost>lambdaQuery().eq(SysUserPost::getPostId, postId));
            if (count.intValue() > 0) {
                throw new ServiceException(String.format("%1$s已分配,不能删除", post.getPostName()));
            }
        }
        return super.removeBatchByIds(Arrays.asList(postIds));
    }

}
