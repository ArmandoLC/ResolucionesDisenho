
package Enums;

import java.util.ArrayList;


public enum Modalidad {
    
    Semestre, Trimestre, Cuatrimestre;
    
    public static ArrayList<String> getPeriodos(Modalidad m) {
        switch(m){
            case Semestre: return Semestre();
            case Trimestre: return Trimestre();
            case Cuatrimestre: return Cuatrimestre();
            default: return Semestre();
        }
    }
    
    private static ArrayList<String> Semestre(){
        ArrayList<String> periodos = new ArrayList<>();
        periodos.add("I"); periodos.add("II");
        return periodos;
    }
    
    private static ArrayList<String> Trimestre(){
        ArrayList<String> periodos = new ArrayList<>();
        periodos.add("I"); periodos.add("II");
        periodos.add("III");
        return periodos;
    }
    
    private static ArrayList <String> Cuatrimestre(){
        ArrayList<String> periodos = new ArrayList<>();
        periodos.add("I"); periodos.add("II");
        periodos.add("I"); periodos.add("IV");
        return periodos;
    }
   
    
}
