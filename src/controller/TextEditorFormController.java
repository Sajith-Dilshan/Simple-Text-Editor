package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TextEditorFormController {
    public TextField txtFind;
    public TextField txtReplace;

    public void mnuitemNew_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemOpen_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemSave_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemPrint_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemExit_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemCut_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemCopy_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemPaste_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemselectAll_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemFind_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemReplace_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemReplaceAll_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemAbout_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About page");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();
    }

    public void btnNew_OnAction(ActionEvent actionEvent) {
    }

    public void btnOpen_OnAction(ActionEvent actionEvent) {
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
    }

    public void btnsave_OnAction(ActionEvent actionEvent) {
    }

    public void btnCopy_OnAction(ActionEvent actionEvent) {
    }

    public void btnPaste_OnAction(ActionEvent actionEvent) {
    }

    public void btnRegExp_OnAction(ActionEvent actionEvent) {
    }

    public void btnCaseSensitive_OnAction(ActionEvent actionEvent) {
    }

    public void btnUp_OnAction(ActionEvent actionEvent) {
    }

    public void btnDown_OnAction(ActionEvent actionEvent) {
    }

    public void btnReplace_OnAction(ActionEvent actionEvent) {
    }

    public void btnReplaceAll_OnAction(ActionEvent actionEvent) {
    }
}
