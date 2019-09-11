package com.jaccard.main;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

	private static Jaccard myset = new Jaccard();;
	
	public static void showAllSimilarity(float limite){
		Float  res;
		
		for(int i = 0; i < myset.set.size()-1; i++ ){
			for(int j = 0; j < myset.set.size()-1; j++ ){
				if(j != i){
					res = myset.jaccardValue(i,j);
					if( res > limite){
						System.out.println( "Similaridade : "+res );
						System.out.println( "["+i+"]"+myset.set.get(i).value+" : ["+j+"]"+myset.set.get(j).value+"\n" );
					}
					
				}
				
				
			}	
		}
		
		

	}

	public static String cleanUpString(String strToClener){
		String str = strToClener.replaceAll("\\W", "");
		str = str.replaceAll("[0-9]", "");
		return str;
	}
	
	public static void fileReader(String fileName) throws IOException {
		InputStream inStream = new FileInputStream(fileName);
		InputStreamReader reStream = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reStream);
		String str;
		
		do{
		
			str = buffer.readLine();
			
			if(str !=  null){
				
				String[] strSplited = str.split("\\s");

				for(int i = 0; i < strSplited.length - 1; ++i ){
					strSplited[i] = cleanUpString(strSplited[i]);
					myset.add(strSplited[i]);
				}
					
			
			}
			
		
		}while(str != null);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		fileReader("/home/silvathiago/git/research/JaccardIndex/src/com/jaccard/main/wordlist.txt");
		showAllSimilarity((float)0.4);

	}

}
