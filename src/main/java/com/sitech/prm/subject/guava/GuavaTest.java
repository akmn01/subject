/*************************************************
 * 北京思特奇信息技术股份有限公司版权所有
 * Copyright (C), Si-tech.
 * @Title: GuavaTest.java   
 * @Package com.sitech.prm.subject.guava   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author Administrator
 * @date 2016-1-21 上午10:36:19   
 * @version V1.0
 * History:
 *	1. Date:2016-1-21
 *     Author:Administrator
 *     Modification:(描述修改了什么内容)
 *  2. ...
*************************************************/
package com.sitech.prm.subject.guava;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * <p>Title: GuavaTest.java</p>
 * <p>Description: TODO(这里用一句话描述这个方法的作用) </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: SI-TECH </p>
 * @author SUNYZ
 * @version 1.0
 * @create 2016-1-21
 * 修改日期  修改人  修改目的
 */

public class GuavaTest {
	
	public static void main(String[] args) {
		
		//初始化创建List  Map
		List<String> list = Lists.newArrayList("1","b","3");
		Map<String,Integer> map = Maps.newLinkedHashMap(ImmutableMap.of("minAge",10,"MaxAge",35));
		System.out.println("list:"+list);
		System.out.println("map:"+map);
		
		//迭代初始化  可能用于服务获取后的参数处理
		ImmutableMap.Builder<String, Integer> builder = ImmutableMap.builder();
		for (Entry<String, Integer> entry:map.entrySet()) {
			builder.put(entry.getKey().toString(), entry.getValue()+10);
		}
		map = builder.build();
		//
		System.out.println("wappered map:"+map);
		
		//测试前置条件
		try {
			Preconditions.checkNotNull(null);
		} catch (Exception e) {
			System.err.println("测试前置条件 测试结果得到空指针异常");
		}
		
		//hashCode
		System.out.println(Objects.hashCode(map,builder));
		System.out.println(MoreObjects.toStringHelper(GuavaTest.class).add("x", 1).toString());;
		
		//比较器
		System.out.println(ComparisonChain.start().compare("1", "1").compare(2, 4).result());
		
		//排序器
		System.out.println("排序器natural():"+Ordering.natural().max(list.iterator()));
		System.out.println("排序器usingToString().reverse():"+Ordering.usingToString().reverse().max(list.iterator()));
		System.out.println("排序器natural()+function:"+Ordering.natural().nullsFirst().onResultOf(new Function<String, String>() {
			public String apply(String input) {
				return input+"0";
			}
		}).max(list.iterator()));
		
		
	}

}
