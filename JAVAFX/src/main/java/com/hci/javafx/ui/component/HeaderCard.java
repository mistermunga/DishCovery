package com.hci.javafx.ui.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class HeaderCard extends HBox {

    public HeaderCard() {
        initialise();
    }

    private void initialise() {
        try {
            Image logoImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/hci/javafx/image/logos/DishCovery.png")));
            ImageView logoView = new ImageView(logoImage);

            logoView.setPreserveRatio(true);
            this.getChildren().add(logoView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TO-DO: add buttons
    }
}
