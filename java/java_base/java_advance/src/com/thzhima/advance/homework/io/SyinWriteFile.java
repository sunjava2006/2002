package com.thzhima.advance.homework.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class SyinWriteFile {

	public static String enter() throws IOException {
		StringBuffer sb = new StringBuffer();
		
		InputStreamReader inReader = null;
		BufferedReader bufReader = null;// 有按行读的方法，一次读取一行（读到一个回车符）
		
		try {
			inReader = new InputStreamReader(System.in);
			bufReader = new BufferedReader(inReader);
			while(true) {
				String str = bufReader.readLine();
				if(":exit;".equals(str)) {
					break;
				}else {
					sb.append(str+"\r\n");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufReader.close();
			inReader.close();
			System.in.close();
		}
		
		return sb.toString();
	}
	
	
	public static void write(String file, String msg, String charset) throws IOException {
		FileOutputStream out = null;
		OutputStreamWriter outWriter = null;
		
		try {
			out = new FileOutputStream(file);
			outWriter = new OutputStreamWriter(out, charset);
			
			outWriter.write(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outWriter.close();
			out.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String msg = SyinWriteFile.enter();
		SyinWriteFile.write("d:/enter.txt", msg, "gbk");
	}
}
