package com.cl.entity.view;

import com.cl.entity.TushuqiugouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 图书求购
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-27 20:52:49
 */
@TableName("tushuqiugou")
public class TushuqiugouView  extends TushuqiugouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushuqiugouView(){
	}
 
 	public TushuqiugouView(TushuqiugouEntity tushuqiugouEntity){
 	try {
			BeanUtils.copyProperties(this, tushuqiugouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
