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


import com.cl.dao.TushuqiugouDao;
import com.cl.entity.TushuqiugouEntity;
import com.cl.service.TushuqiugouService;
import com.cl.entity.view.TushuqiugouView;

@Service("tushuqiugouService")
public class TushuqiugouServiceImpl extends ServiceImpl<TushuqiugouDao, TushuqiugouEntity> implements TushuqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuqiugouEntity> page = this.selectPage(
                new Query<TushuqiugouEntity>(params).getPage(),
                new EntityWrapper<TushuqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuqiugouEntity> wrapper) {
		  Page<TushuqiugouView> page =new Query<TushuqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TushuqiugouView> selectListView(Wrapper<TushuqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuqiugouView selectView(Wrapper<TushuqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
