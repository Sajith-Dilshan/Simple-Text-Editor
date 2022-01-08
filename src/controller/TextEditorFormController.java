package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;

public class TextEditorFormController {
    public TextField txtFind;
    public TextField txtReplace;
    public TextArea txtArea;

    public void mnuitemNew_OnAction(ActionEvent actionEvent) {
        txtArea.clear();
        txtReplace.clear();
        txtFind.clear();
        txtArea.requestFocus();


    }

    public void mnuitemOpen_OnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a text file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt"), new FileChooser.ExtensionFilter("HTMl Files", "*.html"));
        File file = fileChooser.showOpenDialog(txtArea.getScene().getWindow());
        if (file == null) {return;}

        txtArea.clear();


            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;

                while ((line = bufferedReader.readLine()) != null){
                    txtArea.appendText(line + '\n');
                }


            } catch (IOException e) {
                e.printStackTrace();
            }



    }


    public void mnuitemSave_OnAction(ActionEvent actionEvent) {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt")
                    , new FileChooser.ExtensionFilter("All Files", "*.*"));
            File file = fileChooser.showSaveDialog(null);
            if (file == null) return;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            bw.write(txtArea.getText());
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, ex.toString(), ButtonType.OK).show();
        }

    }






    public void mnuitemPrint_OnAction(ActionEvent actionEvent) {
    }

    public void mnuitemExit_OnAction(ActionEvent actionEvent) {

        if (txtArea.getText().isEmpty()) {
            System.exit(0);
        } else {
            new Alert(Alert.AlertType.ERROR, "did not Save project").show();
        }
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
        txtArea.clear();
        txtReplace.clear();
        txtFind.clear();
        txtArea.requestFocus();
    }

    public void btnOpen_OnAction(ActionEvent actionEvent) {
        mnuitemOpen_OnAction(new ActionEvent());
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        mnuitemSave_OnAction(new ActionEvent());
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
