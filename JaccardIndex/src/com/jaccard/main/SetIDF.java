package com.jaccard.main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class SetIDF {
    private Set<TypeIDF> values;
    // private Map tempMap = new Map();

    public SetIDF(){
        this.values = new HashSet<TypeIDF>();
    }
    public class TypeIDF  {
        TypeIDF(){
            this.references = new ArrayList<>();
        }
        TypeIDF(char key, int reference){
            this.references = new ArrayList<>();
            this.key = key;
            references.add(reference);
        }
        char key;
        ArrayList<Integer> references;
    }
    public void add(char value, int reference, Map tempMap){
        boolean exists = false;
        for (TypeIDF var : values) {
            if(var.key == value){
                var.references.add(reference);
                exists = true;
                for ( Integer ref : var.references ) {
                   if (ref != reference) {
                        tempMap.add(ref);
                   }
                }
                
            }
        }
        
        if(exists == false){
            this.values.add(new TypeIDF(value, reference));
        }

        
    }

}