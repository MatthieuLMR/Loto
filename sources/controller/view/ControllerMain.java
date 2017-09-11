package controller.view;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.BoutonFullScreen;
import model.BoutonLoto;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Créé par matthieu.lemaire le 11/09/17.
 */
public class ControllerMain implements Initializable {

    @FXML
    BorderPane borderPaneMain;
    @FXML
    GridPane gridPaneMain;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ImageView imageViewLogo = new ImageView();
        Image imgLogo = new Image("logotwirl.jpg");
        imageViewLogo.setImage(imgLogo);
        imageViewLogo.setFitHeight(200);

        BorderPane.setAlignment(imageViewLogo, Pos.CENTER);
        borderPaneMain.setTop(imageViewLogo);

        Button btnReset = new Button("Reset");
        Button btnAPropos = new Button("A Propos");
        Button btnQuit = new Button("Quitter");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnReset, btnAPropos, btnQuit);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(5);
        borderPaneMain.setLeft(vBox);

        for (int i = 0; i < 90 ; i++){
            final BoutonLoto button = new BoutonLoto();
            button.setText(String.valueOf(i+1));
            int y = i / 10;
            int x = i - y*10;
            gridPaneMain.add(button, x, y);

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    if(!button.getClic()) {
                        final BoutonFullScreen buttonFullScreen = new BoutonFullScreen();
                        buttonFullScreen.setText(button.getText());

                        buttonFullScreen.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                borderPaneMain.setCenter(gridPaneMain);
                            }
                        });

                        borderPaneMain.setCenter(buttonFullScreen);
                        button.getStyleClass().add("buttonOk");
                        button.setClic(true);
                    }else{
                        button.getStyleClass().remove("buttonOk");
                        button.setClic(false);
                    }
                }
            });

        }

        btnReset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ObservableList<Node> LstBouton = gridPaneMain.getChildren();
                for(Node Bouton : LstBouton){
                    Bouton.getStyleClass().remove("buttonOk");
                }
            }
        });

        btnQuit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
                stage.close();
            }
        });

        btnAPropos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BoutonFullScreen btnFullApropos = new BoutonFullScreen();
                btnFullApropos.getStyleClass().remove("buttonFullScreen");
                btnFullApropos.getStyleClass().add("buttonFullAPropos");
                btnFullApropos.setText("One line to give the program's name and a brief idea of what it does.\n" +
                        "    Copyright (C) 2017  Matthieu LEMAIRE" +
                        "    matthieu.lmr@gmail.com\n" +
                        "\n" +
                        "    This program is free software: you can redistribute it and/or modify\n" +
                        "    it under the terms of the GNU General Public License as published by\n" +
                        "    the Free Software Foundation, either version 3 of the License, or\n" +
                        "    (at your option) any later version.\n" +
                        "\n" +
                        "    This program is distributed in the hope that it will be useful,\n" +
                        "    but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                        "    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
                        "    GNU General Public License for more details.\n" +
                        "\n" +
                        "    You should have received a copy of the GNU General Public License\n" +
                        "    along with this program.  If not, see <http://www.gnu.org/licenses/>.\n");

                borderPaneMain.setCenter(btnFullApropos);

                btnFullApropos.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        borderPaneMain.setCenter(gridPaneMain);
                    }
                });
            }
        });

        Text txtSignature = new Text();
        txtSignature.setText("Logiciel créer par Matthieu LEMAIRE");
        BorderPane.setAlignment(txtSignature, Pos.CENTER);
        borderPaneMain.setBottom(txtSignature);

    }
}