package com.springboot.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yan
 * @since 2018-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
public class LogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户操作
     */
    @TableField("operation")
    private String operation;

    /**
     * 请求方法
     */
    @TableField("method")
    private String method;

    /**
     * 请求参数
     */
    @TableField("params")
    private String params;

    /**
     * 执行时长
     */
    @TableField("time")
    private Integer time;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private LocalDateTime createDate;


}
