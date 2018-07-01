package com.cd.zjyf.management.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.mingyang
 *
 */
public class BeanUtils {
	
	public static <T,V> V copyProperties(Class<V> targetClazz, T source) throws InstantiationException, IllegalAccessException{
		V target= org.springframework.beans.BeanUtils.instantiateClass(targetClazz);
		org.springframework.beans.BeanUtils.copyProperties(source, target);
		return target;
		
	}
	
	public static <T,V> List<V> copyProperties(Class<V> targetClazz, List<T> source) throws InstantiationException, IllegalAccessException{
		List<V> targetList = null;
		if (null != source && source.size() > 0) {
			targetList = new ArrayList<>();
			for (T t : source) {
				V target= org.springframework.beans.BeanUtils.instantiateClass(targetClazz);
				org.springframework.beans.BeanUtils.copyProperties(t, target);
				targetList.add(target);
			}
		}
		return targetList;
		
	}
}
