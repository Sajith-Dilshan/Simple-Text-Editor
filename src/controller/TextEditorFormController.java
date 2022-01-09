package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditorFormController {
    public TextField txtFind;
    public TextField txtReplace;
    public TextArea txtArea;
    public ToggleButton btnRegExp;
    public ToggleButton btnCaseSensitive;
    public Button btndown;
    public Button btnUp;


    private Matcher matcher;
    private boolean textChanged;


    public void initialize() {
        setDisableFindGroup(false);
        txtFind.textProperty().addListener((observable, oldValue, newValue) -> textChanged = true);
    }

    private void setDisableFindGroup(boolean value){
        txtFind.setVisible(value);
        btnRegExp.setVisible(value);
        btnCaseSensitive.setVisible(value);
        btnUp.setVisible(value);
        btndown.setVisible(value);
    }



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
        txtArea.selectAll();
    }

    public void mnuitemFind_OnAction(ActionEvent actionEvent) {

        setDisableFindGroup(true);
        txtFind.requestFocus();
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
        textChanged = true;
        btnUp.fire();
    }

    public void btnCaseSensitive_OnAction(ActionEvent actionEvent) {
        textChanged = true;
        btndown.fire();
    }

    public void btnUp_OnAction(ActionEvent actionEvent) {
        txtArea.deselect();
        if (textChanged) {
            int flags = 0;
            if (!btnRegExp.isSelected()) flags = flags | Pattern.LITERAL;
            if (!btnCaseSensitive.isSelected()) flags = flags | Pattern.CASE_INSENSITIVE;

            matcher = Pattern.compile(txtFind.getText(), flags)
                    .matcher(txtArea.getText());
            textChanged = false;
        }

        if (matcher.find()) {
            txtArea.selectRange(matcher.start(), matcher.end());
        } else {
            matcher.reset();
        }

    }

    public void btnDown_OnAction(ActionEvent actionEvent) {
        txtArea.deselect();
        if (textChanged) {
            int flags = 0;
            if (!btnRegExp.isSelected()) flags = flags | Pattern.LITERAL;
            if (!btnCaseSensitive.isSelected()) flags = flags | Pattern.CASE_INSENSITIVE;

            matcher = Pattern.compile(txtFind.getText(), flags)
                    .matcher(txtArea.getText());
            textChanged = false;
        }

        if (matcher.find()) {
            txtArea.selectRange(matcher.start(), matcher.end());
        } else {
            matcher.reset();
        }


    }

    public void btnReplace_OnAction(ActionEvent actionEvent) {
    }

    public void btnReplaceAll_OnAction(ActionEvent actionEvent) {
    }
}
