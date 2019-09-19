package com.jaccard.main;
import java.util.ArrayList;

class Map{
    private ArrayList<TypeMap> map;

    public ArrayList<TypeMap> getMap(){
        return this.map;
    }

    public class TypeMap{
        int reference;
        int count;
        TypeMap(){
            this.count = 1;
        }    
        TypeMap(int reference){
            this.count = 1;
            this.reference = reference;
        }
    }
    Map(){
        map = new ArrayList<TypeMap>();
    }
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

    public int getReference(int index){
        return this.map.get(index).reference;
    }
    
    public int size(int index){
        return this.map.size();
    }
}