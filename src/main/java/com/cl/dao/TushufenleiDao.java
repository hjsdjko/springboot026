package com.cl.dao;

import com.cl.entity.TushufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushufenleiView;


/**
 * 图书分类
 * 
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface TushufenleiDao extends BaseMapper<TushufenleiEntity> {
	
	List<TushufenleiView> selectListView(@Param("ew") Wrapper<TushufenleiEntity> wrapper);

	List<TushufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	
	TushufenleiView selectView(@Param("ew") Wrapper<TushufenleiEntity> wrapper);
	

}
