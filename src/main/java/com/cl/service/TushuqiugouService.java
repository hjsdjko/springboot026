package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushuqiugouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuqiugouView;


/**
 * 图书求购
 *
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface TushuqiugouService extends IService<TushuqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuqiugouView> selectListView(Wrapper<TushuqiugouEntity> wrapper);
   	
   	TushuqiugouView selectView(@Param("ew") Wrapper<TushuqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuqiugouEntity> wrapper);
   	

}

