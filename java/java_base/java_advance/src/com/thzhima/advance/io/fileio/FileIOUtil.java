package com.thzhima.advance.io.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class FileIOUtil {

	
	/**д�����ݵ��ļ���
	 * @param fileName
	 * @param data
	 * @param append
	 * @throws IOException
	 */
	public static void write(String fileName, byte[] data, boolean append) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName, append);
			out.write(data);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != out) {
				out.close();
			}
			
		}
	}
	
	/**
	 * ���ļ��ж�ȡ����
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(String fileName) throws IOException {
		byte[] buffer = null;
		File f = new File(fileName);
		long length = f.length(); // �ļ��ж��
		
		FileInputStream in = null;
		try {
			in = new FileInputStream(f);
			int size = in.available();
			System.out.println(length);
			System.out.println(size);
			// ȷ���ļ����뻺������
			buffer = new byte[size];
			
			in.read(buffer);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in!=null) {
				in.close();
			}
		}
		return buffer;
	}
	
	
	/**
	 * �ļ�copy
	 * @param src
	 * @param tgt
	 * @throws IOException
	 */
	public static void copy(String src, String tgt) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(tgt);
			byte[] buffer = new byte[1024];
			
			int length = -1;
			while(-1 != (length=in.read(buffer))) { // read������-1,��ʾû�ж��ꡣ
				out.write(buffer, 0, length);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out!=null) {
				out.close();
			}
			if(in!=null) {
				in.close();
			}
		}
	}
	
	//============================= �ַ���������� =================================
	// ʹ��FileWriterֱ�ӽ��ַ�д���ļ��С�
	public static void write(String fileName, String msg) throws IOException {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			writer.write(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				writer.close();
			}
		}
	}
	
	// ʹ��CharBuffer��Ϊ���塣
//	public static String readTxt(String fileName) throws IOException {
//		String s = null;
//		FileReader reader = null;
//		try {
//			reader = new FileReader(fileName);
//			CharBuffer buffer = CharBuffer.wrap(new char[10]);
//		    int length = -1;
//		    StringBuffer sb = new StringBuffer();
//		    while(-1 !=(length=reader.read(buffer))) {
//		    	
//		    	char[] data = buffer.array();
//		    	String ss =new String(data,0, length);
//		    	sb.append(ss);
//		    	buffer.clear();
//		    }
//			s = sb.toString();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(null != reader) {
//				reader.close();
//			}
//		}
//		return s;
//	}
	
	// ʹ��FileReaderֱ�Ӵӷ����ж����ַ�����
	public static String readTxt(String fileName) throws IOException {
		String s = null;
		FileReader reader = null;
		try {
			reader = new FileReader(fileName);
			char[] buffer = new char[10];
		    int length = -1;
		    StringBuffer sb = new StringBuffer();
		    
		    while(-1 !=(length=reader.read(buffer))) {
		    	sb.append(buffer, 0, length);
		    	
		    }
			s = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(null != reader) {
				reader.close();
			}
		}
		return s;
	}
	
	// ʹ���Ž��������Խ��ַ���ָ���ı���ת��Ϊ�ֽڣ�д���ļ��С�
	public static void write(String fileName, String data, String charset) throws IOException {
		FileOutputStream out = null;
		OutputStreamWriter outWriter = null;
		
		try {
			out = new FileOutputStream(fileName);
			outWriter = new OutputStreamWriter(out, charset);
			outWriter.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outWriter.close();
			out.close();
		}
		
	}
	
	// ʹ���Ž�����������ָ���ı��룬���ļ����ֽ�ת��Ϊ��ȷ���ַ���
	public static String read(String fileName, String charset) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.equals(new Object());
		FileInputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader bfreader = null;
	
		try {
			in = new FileInputStream(fileName);
			inReader = new InputStreamReader(in, charset);
			bfreader = new BufferedReader(inReader);
			String data = null;
			do{
				data = bfreader.readLine();
				if(data!=null) {
					sb.append(data);
				}
				
			}while(data!=null);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bfreader.close();
			inReader.close();
			in.close();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
//		String msg = "Hello. I like Java too.";
//		FileIOUtil.write("d:\\my.txt", msg.getBytes(), false);
		
//		byte[] data = FileIOUtil.read("d:\\my.txt");
//		System.out.println(Arrays.toString(data));
//		System.out.println(new String(data));
		
//		FileIOUtil.copy("D:\\¼Ƶ\\��ϰ.mp4", "d:\\a.mp4");
		
		String msg = "��Һã��������ǽ��������ļ�������Ͷ����ַ���";
//		FileIOUtil.write("d:\\a.txt", msg);
//		
//		System.out.println(FileIOUtil.readTxt("d:\\a.txt"));
		
		FileIOUtil.write("d:\\b.txt", msg, "utf-8");
		System.out.println(FileIOUtil.read("d:\\b.txt", "utf-8"));
	}
}
