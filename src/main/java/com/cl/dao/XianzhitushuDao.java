package com.cl.dao;

import com.cl.entity.XianzhitushuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianzhitushuView;


/**
 * 闲置图书
 * 
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface XianzhitushuDao extends BaseMapper<XianzhitushuEntity> {
	
	List<XianzhitushuView> selectListView(@Param("ew") Wrapper<XianzhitushuEntity> wrapper);

	List<XianzhitushuView> selectListView(Pagination page,@Param("ew") Wrapper<XianzhitushuEntity> wrapper);
	
	XianzhitushuView selectView(@Param("ew") Wrapper<XianzhitushuEntity> wrapper);
	

}
