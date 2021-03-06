package com.sitech.prm.subject.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
	
	public static void main(String[] args) throws Exception {
		
		getPackageNameAndClassName();//通过Java反射机制得到类的包名和类名
		checkClass();//验证所有的类都是Class类的实例对象
		createInstanceByClass();//通过Java反射机制，用Class 创建类对象
		createInstanceByConstructor();//通过Java反射机制得到一个类的构造函数，并实现构造带参实例对象
		getField();//通过Java反射机制操作成员变量, set 和 get
		getInfoFromSuperclassAndInterface();//通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
		invokeMethod();//通过Java反射机制调用类中方法
		
	}
	
	/**
	 * Demo1: 通过Java反射机制得到类的包名和类名
	 */
	public static void getPackageNameAndClassName(){
		Person person = new Person();
		System.out.println("Demo1: 包名: " + person.getClass().getPackage().getName() + "，" 
				+ "完整类名: " + person.getClass().getName());
		printLine();
	}
	
	/**
	 * Demo2: 验证所有的类都是Class类的实例对象
	 */
	public static void checkClass() throws ClassNotFoundException{
		//定义两个类型都未知的Class , 设置初值为null, 看看如何给它们赋值成Person类
		Class<?> class1 = null;
        Class<?> class2 = null;
        
        //写法1, 可能抛出 ClassNotFoundException [多用这个写法]
        class1 = Class.forName("com.sitech.prm.subject.reflect.Person");
        System.out.println("Demo2:(写法1) 包名: " + class1.getPackage().getName() + "，" 
				+ "完整类名: " + class1.getName());
        
        //写法2
        class2 = Person.class;
        System.out.println("Demo2:(写法2) 包名: " + class2.getPackage().getName() + "，" 
				+ "完整类名: " + class2.getName());
        printLine();
	}
	
	/**
	 * Demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
	 */
	public static void createInstanceByClass() throws Exception	{
		Class<?> class1 = null;
		class1 = Class.forName("com.sitech.prm.subject.reflect.Person");
		//由于这里不能带参数，所以你要实例化的这个类Person，一定要有无参构造函数哈～
		Person person = (Person) class1.newInstance();
		person.setAge(20);
		person.setName("sunyaozong");
		System.out.println("Demo3: " + person.getName() + " : " + person.getAge());
		printLine();
	}
	
	/**
	 * Demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
	 */
	public static void createInstanceByConstructor() throws Exception{
		Class<?> class1 = null;
		Person person1 = null;
		Person person2 = null;
		
		class1 = Class.forName("com.sitech.prm.subject.reflect.Person");
		//得到一系列构造函数集合
		Constructor<?>[] constructors = class1.getConstructors();
		
		person1 = (Person) constructors[0].newInstance();
		person1.setAge(30);
		person1.setName("sunyaozong");
		
		person2 = (Person) constructors[1].newInstance(20,"sunyaozong");
		
		System.out.println("Demo4: " + person1.getName() + " : " + person1.getAge()
				+ "  ,   " + person2.getName() + " : " + person2.getAge());
		printLine();
	}
	
	/**
	 * Demo5: 通过Java反射机制操作成员变量, set 和 get
	 */
	public static void getField() throws Exception{
		Class<?> class1 = null;
		class1 = Class.forName("com.sitech.prm.subject.reflect.Person");
		Object obj = class1.newInstance();
		
		Field personNameField = class1.getDeclaredField("name");
		personNameField.setAccessible(true);
		personNameField.set(obj, "孙耀宗");
		
		System.out.println("Demo5: 修改属性之后得到属性变量的值：" + personNameField.get(obj));
		printLine();
	}
	

	/**
	 * Demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
	 */
	public static void getInfoFromSuperclassAndInterface() throws Exception{
		Class<?> class1 = null;
		class1 = Class.forName("com.sitech.prm.subject.reflect.SuperMan");
		
		//取得父类名称
		Class<?>  superClass = class1.getSuperclass();
		System.out.println("Demo6:  SuperMan类的父类名: " + superClass.getName());
		
		System.out.println("===============================================");
		
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("类中的成员: " + fields[i]);
		}
		System.out.println("===============================================");
		
		
		//取得类方法
		Method[] methods = class1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("Demo6,取得SuperMan类的方法：");
			System.out.println("函数名：" + methods[i].getName());
			System.out.println("函数返回类型：" + methods[i].getReturnType());
			System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
			System.out.println("函数代码写法： " + methods[i]);
		}
		
		System.out.println("===============================================");
		
		//取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈
		Class<?> interfaces[] = class1.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("实现的接口类名: " + interfaces[i].getName() );
		}
		printLine();
		
	}
	
	/**
	 * Demo7: 通过Java反射机制调用类方法
	 */
	public static void invokeMethod() throws Exception{
		Class<?> class1 = null;
		class1 = Class.forName("com.sitech.prm.subject.reflect.SuperMan");
		
		System.out.println("Demo7: \n调用无参方法fly()：");
		Method method = class1.getMethod("fly");
		method.invoke(class1.newInstance());
		
		System.out.println("调用有参方法walk(int m)：");
		method = class1.getMethod("walk",int.class);
		method.invoke(class1.newInstance(),100);
		printLine();
	}
	
	private static void printLine() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}
}

interface ActionInterface{
	public void walk(int m);
}

class  Person{
	private int age;
	private String name;
	public Person(){
		
	}
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
}

class SuperMan extends Person implements ActionInterface{
	private boolean BlueBriefs;
	
	public void fly()
	{
		System.out.println("超人会飞耶～～");
	}
	
	public boolean isBlueBriefs() {
		return BlueBriefs;
	}
	public void setBlueBriefs(boolean blueBriefs) {
		BlueBriefs = blueBriefs;
	}

	@Override
	public void walk(int m) {
		System.out.println("超人会走耶～～走了" + m + "米就走不动了！");
	}
	
}
