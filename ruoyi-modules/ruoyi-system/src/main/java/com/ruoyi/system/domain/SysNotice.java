package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 通知公告表 sys_notice
 *
 * @author ruoyi
 */
@Data
public class SysNotice extends BaseEntity<SysNotice> {
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    @TableId
    private Integer noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    private String noticeType;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;


}
