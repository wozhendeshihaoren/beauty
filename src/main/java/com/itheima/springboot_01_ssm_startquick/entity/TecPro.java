package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Tecpro)实体类
 *
 * @author makejava
 * @since 2022-08-03 09:37:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecPro implements Serializable {

    private Long id;
    
    private Long tecId;
    
    private Long proId;



}

