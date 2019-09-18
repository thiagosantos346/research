package com.jaccard.main;

import java.util.ArrayList;


class WordList {
    
    private ArrayList<String> words;
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
                idf.add( var.charAt(0), words.size()-1 );
            }
        }
    }

	
}