package com.sitech.prm.subject.cells;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.aspose.cells.ICellsDataTable;

public class AsposeMap  implements ICellsDataTable{
	
	//数据集合  
    @SuppressWarnings("rawtypes")
    private List<Map<String,Object>> dataList = null;  
 
    //索引  
    private int index;  
       
    //存放dataList当中Map<String, Object>的key  
    private String[] columns = null;  
   
    @SuppressWarnings("rawtypes")
    public AsposeMap(Map data) {  
        if(this.dataList == null) {  
            this.dataList = new ArrayList<Map<String,Object>>();  
        }  
        dataList.add(data);
    }  
    
    @SuppressWarnings("rawtypes")
    public AsposeMap(List<Map<String,Object>> data) {  
        this.dataList = data;  
    } 

	/**
	 * @Description: 初始化方法
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	public void beforeFirst() {
		index = -1;  
        columns = this.getColumns(); 
	}

	/**
	 * @Description: WorkbookDesigner自动调用 
     * 会将this.getColumns()方法所返回的列 按照顺序调用改方法  
	 * @param arg0
	 * @return
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object get(int columnIndex) {
		if(index < 0 || index >= this.getCount()) {  
            return null;  
        }  
        Map record = this.dataList.get(index);  
        String columnName = this.columns[columnIndex];  
        return record.get(columnName); 
	}

	/**
	 * @Description: 根据columnName返回数据
	 * @param arg0
	 * @return
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object get(String columnName) {
		 Map record = this.dataList.get(index);  
	     return record.get(columnName); 
	}

	/**
	 * @Description: 获得列集合
	 * @return
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getColumns() {
		if(this.dataList.size() == 0) return new String[] {};
		Map temp = this.dataList.get(0);  
        Set<Entry> entrys = temp.entrySet();  
        List<String> columns = new ArrayList<String>();  
        for (Entry e : entrys) {  
            columns.add((String)e.getKey());  
        }  
        String[] s = new String[entrys.size()];  
        columns.toArray(s);  
        return s; 
	}

	/**
	 * @Description: 获取数据总数 
	 * @return
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	public int getCount() {
		return this.dataList.size();
	}

	/**
	 * @Description: 判断是否还有数据 并将index下移
	 * @return
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	public boolean next() {
		return ++index<this.getCount();
	}

}
