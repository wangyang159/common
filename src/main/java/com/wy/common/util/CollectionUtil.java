package com.wy.common.util;

import java.util.Collection;

public class CollectionUtil {
	/**
	 * 判断一个集合是否为空
	 * 为空则返回true
	 * 不为空返回false
	 * @return
	 */
	public static boolean isNull(Collection coll){
		if(coll==null || coll.isEmpty()){
			return true;
		}
		return false;
	}
}
