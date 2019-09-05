package com.jaccard.main;
import  com.jaccard.*;

public class Jaccard extends JaccardSet{
	
	public Jaccard(){
		super();
		this.setTrashHolder((float)0.0);
		this.setWindowSize(1);
	}
	
	private int   windowSize;
	private float maxTrashHolderValue;
	private float minTrashHolderValue;
	private float trashHolder;
	
	public int UnionSize(int setItemIndexA, int setItemIndexB){

		int sum = 0;

		for(int i = 0; i < this.set.get(setItemIndexA).value.length(); i++){
			if( ! (this.getChar(setItemIndexA, i) == this.getChar(setItemIndexB, i))){
				sum++;
			}
		}
		
		sum+= this.set.get(setItemIndexA).value.length();

		return sum;
	}

	public float jaccardValue(int setA, int setB){
		return (float)this.intersectionSize(setA, setB) / (float)this.UnionSize(setA, setB);
	}

	public int intersectionSize(int setItemIndexA, int setItemIndexB){
		int sum = 0;
		
		for(int i = 0; i < this.set.get(setItemIndexA).value.length(); i++){
			if( this.getChar(setItemIndexA, i) == this.getChar(setItemIndexB, i)){
				sum++;
			}
		}

		return sum;
	}
	
	public void setTrashHolder(float d) {
		if(d >= this.getMaxTrashHolderValue() 
		   && d <= this.getMinTrashHolderValue()) {
			this.trashHolder =  d;
		}
		
	}


	public float getMaxTrashHolderValue() {
		return maxTrashHolderValue;
	}


	public void setMaxTrashHolderValue(float maxTrashHolderValue) {
		this.maxTrashHolderValue = maxTrashHolderValue;
	}


	public float getMinTrashHolderValue() {
		return minTrashHolderValue;
	}


	public void setMinTrashHolderValue(float minTrashHolderValue) {
		this.minTrashHolderValue = minTrashHolderValue;
	}
	
	public int getWindowSize() {
		return windowSize;
	}


	public void setWindowSize(int windowSize) {
		this.windowSize = windowSize;
	}


	public float getTrashHolder() {
		return trashHolder;
	}

}
