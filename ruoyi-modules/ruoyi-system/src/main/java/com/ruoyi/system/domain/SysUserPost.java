package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户和岗位关联 sys_user_post
 *
 * @author ruoyi
 */
@Data
public class SysUserPost extends Model<SysUserPost> {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 岗位ID
     */
    private Integer postId;
}
