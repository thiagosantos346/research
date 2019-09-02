package com.jaccard.main;
//import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;

import sun.security.util.Length;


public class JaccardSet {
	
	private int size;
	private ArrayList<SetItem> set;
	private ArrayList<Dicionario> dic;
	
	public JaccardSet(){
		this.size = 0;
		this.set = new ArrayList<SetItem>();
		this.dic = new ArrayList<Dicionario>();
	}
	
	private class SetItem{
		
		public SetItem() {}
		
		public SetItem(int id, String value){
			this.refKey = id;
			this.value = value;
		}
		
		String value;
		int refKey;
	}

	private class Dicionario{

		public Dicionario(){
			this.refs_word = new ArrayList<Integer>();
		}

		public Dicionario(char value, Integer ref){
			this.refs_word = new ArrayList<Integer>();
			this.charactere = value;
		
		}


		char  charactere;
		ArraList<Integer> refs_word;

	}

	public int findIntoDic(char value){
		
		for(i = 0; i < this.dic.size(); i++){
			
			if( this.dic.get(i).character == value){
				return i;
			}

			return -1;
		
		}

	}

	private void addIntoDic(){
		
		for(i = 0; i < this.set.size(); i++){
		
			for(j = 0; i < Length( this.get(i) ) ; i++){
				
				char cacaterere = this.get(i, j);
				int existe = this.findIntoDic(cacaterere);
				if( existe == -1 ){
					this.dic.add( new Dicionario(value, i ));
				}else{

					this.dic.get(existe).refs_word.add(cacaterere);

				}


			}
		
		}

	}

	private int findInSet(String value)
	{
		for(int i = 0; i < set.size(); ++i) {
			String valueToCompare = this.set.get(i).value;
			if(value == valueToCompare) {
				return i;
			}
			
		}
		
		return -1;
	}	

	public void add(String value){
		
		set.add(new SetItem(this.size, value));
		this.size++;
		addIntoDic();
		
	}

	public String get(int indexString){
		return this.set.get(indexString);
	}

	public char get(int indexString, int indexCharactere){
		String word = this.set.get(index);
		return word.charAt(indexCharactere);
	}

	public void toStringSetList(int index){

		System.out.println(this.set.get(index).value+" - -- - "+this.set.get(index).refKey);

	}
	
	
}
