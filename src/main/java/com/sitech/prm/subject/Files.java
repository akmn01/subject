/**   
 * @Title: Files.java 
 * @Package: com.sitech.prm.subject 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-8-27 下午12:50:01 
 * @version V2.0   
 */
package com.sitech.prm.subject;

import java.io.File;

/**   
 * @Title: Files
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class Files {
	
	public static void main(String[] args) {
		/*String folderName = "D:\\\\temp\\14722764019392/";
		File folder = new File(folderName);
		folder.mkdirs();*/
		String folderName = "D:\\workspace\\subject\\src";
		File rootFile = new File(folderName);
		if(rootFile.exists()){
			getFileInfo(rootFile);
		}
	}
	
	public static void getFileInfo(File file){
		if(!file.isDirectory()){
			System.out.println(file.getPath());
		}else{
			for(File subFile : file.listFiles()){
				getFileInfo(subFile);
			}
		}
		
	}
}
