package com.itheima.springboot_01_ssm_startquick.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author woshihaoren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel<T> {

    private List<T> allProject;
    private  long total;
}
