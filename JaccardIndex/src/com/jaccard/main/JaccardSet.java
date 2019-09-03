package com.jaccard.main;
//import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;


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
		ArrayList<Integer> refs_word;

	}

	public int sizeOfDic(){
		return this.dic.size()+1;
	}

	public int findIntoDic(char value){
		
		for(int i = 0; i < this.dic.size(); ++i){
			
			if( this.dic.get(i).charactere == value){
				return i;
			}
	
		}

		return -1;

	}

	private void addIntoDic(){

		for(int i = 0; i < this.set.size() ; i++){
			
			for(int j = 0; j < this.set.get(i).value.length(); j++ ){
				char cacaterere;
				cacaterere = this.getChar(i, j);

				int existe = this.findIntoDic(cacaterere);
				
				if( existe == -1 ){
					System.out.println("Já Existe");
					this.dic.add( new Dicionario(cacaterere  , i ));
				
				}else{
					System.out.println("Já Existe");
					this.dic.get(existe).refs_word.add(i);

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
		return this.set.get(indexString).value;
	}

	public char getChar(int indexString, int indexCharactere){
		String word = this.set.get(indexString).value.toString();
		return word.charAt(indexCharactere);
	}

	public void toStringSetList(int index){

		System.out.println(this.set.get(index).value+" : "+this.set.get(index).refKey);

	}
	
	
}