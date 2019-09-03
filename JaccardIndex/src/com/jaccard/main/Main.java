package com.jaccard.main;


public class Main {
	
	public static void main(String[] args) {
		
		JaccardSet myset;
		myset = new JaccardSet();

		myset.add("value");
		myset.add("value");
		myset.add("thiago");
		myset.add("ds");
		System.out.println(myset.sizeOfDic());
		System.out.println(myset.getChar(0, 0));
		myset.toStringSetList(0);
		
	}

}
