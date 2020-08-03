package com.thzhima.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Home {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Human h = null;
		
		// ����һ�������ļ����͵Ķ���
		Properties p = new Properties();
		
		// ����·�����ļ���������
		InputStream in = Object.class.getResourceAsStream("/my.properties");
		p.load(in); // ����������
		// ��ȡ������Ϣ����ȡʵ�����������
		String className = p.getProperty("clean_man");
		
		// Java ���䷽����ͨ�����ͣ�����һ����ʾ�����Class���󡣣���ʡ�Ļ��ƣ�
	    Class clas = Class.forName(className);
	    h = (Human) clas.newInstance(); // ͨ��Class���󣬴��������ʵ����
		
	    
		h.clean();
	}
}
