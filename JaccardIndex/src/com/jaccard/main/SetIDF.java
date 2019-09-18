package com.jaccard.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class SetIDF {


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

    private Set<TypeIDF> values;

    public void add(char value, int reference){
        Map tempMap = new Map();
        boolean exists = false;

        for (TypeIDF var : values) {
            
            if(var.key == value){
                var.references.add(reference);
                exists = true;
                tempMap.add(reference);
            }

        }

        if(exists == false){
            this.values.add(new TypeIDF(value, reference));
        }

    }

}