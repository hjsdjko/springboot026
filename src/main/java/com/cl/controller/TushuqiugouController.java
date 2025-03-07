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

import com.cl.entity.TushuqiugouEntity;
import com.cl.entity.view.TushuqiugouView;

import com.cl.service.TushuqiugouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 图书求购
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
@RestController
@RequestMapping("/tushuqiugou")
public class TushuqiugouController {
    @Autowired
    private TushuqiugouService tushuqiugouService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuqiugouEntity tushuqiugou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tushuqiugou.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushuqiugouEntity> ew = new EntityWrapper<TushuqiugouEntity>();

		PageUtils page = tushuqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuqiugou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushuqiugouEntity tushuqiugou, 
		HttpServletRequest request){
        EntityWrapper<TushuqiugouEntity> ew = new EntityWrapper<TushuqiugouEntity>();

		PageUtils page = tushuqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuqiugou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuqiugouEntity tushuqiugou){
       	EntityWrapper<TushuqiugouEntity> ew = new EntityWrapper<TushuqiugouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuqiugou, "tushuqiugou")); 
        return R.ok().put("data", tushuqiugouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuqiugouEntity tushuqiugou){
        EntityWrapper< TushuqiugouEntity> ew = new EntityWrapper< TushuqiugouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuqiugou, "tushuqiugou")); 
		TushuqiugouView tushuqiugouView =  tushuqiugouService.selectView(ew);
		return R.ok("查询图书求购成功").put("data", tushuqiugouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuqiugouEntity tushuqiugou = tushuqiugouService.selectById(id);
		tushuqiugou = tushuqiugouService.selectView(new EntityWrapper<TushuqiugouEntity>().eq("id", id));
        return R.ok().put("data", tushuqiugou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuqiugouEntity tushuqiugou = tushuqiugouService.selectById(id);
		tushuqiugou = tushuqiugouService.selectView(new EntityWrapper<TushuqiugouEntity>().eq("id", id));
        return R.ok().put("data", tushuqiugou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuqiugouEntity tushuqiugou, HttpServletRequest request){
    	tushuqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuqiugou);
        tushuqiugouService.insert(tushuqiugou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuqiugouEntity tushuqiugou, HttpServletRequest request){
    	tushuqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuqiugou);
        tushuqiugouService.insert(tushuqiugou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuqiugouEntity tushuqiugou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuqiugou);
        tushuqiugouService.updateById(tushuqiugou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuqiugouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
