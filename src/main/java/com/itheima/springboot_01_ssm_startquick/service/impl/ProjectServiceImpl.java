package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.springboot_01_ssm_startquick.entity.Project;
import com.itheima.springboot_01_ssm_startquick.mapper.ProjectMapper;
import com.itheima.springboot_01_ssm_startquick.model.ProjectModel;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    /**
     * 对数据进行分页，然后返回项目的信息
     * @param pageNum
     * @param size
     * @return
     */
    @Override
    public RespModel getAllProject(int pageNum,int size) {
        try {
            //对页数进行处理，获得开始的id
            int offset = (pageNum-1)*10;

            //对project数据进行分页
            Page<Object> objects = PageHelper.offsetPage(offset, size);
            List<Project> allProject = projectMapper.getAllProject();

            //获取项目的总数据，便于前端可以对数据进行处理
            long total = projectMapper.totalCount();

            //对项目的总数据和总数进行封装，便于返回
            ProjectModel<Project> projectModel = new ProjectModel<>(allProject,total);
            return new RespModel(RespCode.SUCCESS,projectModel);
        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }

    /**
     * 根据项目的id去数据库请求项目的信息
     * @param id
     * @return
     */
    @Override
    public RespModel getById(int id) {
        try {
              Project byId = projectMapper.getById(id);

            return new RespModel(RespCode.SUCCESS,byId);
        }catch (Exception e) {
            return new RespModel(RespCode.FAIL,null);
        }
    }

    /**
     * 根据project的protypeid查询数据
     * @param proTypeId
     * @return
     */
    @Override
    public RespModel getNavTitleProject(int proTypeId) {

        try {
        List<Project> navTitleProject = projectMapper.getNavTitleProject(proTypeId);
        return new RespModel(RespCode.SUCCESS,navTitleProject);

        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }

    /**
     * 获取
     * @param flag
     * @return
     */
    @Override
    public RespModel getFavItem(String flag) {
        try {

        List<Project> favItem = projectMapper.getFavItem(flag);
        return new RespModel(RespCode.SUCCESS,favItem);
        }catch (Exception e) {
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }
    }

    /**
     * 更新项目的收藏状态
     * @param id
     * @param flag
     * @return
     */
    @Override
    public RespModel updateProjectFlag(int id, String flag) {


        try {

            projectMapper.updateProjectFlag(id,flag);

            return new RespModel(RespCode.SUCCESS_5,null);
        }catch (Exception e) {
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }
    }

    /**
     * 获取项目收藏状态为true的数据
     * @return
     */
    @Override
    public RespModel totalCountFlag() {
        try {

            long flagTotal = projectMapper.totalCountFlag();
            return new RespModel(RespCode.SUCCESS,flagTotal);

        } catch (Exception e) {
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }
    }


}
