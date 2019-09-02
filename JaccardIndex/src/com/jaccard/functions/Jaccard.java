package com.jaccard.functions;
import com.jaccard.DataTypes.Set;

public class Jaccard extends Set{
	
	public Jaccard(){
		super();
		this.setTrashHolder((float)0.0);
		this.setWindowSize(1);
	}
	
	private int   windowSize;
	private float maxTrashHolderValue;
	private float minTrashHolderValue;
	private float trashHolder;
	
	
	
	public float fJaccardSimilatityValue(char firstCharacter, char secondCharacter) {
		float similarityValue = 0;
		int sizeOfStringA = this.getCountRefsOnValue(firstCharacter);
		int sizeOfStringB = this.getCountRefsOnValue(secondCharacter);
		
		if( sizeOfStringA *  sizeOfStringB > 0 ) {
			similarityValue = (float)sizeOfStringA/(float)sizeOfStringB;
		}
		return similarityValue;
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
