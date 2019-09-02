package com.jaccard.main;
import com.jaccard.DataTypes.Set;
import com.jaccard.functions.Jaccard;
public class Main {
	
	public static void main(String[] args) {
		
		Set set = new Set();
		set.setStringList("teste");
		float trash = Jaccard.fJaccardSimilatityValue(21, 32);
		System.out.print(trash);
		System.out.print(set.getCharacterInStringI(0, 1));
		
		
	}

}
