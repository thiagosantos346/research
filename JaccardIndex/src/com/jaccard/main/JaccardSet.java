package com.jaccard.main;
//import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Set;

public class JaccardSet {
	
	private int size;
	protected ArrayList<SetItem> set;
	protected ArrayList<ListaInvertida> dic;
	
	public JaccardSet(){
		this.size = 0;
		this.set = new ArrayList<SetItem>();
		this.dic = new ArrayList<ListaInvertida>();
	}
	
	protected class SetItem{
		
		public SetItem() {}
		
		public SetItem(int id, String value){
			this.refKey = id;
			this.value = value;
		}
		
		String value;
		int refKey;
	}

	protected class ListaInvertida{

		public ListaInvertida(){}

		public ListaInvertida(char value, Integer ref){
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
				//System.out.println("Novo! ");
				this.dic.add( new ListaInvertida(cacaterere  , sizeofSet));
			
			}else{
				//System.out.println("Já Existe");
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

	public int getCountRef(int refKey){
		int count = 0;
		for (int i = 0; i < this.dic.size();i++) {
			for (int j = 0; j < this.dic.get(i).refs_word.size() ; j ++ ){

				if( this.dic.get(i).refs_word.get(j) == refKey
				    && this.dic.get(i).refs_word.size() > 1){ count++; }
				
			}
		}

		return count;

	}

	public String get(int index){
		return this.set.get(index).value;
	}

	public int getSizeOfAllWordsInSet(){

		int sum = 0;

		for (int i = 0; i < this.size ; i++) {
			sum += this.set.get(i).value.length();
		}

		return sum;

	}

	public char getChar(int indexString, int indexCharactere){

		if(  indexString < this.set.size()){
			String word = this.set.get(indexString).value.toString();
		
			if( indexCharactere < word.length()  ){
				char charactere = word.charAt(indexCharactere);
				return charactere;
			}
			
			return '\0';
		}
			
		return '\0';
	}

	public void toStringSetList(int index){

		System.out.println(this.set.get(index).value+" : "+this.set.get(index).refKey);

	}
	
	
}