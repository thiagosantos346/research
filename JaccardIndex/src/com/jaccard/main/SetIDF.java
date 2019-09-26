package com.jaccard.main;
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
            this.references = new HashSet<>();
        }
        TypeIDF(String key, int reference){
            this.references = new HashSet<>();
            this.key = key;
            references.add(reference);
        }
        String key;
        Set<Integer> references;
    }
    
    public void add(String value, int reference, Map tempMap){
        boolean exists = false;
        for (TypeIDF var : values) {
            
            //System.out.println(" Isso -> "+value+", está ->  "+var.key+" ? "+(var.key.equals(value)));
            if( var.key.equals(value) ){
                var.references.add(reference);
                exists = true;
             
                for ( Integer ref : var.references ) {
                   if (ref != reference) {
                        tempMap.add(ref, value );
                   }
                }
                
            }

        }
        
        if(exists == false){
            this.values.add(new TypeIDF(value, reference));
        }

        
    }

}