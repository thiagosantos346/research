package com.jaccard.main;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	private static Jaccard myset = new Jaccard();;
	
	public static void showAllSimilarity(){
		Float  res;
		
		
		
		for(int i = 0; i < myset.set.size(); i++ ){
			for(int j = i; j < myset.set.size() - 1; j++ ){
				res = myset.jaccardValue(i,j);
				System.out.println( "Similaridade : "+res );
				System.out.println( myset.set.get(i).value+" : "+myset.set.get(j).value+"\n" );
				
			}	
		}
		
		

	}
	
	public static void fileReader(String fileName) throws IOException {
		InputStream inStream = new FileInputStream(fileName);
		InputStreamReader reStream = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reStream);
		String str;	
		do{
		
			str = buffer.readLine();
			if(str !=  null)
			myset.add(str);
		
		}while(str != null);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		fileReader("/home/silvathiago/git/research/JaccardIndex/src/com/jaccard/main/wordlist.txt");
		showAllSimilarity();

	}

}
