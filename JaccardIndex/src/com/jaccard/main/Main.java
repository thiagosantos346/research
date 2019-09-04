package com.jaccard.main;


public class Main {
	
	public static void main(String[] args) {
		
		JaccardSet myset;
		myset = new JaccardSet();

		myset.add("abcd");
		myset.add("abef");
		myset.add("abfg");
		myset.add("cdfg");
		System.out.println(myset.sizeOfDic());
		System.out.println(  myset.getCountRef(2));
		System.out.println(  myset.getCountRef(1));
		myset.toStringSetList(0);
		
	}

}
