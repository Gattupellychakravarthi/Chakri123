package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private FileUtil() {

	}

	public static FileUtil objforfileutil() {
		FileUtil prop = new FileUtil();
		return prop;
	}

	/**@author HP
	 * Description this method to read the data from property file
	 * @param key
	 * @return value from prop file 
	 * @throws IOException 
	*/
	public String readDatafromPropfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IautoConstants.propfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}

	public String readDatafromPropfile(String key, String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}

}
