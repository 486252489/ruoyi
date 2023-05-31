package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.InnerAuth;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.api.domain.SysOperLog;
import com.ruoyi.system.service.ISysOperLogService;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/operlog")
public class SysOperlogController extends BaseController {
    @Autowired
    private ISysOperLogService operLogService;

    @RequiresPermissions("system:operlog:list")
    @GetMapping("/page")
    public TableDataInfo page(SysOperLog operLog, Page<SysOperLog> page) {
        return getDataTable(operLogService.page(page, Wrappers.lambdaQuery(operLog).in(StringUtils.isNotEmpty(operLog.getBusinessTypes()),SysOperLog::getBusinessType, operLog.getBusinessTypes())));
    }

    @RequiresPermissions("system:operlog:list")
    @GetMapping("/list")
    public AjaxResult list(SysOperLog operLog) {
        return success(operLogService.list(Wrappers.lambdaQuery(operLog).in(StringUtils.isNotEmpty(operLog.getBusinessTypes()),SysOperLog::getBusinessType, operLog.getBusinessTypes())));
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:operlog:remove")
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Integer[] operIds) {
        return toAjax(operLogService.removeBatchByIds(Arrays.asList(operIds)));
    }

    @RequiresPermissions("system:operlog:remove")
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return success();
    }

    @InnerAuth
    @PostMapping
    public AjaxResult add(@RequestBody SysOperLog operLog) {
        return toAjax(operLogService.save(operLog));
    }
}
