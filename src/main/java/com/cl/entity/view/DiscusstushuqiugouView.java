package com.cl.entity.view;

import com.cl.entity.DiscusstushuqiugouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 图书求购评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
@TableName("discusstushuqiugou")
public class DiscusstushuqiugouView  extends DiscusstushuqiugouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstushuqiugouView(){
	}
 
 	public DiscusstushuqiugouView(DiscusstushuqiugouEntity discusstushuqiugouEntity){
 	try {
			BeanUtils.copyProperties(this, discusstushuqiugouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
