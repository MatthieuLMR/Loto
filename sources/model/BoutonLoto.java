package model;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

/**
 * Créé par matthieu.lemaire le 11/09/17.
 */
public class BoutonLoto extends Button {

    Boolean isClic = false;

    public BoutonLoto(){
        this.setPrefSize(75,75);
        this.setTextAlignment(TextAlignment.CENTER);
    }

    public void setClic(boolean pClic){
        this.isClic = pClic;
    }

    public boolean getClic(){
        return this.isClic;
    }

}
