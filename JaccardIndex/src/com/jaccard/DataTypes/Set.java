package com.jaccard.DataTypes;
//import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;


public class Set {
	
	private int size;
	private ArrayList<SetItem> set;
	
	public Set(){
		this.size = 0;
		this.set = new ArrayList<SetItem>();
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
		
	}
	
}
