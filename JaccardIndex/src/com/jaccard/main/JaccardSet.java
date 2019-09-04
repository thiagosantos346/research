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

		public Dicionario(){}

		public Dicionario(char value, Integer ref){
			this.refs_word = new ArrayList<Integer>();
			this.charactere = value;

			this.refs_word.add(ref);
		
		}


		char  charactere;
		ArrayList<Integer> refs_word;

	}

	public int sizeOfDic(){
		return this.dic.size();
	}

	

	private void addIntoDic(int sizeofSet){

		for(int j = 0; j < this.set.get(sizeofSet).value.length(); j++ ){
			char cacaterere;
			cacaterere = this.getChar(sizeofSet, j);

			int existe = this.findIntoDic(cacaterere);
			
			if( existe == -1 ){
				System.out.println("Novo! ");
				this.dic.add( new Dicionario(cacaterere  , sizeofSet));
			
			}else{
				System.out.println("Já Existe");
				this.dic.get(existe).refs_word.add(sizeofSet);

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

	public int findIntoDic(char value){
		
		for(int i = 0; i < this.dic.size(); ++i){
			
			if( this.dic.get(i).charactere == value){
				return i;
			}
	
		}

		return -1;

	}
	
	public void add(String value){
		
		set.add(new SetItem(this.size, value));
		addIntoDic(size);
		this.size++;
	}

	public int getSizeOfWordsInSet(int i){
		return this.set.get(i).value.length();

	}

	public int getCountRef(int r1, int r2){
		int count = 0;
		for (int i = 0; i < this.dic.size();i++) {
			for (int j = 0; j < this.dic.get(i).refs_word.size() ; j ++ ){

				if( this.dic.get(i).refs_word.get(j) == refKey
				    && this.dic.get(i).refs_word.size() > 1){ count++; }
				
			}
		}

		return count;

	}

	public String get(int indexString){
		return this.set.get(indexString).value;
	}

	public int getSizeOfAllWordsInSet(){

		int sum = 0;

		for (int i = 0; i < this.size ; i++) {
			sum += this.set.get(i).value.length();
		}

		return sum;

	}

	public char getChar(int indexString, int indexCharactere){
		String word = this.set.get(indexString).value.toString();
		return word.charAt(indexCharactere);
	}

	public void toStringSetList(int index){

		System.out.println(this.set.get(index).value+" : "+this.set.get(index).refKey);

	}
	
	
}