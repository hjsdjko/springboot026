package com.cl.dao;

import com.cl.entity.TushuqiugouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuqiugouView;


/**
 * 图书求购
 * 
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface TushuqiugouDao extends BaseMapper<TushuqiugouEntity> {
	
	List<TushuqiugouView> selectListView(@Param("ew") Wrapper<TushuqiugouEntity> wrapper);

	List<TushuqiugouView> selectListView(Pagination page,@Param("ew") Wrapper<TushuqiugouEntity> wrapper);
	
	TushuqiugouView selectView(@Param("ew") Wrapper<TushuqiugouEntity> wrapper);
	

}
