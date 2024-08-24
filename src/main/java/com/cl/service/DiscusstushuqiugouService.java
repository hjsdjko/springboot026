package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusstushuqiugouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusstushuqiugouView;


/**
 * 图书求购评论表
 *
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface DiscusstushuqiugouService extends IService<DiscusstushuqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstushuqiugouView> selectListView(Wrapper<DiscusstushuqiugouEntity> wrapper);
   	
   	DiscusstushuqiugouView selectView(@Param("ew") Wrapper<DiscusstushuqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstushuqiugouEntity> wrapper);
   	

}

