package com.hci.javafx.ui.component;

import com.hci.javafx.theme.ThemeManager;
import javafx.scene.control.TextField;

import java.util.Objects;

public class SearchBar extends TextField {

    public SearchBar() {
        ThemeManager.getInstance().registerComponent(this);
        this.getStyleClass().add("search-bar");
        this.setPromptText("Search");
    }
}
