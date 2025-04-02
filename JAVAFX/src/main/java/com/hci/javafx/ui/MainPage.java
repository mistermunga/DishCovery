package com.hci.javafx.ui;

import com.hci.javafx.ui.component.HeaderCard;
import com.hci.javafx.ui.component.IngredientSearchTab;
import com.hci.javafx.ui.component.SearchBar;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class MainPage extends VBox {

    public MainPage() {
        this.getStylesheets()
                .add(Objects.requireNonNull(getClass()
                        .getResource("/com/hci/javafx/styles.css")).toExternalForm());
        this.getStyleClass().add("light-mode-gradient-background");

        showHeader();
        showSearchTab();

        Button filterButton = new Button("Find Recipes!");
        filterButton.getStyleClass().add("light-mode-major-button");
        filterButton.setOnAction(event -> performFilter());
        this.getChildren().add(filterButton);
    }

    private void showHeader() {
        HeaderCard headerCard = new HeaderCard();
        this.getChildren().add(headerCard);
    }

    private void showSearchTab() {
        SearchBar searchBar = new SearchBar();
        this.getChildren().add(searchBar);

        IngredientSearchTab ist = new IngredientSearchTab();
        this.getChildren().add(ist);
    }

    private void performFilter() {}
}
