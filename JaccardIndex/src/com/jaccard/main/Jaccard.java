package com.jaccard.main;
import  com.jaccard.*;

public class Jaccard extends JaccardSet{
	
	public Jaccard(){
		super();
		this.setTrashHolder((double)0.0);
		this.setWindowSize(1);
	}
	
	private int   windowSize;
	private double maxTrashHolderValue;
	private double minTrashHolderValue;
	private double trashHolder;
	
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

	public double jaccardValue(int setA, int setB){
		double value ;
		int sizeSetA = this.set.get(setA).value.length();
		int sizeSetB = this.set.get(setB).value.length();
		double intersectionSize =  (double)this.intersectionSize(setA, setB);

		int sumOfSets = sizeSetA + sizeSetB;
		
		value = intersectionSize / ((double)sumOfSets - intersectionSize) ;
		
		return value;
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

	public void setTrashHolder(double d) {
		if(d >= this.getMaxTrashHolderValue() 
		   && d <= this.getMinTrashHolderValue()) {
			this.trashHolder =  d;
		}
		
	}



	public double getMaxTrashHolderValue() {
		return maxTrashHolderValue;
	}


	public void setMaxTrashHolderValue(double maxTrashHolderValue) {
		this.maxTrashHolderValue = maxTrashHolderValue;
	}


	public double getMinTrashHolderValue() {
		return minTrashHolderValue;
	}


	public void setMinTrashHolderValue(double minTrashHolderValue) {
		this.minTrashHolderValue = minTrashHolderValue;
	}
	
	public int getWindowSize() {
		return windowSize;
	}


	public void setWindowSize(int windowSize) {
		this.windowSize = windowSize;
	}


	public double getTrashHolder() {
		return trashHolder;
	}

}
