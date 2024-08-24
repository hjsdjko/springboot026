package com.cl.dao;

import com.cl.entity.DiscussxianzhitushuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxianzhitushuView;


/**
 * 闲置图书评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
public interface DiscussxianzhitushuDao extends BaseMapper<DiscussxianzhitushuEntity> {
	
	List<DiscussxianzhitushuView> selectListView(@Param("ew") Wrapper<DiscussxianzhitushuEntity> wrapper);

	List<DiscussxianzhitushuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxianzhitushuEntity> wrapper);
	
	DiscussxianzhitushuView selectView(@Param("ew") Wrapper<DiscussxianzhitushuEntity> wrapper);
	

}
