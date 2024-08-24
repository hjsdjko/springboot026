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


import com.cl.dao.DiscusstushuqiugouDao;
import com.cl.entity.DiscusstushuqiugouEntity;
import com.cl.service.DiscusstushuqiugouService;
import com.cl.entity.view.DiscusstushuqiugouView;

@Service("discusstushuqiugouService")
public class DiscusstushuqiugouServiceImpl extends ServiceImpl<DiscusstushuqiugouDao, DiscusstushuqiugouEntity> implements DiscusstushuqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstushuqiugouEntity> page = this.selectPage(
                new Query<DiscusstushuqiugouEntity>(params).getPage(),
                new EntityWrapper<DiscusstushuqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstushuqiugouEntity> wrapper) {
		  Page<DiscusstushuqiugouView> page =new Query<DiscusstushuqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusstushuqiugouView> selectListView(Wrapper<DiscusstushuqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstushuqiugouView selectView(Wrapper<DiscusstushuqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
