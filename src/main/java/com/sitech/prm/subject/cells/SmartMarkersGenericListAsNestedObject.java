/**   
 * @Title: SmartMarkersGenericListAsNestedObject.java 
 * @Package: com.sitech.prm.subject.cells 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-7-21 下午4:16:15 
 * @version V2.0   
 */
package com.sitech.prm.subject.cells;

import java.util.ArrayList;

import com.aspose.cells.BackgroundType;
import com.aspose.cells.Color;
import com.aspose.cells.Range;
import com.aspose.cells.Style;
import com.aspose.cells.StyleFlag;
import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;

/**   
 * @Title: SmartMarkersGenericListAsNestedObject
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class SmartMarkersGenericListAsNestedObject {

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
		//Create a designer workbook
        Workbook workbook = new Workbook();

        Worksheet worksheet = workbook.getWorksheets().get(0);

        worksheet.getCells().get("A1").putValue("Husband NAME");
        worksheet.getCells().get("A2").putValue("&=Husband.LOGIN_NAME");

        worksheet.getCells().get("B1").putValue("Husband Age");
        worksheet.getCells().get("B2").putValue("&=Husband.Age");

        worksheet.getCells().get("C1").putValue("Wife's Name");
        worksheet.getCells().get("C2").putValue("&=Husband.Wives.Name");

        worksheet.getCells().get("D1").putValue("Wife's Age");
        worksheet.getCells().get("D2").putValue("&=Husband.Wives.Age");

        //Apply Style to A1:D1
        Range range = worksheet.getCells().createRange("A1:D1");
        Style style = workbook.createStyle();
        style.getFont().setBold(true);
        style.setForegroundColor(Color.getYellow());
        style.setPattern(BackgroundType.SOLID);
        StyleFlag flag = new StyleFlag();
        flag.setAll(true);
        range.applyStyle(style, flag);

       

        ArrayList<Husband> list = new ArrayList<Husband>();

        //Create the relevant Wife objects for the Husband object
        ArrayList<Wife> wives = new ArrayList<Wife>();
        wives.add(new Wife("Chen Zhao", 34));
        wives.add(new Wife("Jamima Winfrey", 28));
        wives.add(new Wife("Reham Smith", 35));

        //Create a Husband object
        Husband h1 = new Husband("Mark John", 30, wives);

        //Create the relevant Wife objects for the Husband object
        wives = new ArrayList<Wife>();
        wives.add(new Wife("Karishma Jathool", 36));
        wives.add(new Wife("Angela Rose", 33));
        wives.add(new Wife("Hina Khanna", 45));

        //Create a Husband object
        Husband h2 = new Husband("Masood Shankar", 40, wives);

        //Add the objects to the list
        list.add(h1);
        list.add(h2);

        WorkbookDesigner designer = new WorkbookDesigner();
        designer.setWorkbook(workbook);
        designer.setDataSource("Husband", list);
        designer.process(false);
        worksheet.autoFitColumns();
        designer.getWorkbook().save("d:\\\\temp\\output.xlsx");

	}
	

}
