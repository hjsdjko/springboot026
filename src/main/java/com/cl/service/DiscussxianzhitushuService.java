package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxianzhitushuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxianzhitushuView;


/**
 * 闲置图书评论表
 *
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface DiscussxianzhitushuService extends IService<DiscussxianzhitushuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxianzhitushuView> selectListView(Wrapper<DiscussxianzhitushuEntity> wrapper);
   	
   	DiscussxianzhitushuView selectView(@Param("ew") Wrapper<DiscussxianzhitushuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxianzhitushuEntity> wrapper);
   	

}

