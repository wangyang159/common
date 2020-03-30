package com.wy.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	/**
	 * 读取一个文件的全部信息，以每一行为单位，存放到list集合中
	 * @param input
	 * @return
	 * @throws IOException 
	 */
	public static List<String> loadFile(InputStream input) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(input));
		List<String> result=new ArrayList<String>();
		String buffer;
		while( (buffer=br.readLine())!=null ){
			result.add(buffer);
		}
		return result;
	}
}
