package org.example;

public enum Palo {
    Trebol ("clover"),
    Pica ("pike"),
    Corazon ("heart"),
    Diamante ("diamond");


    private String english;

    private Palo(String e){
        english = e;
    }

    public String getEnglish(){
        return english;
    }

    
}
