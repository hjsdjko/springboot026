package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XianzhitushuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianzhitushuView;


/**
 * 闲置图书
 *
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface XianzhitushuService extends IService<XianzhitushuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianzhitushuView> selectListView(Wrapper<XianzhitushuEntity> wrapper);
   	
   	XianzhitushuView selectView(@Param("ew") Wrapper<XianzhitushuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianzhitushuEntity> wrapper);
   	

}

