package com.cl.dao;

import com.cl.entity.DiscusstushuqiugouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusstushuqiugouView;


/**
 * 图书求购评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface DiscusstushuqiugouDao extends BaseMapper<DiscusstushuqiugouEntity> {
	
	List<DiscusstushuqiugouView> selectListView(@Param("ew") Wrapper<DiscusstushuqiugouEntity> wrapper);

	List<DiscusstushuqiugouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstushuqiugouEntity> wrapper);
	
	DiscusstushuqiugouView selectView(@Param("ew") Wrapper<DiscusstushuqiugouEntity> wrapper);
	

}
