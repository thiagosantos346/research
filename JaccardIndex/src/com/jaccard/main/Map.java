package com.jaccard.main;
import java.util.ArrayList;

class Map{

    class TypeMap{
        int reference;
        int count;
        TypeMap(){
            count = 1;
        }    
        TypeMap(int reference){
            count = 1;
        }
        
    }

    Map(){
        map = new ArrayList<>();
    }

    private ArrayList<TypeMap> map;

    public void add(int reference){
        Boolean exist = false;

        for (TypeMap var : this.map) {
            if( var.reference == reference ){
                exist = true;
                var.count ++;
            }
        }

        if(exist == false){
            map.add(new TypeMap(reference));
        }
    }

    public int getCountOfReference(int value){
        
        for (TypeMap var : this.map) {
            if(value == var.reference){
                return var.count;
            }
        }

        return -1;
    }

}