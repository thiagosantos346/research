package com.jaccard.main;

import java.io.IOException;
import java.io.*;

public class Main {
	
	public static WordList myset = new WordList(0.1);
	
	public static void fileReader(String fileName) throws IOException {
		InputStream inStream = new FileInputStream(fileName);
		InputStreamReader reStream = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reStream);
		String str;

		do{
			str = buffer.readLine();

			if(str !=  null){
				String[] strSplited = str.split(" ");
				for(int i = 0; i < strSplited.length; ++i ){
					myset.add(strSplited[i]);
				}
			}
			
		}while(str != null);
		buffer.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		fileReader("src/com/jaccard/main/wordlist.txt");

	}

}
