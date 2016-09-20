package com.sitech.prm.subject.json;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sitech.prm.subject.cells.Role3;

public class GsonTest {
	private static final int BUFFER_SIZE = 16 * 1024;
	
	Gson gson = new GsonBuilder().serializeNulls().create();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//gson = new Gson();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		String fileContent =  this.dealFileContent(new BufferedInputStream(new FileInputStream("d:\\\\temp\\工号导出模板.xlsx"),BUFFER_SIZE));
		System.out.println(fileContent);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id", 0);
		params.put("name", "");
		params.put("gender", null);
		params.put("email", "{.:\"");
		params.put("fileContent", fileContent);
		 
		System.out.println(params.get("email"));
		String emailJson = gson.toJson(params);
		System.out.println("emailJson:"+emailJson);
		Map<String,Object> newParams = gson.fromJson(emailJson, new HashMap<String,Object>().getClass());
		System.out.println(newParams.get("email"));
		
		String roleJson = gson.toJson(new Role3("a",null));
		System.out.println("roleJson:"+roleJson);
		System.out.println(gson.fromJson(roleJson, Role3.class));
	}
	
	/**
     * @param in
     * @return 附件base64编码串
     * @throws Exception
     * @author qinhj
     */
    public String dealFileContent(InputStream in)
    {
        String strBase64 = null;
        try {
            // in.available()返回文件的字节长度
            byte[] bytes = new byte[in.available()];
            // 将文件中的内容读入到数组中
            in.read(bytes);
            strBase64 = new BASE64Encoder().encode(bytes);      //将字节流数组转换为字符串
            in.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strBase64;
    }
}
