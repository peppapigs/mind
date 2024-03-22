package com.xg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id") //front-end uid: v1 key:value-=> id: v1
    @TableId(type = IdType.AUTO)
    private Integer uid;
    @TableField(value = "username")
    private String username;
//    @JsonInclude//可作用与实体类和属性,用于忽略NUll值,空内容(不过已经在service层通过mapper查找时候,通过各wrapper的select方法指定字段,并配置了空值不显示)
    @JsonIgnore //transfer to front-end without display of password key:value
    @TableField(value = "password")
    private String password;
    @TableField(value = "email")
    private String email;

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

}