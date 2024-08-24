package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussxianzhitushuDao;
import com.cl.entity.DiscussxianzhitushuEntity;
import com.cl.service.DiscussxianzhitushuService;
import com.cl.entity.view.DiscussxianzhitushuView;

@Service("discussxianzhitushuService")
public class DiscussxianzhitushuServiceImpl extends ServiceImpl<DiscussxianzhitushuDao, DiscussxianzhitushuEntity> implements DiscussxianzhitushuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxianzhitushuEntity> page = this.selectPage(
                new Query<DiscussxianzhitushuEntity>(params).getPage(),
                new EntityWrapper<DiscussxianzhitushuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxianzhitushuEntity> wrapper) {
		  Page<DiscussxianzhitushuView> page =new Query<DiscussxianzhitushuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxianzhitushuView> selectListView(Wrapper<DiscussxianzhitushuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxianzhitushuView selectView(Wrapper<DiscussxianzhitushuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
