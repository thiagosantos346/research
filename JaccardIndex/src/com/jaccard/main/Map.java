package com.jaccard.main;
import java.util.ArrayList;
import java.util.HashSet;
class TypeMap{
    String value;
    int reference;
    int count;
    TypeMap(){
        this.count = 1;
    }    
    TypeMap(int reference, String value){
        this.count = 1;
        this.reference = reference;
        this.value = value;
    }
}

class Map{
    private ArrayList<TypeMap> map;
    public static HashSet<String> set = new HashSet<>();

    public ArrayList<TypeMap> getMap(){
        return this.map;
    }

    Map(){
        map = new ArrayList<TypeMap>();
    }
    public void add(int reference, String value){
        boolean exists = map.add(new TypeMap(reference, value));
        if( exists =  false ){
            Integer i = 0;
            do{
                ++i;
                value   = value.concat(  i.toString() );
                exists  = map.add(new TypeMap(reference, value));
            }while( exists );
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

    public int getReference(int index){
        return this.map.get(index).reference;
    }
    
    public int size(int index){
        return this.map.size();
    }
}