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

import com.cl.entity.DiscussxianzhitushuEntity;
import com.cl.entity.view.DiscussxianzhitushuView;

import com.cl.service.DiscussxianzhitushuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 闲置图书评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
@RestController
@RequestMapping("/discussxianzhitushu")
public class DiscussxianzhitushuController {
    @Autowired
    private DiscussxianzhitushuService discussxianzhitushuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxianzhitushuEntity discussxianzhitushu,
		HttpServletRequest request){
        EntityWrapper<DiscussxianzhitushuEntity> ew = new EntityWrapper<DiscussxianzhitushuEntity>();

		PageUtils page = discussxianzhitushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhitushu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxianzhitushuEntity discussxianzhitushu, 
		HttpServletRequest request){
        EntityWrapper<DiscussxianzhitushuEntity> ew = new EntityWrapper<DiscussxianzhitushuEntity>();

		PageUtils page = discussxianzhitushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhitushu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxianzhitushuEntity discussxianzhitushu){
       	EntityWrapper<DiscussxianzhitushuEntity> ew = new EntityWrapper<DiscussxianzhitushuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxianzhitushu, "discussxianzhitushu")); 
        return R.ok().put("data", discussxianzhitushuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxianzhitushuEntity discussxianzhitushu){
        EntityWrapper< DiscussxianzhitushuEntity> ew = new EntityWrapper< DiscussxianzhitushuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxianzhitushu, "discussxianzhitushu")); 
		DiscussxianzhitushuView discussxianzhitushuView =  discussxianzhitushuService.selectView(ew);
		return R.ok("查询闲置图书评论表成功").put("data", discussxianzhitushuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxianzhitushuEntity discussxianzhitushu = discussxianzhitushuService.selectById(id);
		discussxianzhitushu = discussxianzhitushuService.selectView(new EntityWrapper<DiscussxianzhitushuEntity>().eq("id", id));
        return R.ok().put("data", discussxianzhitushu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxianzhitushuEntity discussxianzhitushu = discussxianzhitushuService.selectById(id);
		discussxianzhitushu = discussxianzhitushuService.selectView(new EntityWrapper<DiscussxianzhitushuEntity>().eq("id", id));
        return R.ok().put("data", discussxianzhitushu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxianzhitushuEntity discussxianzhitushu, HttpServletRequest request){
    	discussxianzhitushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianzhitushu);
        discussxianzhitushuService.insert(discussxianzhitushu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxianzhitushuEntity discussxianzhitushu, HttpServletRequest request){
    	discussxianzhitushu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxianzhitushu);
        discussxianzhitushuService.insert(discussxianzhitushu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussxianzhitushuEntity discussxianzhitushu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxianzhitushu);
        discussxianzhitushuService.updateById(discussxianzhitushu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxianzhitushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussxianzhitushuEntity discussxianzhitushu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussxianzhitushuEntity> ew = new EntityWrapper<DiscussxianzhitushuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussxianzhitushuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxianzhitushu), params), params));
        return R.ok().put("data", page);
    }








}
