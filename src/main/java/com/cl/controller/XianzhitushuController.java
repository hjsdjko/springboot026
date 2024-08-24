package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XianzhitushuEntity;
import com.cl.entity.view.XianzhitushuView;

import com.cl.service.XianzhitushuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 闲置图书
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
@RestController
@RequestMapping("/xianzhitushu")
public class XianzhitushuController {
    @Autowired
    private XianzhitushuService xianzhitushuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianzhitushuEntity xianzhitushu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xianzhitushu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianzhitushuEntity> ew = new EntityWrapper<XianzhitushuEntity>();

		PageUtils page = xianzhitushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhitushu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianzhitushuEntity xianzhitushu, 
		HttpServletRequest request){
        EntityWrapper<XianzhitushuEntity> ew = new EntityWrapper<XianzhitushuEntity>();

		PageUtils page = xianzhitushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianzhitushu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianzhitushuEntity xianzhitushu){
       	EntityWrapper<XianzhitushuEntity> ew = new EntityWrapper<XianzhitushuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianzhitushu, "xianzhitushu")); 
        return R.ok().put("data", xianzhitushuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianzhitushuEntity xianzhitushu){
        EntityWrapper< XianzhitushuEntity> ew = new EntityWrapper< XianzhitushuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianzhitushu, "xianzhitushu")); 
		XianzhitushuView xianzhitushuView =  xianzhitushuService.selectView(ew);
		return R.ok("查询闲置图书成功").put("data", xianzhitushuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianzhitushuEntity xianzhitushu = xianzhitushuService.selectById(id);
		xianzhitushu = xianzhitushuService.selectView(new EntityWrapper<XianzhitushuEntity>().eq("id", id));
        return R.ok().put("data", xianzhitushu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianzhitushuEntity xianzhitushu = xianzhitushuService.selectById(id);
		xianzhitushu = xianzhitushuService.selectView(new EntityWrapper<XianzhitushuEntity>().eq("id", id));
        return R.ok().put("data", xianzhitushu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianzhitushuEntity xianzhitushu, HttpServletRequest request){
    	xianzhitushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianzhitushu);
        xianzhitushuService.insert(xianzhitushu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianzhitushuEntity xianzhitushu, HttpServletRequest request){
    	xianzhitushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianzhitushu);
        xianzhitushuService.insert(xianzhitushu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianzhitushuEntity xianzhitushu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianzhitushu);
        xianzhitushuService.updateById(xianzhitushu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianzhitushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
