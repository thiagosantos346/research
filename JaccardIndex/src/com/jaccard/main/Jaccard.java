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
