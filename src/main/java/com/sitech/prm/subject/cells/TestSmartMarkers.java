/**   
 * @Title: TestSmartMarkers.java 
 * @Package: com.sitech.prm.subject.cells 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-7-22 上午9:15:15 
 * @version V2.0   
 */
package com.sitech.prm.subject.cells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;

/**   
 * @Title: TestSmartMarkers
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class TestSmartMarkers {

	/**
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args  参数说明 
	 * @return void    返回类型 
	 * @throws Exception 
	 * @throws 
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */

	public static void main(String[] args) throws Exception {
		Workbook workbook = new Workbook("d:\\\\temp\\designer.xlsx");

		WorkbookDesigner designer = new WorkbookDesigner();
		designer.setWorkbook(workbook);

		ArrayList<Individual> list = new ArrayList<Individual>();
		list.add(new Individual("John", 23, new Wife("Jill", 20)));
		list.add(new Individual("Jack", 25, new Wife("Hilly", 21)));
		list.add(new Individual("James", 26, new Wife("Hally", 22)));
		list.add(new Individual("Baptist", 27, new Wife("Newly", 23)));

		//designer.setDataSource("Individual2", getDataList());
		designer.setDataSource("Individual2", getRoleList3());

		designer.process(false);

		workbook.save("d:\\\\temp\\output.xlsx");

	}
	
	private static List<Map<String,Object>> getDataList() {
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("name", "admin");
		data.put("age", "超级管理员");
		
		datas.add(data);
		return datas;
	}
	
	private static ArrayList<Role2> getRoleList() {
		ArrayList<Role2> datas = new ArrayList<Role2>();
		datas.add(new Role2("1","a"));
		datas.add(new Role2("2","b"));
		
		return datas;
	}
	
	private static ArrayList<Role3> getRoleList3() {
		ArrayList<Role3> datas = new ArrayList<Role3>();
		datas.add(new Role3("1","a"));
		datas.add(new Role3("2","b"));
		
		return datas;
	}
}


class Role2{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Role2(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
}




