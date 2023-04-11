package org.openjfx.Maven;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
        System.out.println("hello");
        //hello
    }
}