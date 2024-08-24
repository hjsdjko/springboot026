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


import com.cl.dao.XianzhitushuDao;
import com.cl.entity.XianzhitushuEntity;
import com.cl.service.XianzhitushuService;
import com.cl.entity.view.XianzhitushuView;

@Service("xianzhitushuService")
public class XianzhitushuServiceImpl extends ServiceImpl<XianzhitushuDao, XianzhitushuEntity> implements XianzhitushuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianzhitushuEntity> page = this.selectPage(
                new Query<XianzhitushuEntity>(params).getPage(),
                new EntityWrapper<XianzhitushuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianzhitushuEntity> wrapper) {
		  Page<XianzhitushuView> page =new Query<XianzhitushuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XianzhitushuView> selectListView(Wrapper<XianzhitushuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianzhitushuView selectView(Wrapper<XianzhitushuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
