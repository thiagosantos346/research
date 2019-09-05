package com.jaccard.main;


public class Main {
	
	public static void main(String[] args) {
		
		Jaccard myset;
		myset = new Jaccard();
		Float  res;
		myset.add("thiago");
		myset.add("theago");
		myset.add("abfg");
		myset.add("cdfg");
		res = myset.jaccardValue(2,3);
		System.out.println( " Similaridade : "+res );

	}

}
