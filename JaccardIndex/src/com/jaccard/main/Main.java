package com.jaccard.main;

import java.io.IOException;
import java.io.*;

public class Main {
	
	public static WordList myset = new WordList();
	
	public static void fileReader(String fileName) throws IOException {
		InputStream inStream = new FileInputStream(fileName);
		InputStreamReader reStream = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reStream);
		String str;

		do{
			str = buffer.readLine();
			if(str !=  null){
				String[] strSplited = str.split(" ");
				for(int i = 0; i < strSplited.length - 1; ++i ){
					myset.add(strSplited[i]);
				}
			}
			
		}while(str != null);
		buffer.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		fileReader("/home/thiago/workspace/research/research/JaccardIndex/src/com/jaccard/main/wordlist.txt");

	}

}
