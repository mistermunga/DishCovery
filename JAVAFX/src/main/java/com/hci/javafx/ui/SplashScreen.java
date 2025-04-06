package com.hci.javafx.ui;

import com.hci.javafx.MainApplication;
import com.hci.javafx.session.AppSession;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.util.Objects;

public class SplashScreen extends VBox {
    private static final String LIGHT_STYLE = "/com/hci/javafx/styles.css";
    private static final String DARK_STYLE = "/com/hci/javafx/dark-styles.css";
    private Button toggleButton;

    public SplashScreen() {
        // Apply the initial stylesheet based on the current mode
        applyTheme(AppSession.getInstance().isBrightMode());

        this.setPrefWidth(400);
        this.setPrefHeight(500);
        this.setMaxHeight(600);

        showSplashScreen();
    }

    private void showSplashScreen() {
        this.setSpacing(30);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30, 30, 30, 30));
        this.getStyleClass().add("gradient-background");

        try {
            Image logoImage = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream("/com/hci/javafx/image/logos/DishCovery.png")));
            ImageView logoView = new ImageView(logoImage);
            logoView.setFitWidth(250);
            logoView.setPreserveRatio(true);
            this.getChildren().add(logoView);
        } catch (Exception e) {
            System.err.println("Could not load logo image: " + e.getMessage());
        }

        VBox spacer = new VBox();
        spacer.setPrefHeight(100);
        this.getChildren().add(spacer);

        Button startButton = new Button("Get Started");
        startButton.getStyleClass().add("major-button");
        startButton.setOnAction(event -> MainApplication.getInstance().showMainPage());
        this.getChildren().add(startButton);

        // Add theme toggle button with initial state based on current mode
        toggleButton = new Button();
        toggleButton.getStyleClass().add("toggle-button");
        updateToggleButtonText(AppSession.getInstance().isBrightMode());

        toggleButton.setOnAction(event -> {
            boolean newBrightMode = !AppSession.getInstance().isBrightMode();
            AppSession.getInstance().setBrightMode(newBrightMode);
            updateToggleButtonText(newBrightMode);
            applyTheme(newBrightMode);
        });

        this.getChildren().add(toggleButton);
    }

    private void updateToggleButtonText(boolean isBrightMode) {
        toggleButton.setText(isBrightMode ? "Dark Mode" : "Light Mode");
    }

    private void applyTheme(boolean isBrightMode) {
        String styleResource = isBrightMode ? LIGHT_STYLE : DARK_STYLE;
        this.getStylesheets().clear();
        this.getStylesheets().add(Objects.requireNonNull(
                getClass().getResource(styleResource)).toExternalForm());
    }
}