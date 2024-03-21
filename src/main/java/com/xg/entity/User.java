package com.xg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DB TableName: user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@TableName(value = "user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer uid;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "email")
    private String email;

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

}