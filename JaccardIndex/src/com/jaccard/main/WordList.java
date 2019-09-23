package com.jaccard.main;
import java.util.ArrayList;

import com.jaccard.main.Map.TypeMap;
class WordList {
    private ArrayList<String> words;
    private Map map = new Map();
    private SetIDF idf;
    WordList(){
        words = new ArrayList<String>();
        idf = new SetIDF();
    }
    public void add(String value){
        String[] valueSplited = value.split("");
        words.add(value);
        for (String var : valueSplited) {
            if( ! var.equals("\0")){
                idf.add( var.charAt(0), words.size()-1, map );
            }
        }
        ArrayList<TypeMap> tmap = map.getMap();
        for (TypeMap var : tmap ) {
            System.out.println( words.get( var.reference));
           System.out.println( makeSimlarityCalc(value.length() , this.words.get( var.reference).length() , var.count));
            
        }

        map = new Map();

    }

    public double makeSimlarityCalc(int sizeOfFirstWord, int sizeOfSecondWord, int sizeOfIntersection){
        return (double)(sizeOfIntersection)/( (sizeOfFirstWord+sizeOfIntersection) - sizeOfIntersection );
    }
}