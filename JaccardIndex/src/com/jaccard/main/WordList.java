package com.jaccard.main;
import java.util.ArrayList;

import com.jaccard.main.Map.TypeMap;
class WordList {
    private ArrayList<String> words;
    private Map map = new Map();
    private SetIDF idf;
    private Double treshhold;

    WordList(double treshhold){
        words = new ArrayList<String>();
        idf = new SetIDF();
        this.treshhold = treshhold;
    }
    public void add(String value){
        //Quebrando value em um array de char's;
        String[] valueSplited = value.split("");

        //Adicionado a plavara completa na lista de referências;
        words.add(value);
        //O Tamanho do array Words - 1 equivale a referência da palavra;
        int reference = words.size()-1;
        //Percorrendo todo o array de Char's criados anteriormente;
        for (String var : valueSplited) {
            //é validado se não é o fim de uma string;
            if( ! var.equals("\0")){
                //adicionando ao indice de frequência invertido;
                //o caracter;
                //a referências do caractere;
                //Um Tipo Map, que serve para armazernar o valor da intersecção entre outras palavaras;
                idf.add(  var.charAt(0) , reference , map );
            }
        }

        ArrayList<TypeMap> tmap = map.getMap();

        for (TypeMap varMap : tmap ) {
            Double similarity = makeSimlarityCalc(value.length() , this.words.get( varMap.reference).length() , varMap.count);
            if( similarity >= this.treshhold ){
                System.out.print("First:"+words.get( varMap.reference)+" - Second: ");
                System.out.print(value);
                System.out.print(" - Value: ");
                System.out.println( similarity+";" ); 
            }
        }

        map = new Map();

    }
    //typesetting
    // industry.
    public double makeSimlarityCalc(int sizeOfFirstWord, int sizeOfSecondWord, int sizeOfIntersection){
        return (double)(sizeOfIntersection)/( (sizeOfFirstWord+sizeOfIntersection) - sizeOfIntersection );
    }
}