package com.thzhima.usualy;

import java.io.PrintStream;

public class StdOut {

	public static void main(String[] args) {
		PrintStream out = System.out;
		out.append("hello");
		out.print("java");
		out.println("\n---------------");
		out.format("I Like %s and %s.", "phtyoe", "java");
	}
}
