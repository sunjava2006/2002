package com.thzhima.advance.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TempFileDemo {

	public static void main(String[] args) throws IOException {
		File tmp = File.createTempFile("_ass", ".tmp", new File("d:\\"));
		
		System.out.println();
		
		File f = new File("d:/abc");
		String[] child = f.list();
		System.out.println(Arrays.toString(child));
		
		tmp.deleteOnExit();

	}
}
