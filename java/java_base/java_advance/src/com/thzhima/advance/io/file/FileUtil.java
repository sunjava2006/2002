package com.thzhima.advance.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class FileUtil {

	/**
	 * ����һ���ļ�
	 * @param parent
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static File create(String parent, String fileName) throws IOException {
		File f = null;
		f = new File(parent, fileName);
		f.createNewFile();
		return f;
	}
	
	public static File create(String filePath) throws IOException {
		File f = null;
		f = new File(filePath);
		f.createNewFile();
		return f;
	}
	
	public static File createDir(String parent, String child) {
		File dir = null;
		dir = new File(parent, child);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
	
	public static File createDir(String path) {
		File dir = null;
		dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
	
	public static File delete(String path) {
		File f = null;
		f = new File(path);
		f.delete();
		return f;
	}
	
	public static void removeAll(File dir) {
		if(dir.isDirectory()) {
			File[] children = dir.listFiles();
			for(File f : children) {
				removeAll(f);
			}
			dir.delete();
		}else {
			dir.delete();
		}
	}
	
	public static void main(String[] args) throws IOException {
//		FileUtil.create("d:\\", "My.java");
//		File f = FileUtil.create("d:\\my.txt");
//		
//		File d = FileUtil.createDir("d:\\a\\b\\c");
//		File d2 = FileUtil.delete("d:\\a");
//		System.out.println(Arrays.toString(d2.list()));
//		System.out.println("�������ļ���"+f.isHidden());
//		System.out.println("�ļ���С"+f.length());
//		System.out.println(new Date(f.lastModified()));
//		System.out.println("��ִ�У�"+f.canExecute());
//		System.out.println("�ɶ�"+f.canRead());
//		System.out.println("��д"+f.canWrite());
//		f.setWritable(false);
//		System.out.println(f.getAbsolutePath());
//		System.out.println(f.getName());
//		System.out.println(f.getParent());
		
		File d = new File("d:\\abc");
		FileUtil.removeAll(d);
		
		
		
	}
}
