/**   
 * @Title: PrivateConstructorTest.java 
 * @Package: com.sitech.prm.subject.reflect 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-9-3 下午6:21:41 
 * @version V2.0   
 */
package com.sitech.prm.subject.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import sun.misc.Unsafe;

/**   
 * @Title: PrivateConstructorTest
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class PrivateConstructorTest {

	@Test
	public void unsafeTest() throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null); 
		
		Student student = (Student) unsafe.allocateInstance(Student.class);
		for(Field field:Student.class.getDeclaredFields()){  
			if("id".equals(field.getName())) {
				unsafe.putObjectVolatile(student, unsafe.objectFieldOffset(field), "10002");
			}else if("name".equals(field.getName())) {
				unsafe.putObjectVolatile(student, unsafe.objectFieldOffset(field), "奋斗哥");
			}
        }  
		Assert.assertNotNull(student);
		//可直接访问的方法只有toString
		Assert.assertEquals("Student [id=10002, name=奋斗哥]", student.toString());
	}
	
	@Test
	public void reflectTest() throws Exception{
		//获取私有构造方法
		Class<?> studentClass = Class.forName("com.sitech.prm.subject.reflect.Student");
		Constructor<?> studentConstrucor = studentClass.getDeclaredConstructor(String.class);
		studentConstrucor.setAccessible(true);
		//构造对象
		Student student = (Student) studentConstrucor.newInstance("奋斗");
		
		//获取私有属性并赋值
		Field idField = studentClass.getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(student, "10001");
		
		Assert.assertNotNull(student);
		//可直接访问的方法只有toString
		Assert.assertEquals("Student [id=10001, name=奋斗]", student.toString());
	}
}
