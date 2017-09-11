package model;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

/**
 * Créé par matthieu.lemaire le 11/09/17.
 */
public class BoutonFullScreen extends Button {

    public BoutonFullScreen(){
        this.setPrefSize(750,750);
        this.setTextAlignment(TextAlignment.CENTER);
        this.getStyleClass().add("buttonFullScreen");
    }
}
