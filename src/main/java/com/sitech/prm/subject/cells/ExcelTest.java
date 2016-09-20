package com.sitech.prm.subject.cells;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.PageSetup;
import com.aspose.cells.Row;
import com.aspose.cells.RowCollection;
import com.aspose.cells.Style;
import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.google.common.collect.ImmutableMap;

public class ExcelTest {

	

	public static void main(String[] args) throws Exception {
		//add();
		exchangeFile();
		//numbertest();
	}

	
	private static void add() throws Exception {
		Workbook workbook = new Workbook();
		WorkbookDesigner designer = new WorkbookDesigner();
		designer.setWorkbook(workbook);
		workbook.getWorksheets().get(0).getCells().get("A1").putValue("&=$VariableArray(HTML)");
		designer.setDataSource("VariableArray", new String[] { "Hello <b>World</b>", "Arabic", "Hindi", "Urdu", "French" });
		designer.process(false);
		designer.getWorkbook().save("d:\\\\temp\\out_varaiblearray1.xlsx");
	}
	
	
	private static void numbertest() {
		Workbook workbook = new Workbook();

		//Accessing the added worksheet in the Excel file
		//int sheetIndex = workbook.getWorksheets().add();
		Worksheet worksheet = workbook.getWorksheets().get(0);
		Cells cells = worksheet.getCells();

		//Adding the current system date to "A1" cell
		Cell cell = cells.get("A1");
		cell.setValue(Calendar.getInstance());
		Style style = cell.getStyle();
		style.setNumber(15);
		cell.setStyle(style);

		//Adding a numeric value to "A2" cell
		cell = cells.get("A2");
		cell.setValue(20);
		style = cell.getStyle();
		style.setNumber(9);
		cell.setStyle(style);

		//Adding a numeric value to "A3" cell
		cell = cells.get("A3");
		cell.setValue(154621312);
		style = cell.getStyle();
		//style.setNumber(6);
		cell.setStyle(style);
		

		//Saving the modified Excel file in default format
		try {
			workbook.save("d:\\\\temp\\numbertest.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exchangeFile() throws Exception {
		
		ImmutableMap<String, String> params = ImmutableMap.of(
				"TITLE","测试标题",
				"SYS_DATE","2016-1-1"
				);
		
		/*Workbook workbookTemplate = new Workbook("d:\\\\TEMP2\\模板.xlsx");
		Object workbookTemplateObj = workbookTemplate;
		List<Integer> blankSheetIndexs = new ArrayList<Integer>();
		int k=0;
		for(int i=0;i<workbookTemplate.getWorksheets().getCount();i++) {
			if(-1 == workbookTemplate.getWorksheets().get(i).getCells().getMaxRow()) {
				workbookTemplate.getWorksheets().removeAt(i);
				i--;
			}
		}
		for(int blankSheetIndex : blankSheetIndexs) {
			
		}
		Workbook temp = new Workbook();
		temp.combine(workbookTemplate);
		
		temp.save("d:\\\\temp\\xxxx.xlsx");
		
		workbookTemplate.save("d:\\\\temp\\output_temp.xlsx");
		System.out.println(((Workbook)workbookTemplateObj).getWorksheets().getCount());*/
		
		Workbook workbook = new Workbook("d:\\\\TEMP2\\模板.xlsx");
		WorksheetCollection sheets = workbook.getWorksheets();
		Worksheet sheet = null;
		Cells cells = null;
		int maxRow = 1;
		int maxColumn = 1;
		RowCollection rows = null;
		Row row =null;
		Cell cell = null;
		String srcText = null;
		String changedText = null;
		WorkbookDesigner designer = new WorkbookDesigner();
        designer.setWorkbook(workbook);
		for(int i =0 ; i<sheets.getCount(); i++) {
			sheet = sheets.get(i);
			cells = sheet.getCells();
			maxRow = cells.getMaxRow();
			maxColumn = cells.getMaxColumn();
			rows = cells.getRows();
			System.out.println("maxRow:"+maxRow);
			if(maxRow<=0) break;
			int dataTitleRowIndex = 0; 
			List<Object> dataTitles = new ArrayList<Object>();
			Style  style = null;
			for(int rowIndex=0;rowIndex<maxRow; rowIndex++){
				row = rows.get(rowIndex);
				for(int columnIndex=0;columnIndex<=maxColumn;columnIndex++) {
					cell = row.get(columnIndex);
					srcText = ObjectUtils.toString(cell.getValue());
					System.out.println("["+rowIndex+","+columnIndex+"]" + srcText);
					
					style = cells.getCell(rowIndex+1, columnIndex).getStyle();
					//style.setNumber(10);
					System.err.println("["+(rowIndex+1)+","+columnIndex+"]"+cells.getCell(rowIndex+1, columnIndex).getValue()+":"+style.getNumber());
					
					if(StringUtils.isNotBlank(srcText)) {
						changedText = StringUtils.replaceEachRepeatedly(srcText, params.keySet().toArray(new String[] {}), params.values().toArray(new String[] {}));
						if(!changedText.equals(srcText)) {
							cell.setValue(changedText);
						}else if(StringUtils.startsWith(srcText, "$")) {
							changedText = StringUtils.replaceOnce(srcText, "$", "&=Record.");
							dataTitleRowIndex = rowIndex;
							dataTitles.add(changedText);
							
							
							cell.setValue(changedText);
							if(2==cell.getColumn()) {
								style = cell.getStyle();
								//style.setCustom("$###,###,##0");
								//style.setNumber(10);
								cell.setStyle(style);
								if(StringUtils.contains(style.getCultureCustom(), "0")) {
									System.out.println("------------------"+changedText);
									try {
										cell.setValue(new BigDecimal(changedText));
									} catch (Exception e) {
										cell.setValue(changedText);
									}
								}
							}
							if(5==cell.getColumn()) {
								cell.setStyle(style);
							}
						}
					}
				}
			}
			
			
	        designer.setDataSource("Record", new AsposeMap(getDataList(i)));
	        designer.process();
	        
	        cells.insertRow(dataTitleRowIndex+getDataList(i).size());
	        cells.importObjectArray(dataTitles.toArray(), dataTitleRowIndex+getDataList(i).size(), 0, false, 0);
	        
	        designer.setDataSource("Record", new AsposeMap(getDataList(i+2)));
	        designer.process();
	        sheet.autoFitColumns();
		}
		
		//workbook.combine(workbookTemplate);
		workbook.getWorksheets().setActiveSheetIndex(0);
		Worksheet worksheet = workbook.getWorksheets().get(0);
		PageSetup pageSetup = worksheet.getPageSetup();
		pageSetup.setHeader(0, "编号：MY001\n帐期：${年份}年${月份}月");
		pageSetup.setFooter(0, "统计人：__________\n\n");
		pageSetup.setFooter(1, "审核人：__________\n\n第 &P 页，共 &N 页");
		pageSetup.setFooter(2, "部门领导：__________\n\n");
		designer.getWorkbook().save("d:\\\\temp\\output.xlsx");
		
		
	}
	
	private static List<Map<String,Object>> getDataList(int index) {
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("LOGIN_NO", "adminaaaaaa"+index);
		data.put("LOGIN_NAME", "超级管理员"+index);
		Object obj =11111112;
		BigDecimal bg = new BigDecimal("123456000");
		bg.setScale(1);
		System.out.println(bg);
		data.put("PASSWORD", bg);
		data.put("TYPE", "T"+index);
		data.put("TIME", 123321);
		data.put("OP_LOGIN", "admin"+index);
		datas.add(data);
		
		
		Map<String,Object> data2 = new HashMap<String, Object>();
		data2.put("LOGIN_NO", "haku"+index);
		data2.put("LOGIN_NAME", "刁梁子"+index);
		data2.put("PASSWORD",  123456666);
		data2.put("TYPE", "T"+index);
		data2.put("TIME", "2016-05-31");
		data2.put("OP_LOGIN", "haku"+index);
		datas.add(data2);
		
		Map<String,Object> data3 = new HashMap<String, Object>();
		data3.put("LOGIN_NO", "haku"+index);
		data3.put("LOGIN_NAME", "刁梁子~"+index);
		data3.put("PASSWORD",  "123456666");
		data3.put("TYPE", "T"+index);
		data3.put("TIME", "2016-05-31");
		data3.put("OP_LOGIN", "haku"+index);
		datas.add(data3);
		
		return datas;
	}
	
	private static ArrayList<Role> getRoleList() {
		ArrayList<Role> datas = new ArrayList<Role>();
		datas.add(new Role("1","a"));
		datas.add(new Role("2","b"));
		
		return datas;
	}

}


class Role{
	private String LOGIN_NO;
	private String LOGIN_NAME;
	public String getLOGIN_NO() {
		return LOGIN_NO;
	}
	public Role() {
		
	}
	public void setLOGIN_NO(String lOGIN_NO) {
		LOGIN_NO = lOGIN_NO;
	}
	public String getLOGIN_NAME() {
		return LOGIN_NAME;
	}
	public void setLOGIN_NAME(String lOGIN_NAME) {
		LOGIN_NAME = lOGIN_NAME;
	}
	public Role(String lOGIN_NO, String lOGIN_NAME) {
		super();
		LOGIN_NO = lOGIN_NO;
		LOGIN_NAME = lOGIN_NAME;
	}
}
