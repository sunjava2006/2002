package com.thzhima.advance.collframework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.thzhima.advance.base.People;

public class SortedSetDemo {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		
		set.add(50);
		set.add(40);
		set.add(60);
		set.add(30);
		set.add(80);
		
		System.out.println(set.toString());
		
		for(Integer i : set) {
			System.out.print(i + ",");
		}
		
		System.out.println();
		Iterator<Integer> itor = set.iterator();
		
		while(itor.hasNext()) {
			Integer i = itor.next();
			System.out.print(i +",");
		}
		System.out.println();
		
		//====================  ========================
		Comparator comparator = new ComparPeopleName(); // ����һ��ǿ�ƱȽ���
		TreeSet<People> pset = new TreeSet<>();
		
//		TreeSet<People> pset = new TreeSet<>((People a, People b)->a.getGender().compareTo(b.getGender()));
		
			People p = new People("Marry", 2, "female");
			pset.add(p); // �ڲ�������Ƿ���Comparable����
			People p2 = new People("Marry", 2, "female");
			pset.add(p2); // �ڲ�������Ƿ���Comparable����
			People p3 = new People("Marry", 23, "female");
			pset.add(p3); // �ڲ�������Ƿ���Comparable����
			People p4 = new People("Tim", 2, "male");
			pset.add(p4); // �ڲ�������Ƿ���Comparable����
			People p5 = new People("Smith", 6, "male");
			pset.add(p5); // �ڲ�������Ƿ���Comparable����
			People p6 = new People("Peter", 9, "female");
			pset.add(p6); // �ڲ�������Ƿ���Comparable����
		
		System.out.println(pset);
		System.out.println(pset.size());
	}

}
