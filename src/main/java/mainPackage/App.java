package mainPackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class App extends Application {

    public void start(Stage primaryStage) throws Exception {

        final FileChooser fileChooserLoad = new FileChooser();
        fileChooserLoad.setTitle("Open file");
        fileChooserLoad.setInitialDirectory(new File(System.getProperty("user.dir")));

        final FileChooser fileChooserSave = new FileChooser();
        fileChooserSave.setTitle("Save file");
        fileChooserSave.setInitialDirectory(new File(System.getProperty("user.dir")));

        Calculations add = new Calculations();

        VBox root = new VBox(5);

        /*First line*/
        Label input = new Label("Enter the numbers x and y:");

        HBox firstLine = new HBox(5);
        firstLine.setPadding(new Insets(0, 0, 0, 10));
        firstLine.getChildren().addAll(input);
        /*-------------*/

        /*Second line*/
        Label labelX = new Label("x = ");
        Label labelY = new Label("y = ");

        TextField textFieldX = new TextField();
        TextField textFieldY = new TextField();
        textFieldX.setPrefColumnCount(10);
        textFieldY.setPrefColumnCount(10);

        HBox secondLine = new HBox(5);
        secondLine.setPadding(new Insets(0, 0, 0, 10));
        secondLine.getChildren().addAll(labelX, textFieldX, labelY, textFieldY);
        /*-------------*/

        /*Third line*/
        Label answer = new Label("Answer");
        TextField textAnswer = new TextField();
        textAnswer.setPrefColumnCount(10);

        HBox thirdLine = new HBox(5);
        thirdLine.setPadding(new Insets(0, 0, 0, 10));
        thirdLine.getChildren().addAll(answer ,textAnswer);
        /*-------------*/

        /*Fourth line*/
        Button buttonPositive = new Button("+");
        Button buttonNegative = new Button("-");
        Button buttonMultiply = new Button("*");
        Button buttonSplit = new Button("/");
        Button buttonPercent = new Button("%");

        buttonPositive.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setOperation("addition");
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toAdd(add));
            textAnswer.setText(add.getAnswer() + "");
            LogsLogic.addArithmeticLogs(add);
        });

        buttonNegative.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setOperation("subtraction");
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toSubstract(add));
            textAnswer.setText(add.getAnswer() + "");
            LogsLogic.addArithmeticLogs(add);
        });

        buttonMultiply.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setOperation("multiplication");
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toMultiply(add));
            textAnswer.setText(add.getAnswer() + "");
            LogsLogic.addArithmeticLogs(add);
        });

        buttonSplit.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setOperation("division");
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toSplit(add));
            textAnswer.setText(add.getAnswer() + "");
            LogsLogic.addArithmeticLogs(add);
        });

        buttonPercent.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setOperation("percent calculation");
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().calculatePercentage(add));
            textAnswer.setText(add.getAnswer() + "");
            LogsLogic.addArithmeticLogs(add);
        });

        HBox fourthLine = new HBox(5);
        fourthLine.setPadding(new Insets(0, 0, 0, 10));
        fourthLine.getChildren().addAll(buttonPositive, buttonNegative, buttonMultiply, buttonSplit,
                buttonPercent);

        /*Split line*/
        Label splitlabel = new Label("----------------------------------------------------------" +
                "-----------");

        HBox split = new HBox(5);
        split.setPadding(new Insets(0, 0, 0, 10));
        split.getChildren().setAll(splitlabel);
        /*----------*/

        /*Fifth line*/
        Label otherNumberSystem = new Label("Conversion of numbers to other number systems");

        HBox fifthLine = new HBox(5);
        fifthLine.setPadding(new Insets(0, 0, 0, 10));
        fifthLine.getChildren().addAll(otherNumberSystem);
        /*----------*/

        /*Sixth line*/
        Label decNumber = new Label("Base number 10");
        Label binNumber = new Label("Base number 2");
        Label octNumber = new Label("Base number 8");
        Label hexNumber = new Label("Base number 16");

        TextField textDecNumber = new TextField();
        TextField textBinNumber = new TextField();
        TextField textOctNumber = new TextField();
        TextField textHexNumber = new TextField();

        Button btnConvert = new Button("Convert");
        btnConvert.setOnAction(event -> {
            int dec = Integer.parseInt(textDecNumber.getText());
            add.setDec(dec);
            add.setOperation("convert");
            new CalculationsLogic().convertToOtherNumberSystem(add);
            textBinNumber.setText(add.getBin() + "");
            textOctNumber.setText(add.getOct() + "");
            textHexNumber.setText(add.getHex().toUpperCase());
            LogsLogic.addNumberSystemLogs(add);
        });

        VBox sixthLineColumnOne = new VBox(5);
        sixthLineColumnOne.getChildren().addAll(decNumber, textDecNumber, btnConvert);

        VBox sixthLineColumnTwo = new VBox(5);
        sixthLineColumnTwo.getChildren().addAll(binNumber, textBinNumber, octNumber, textOctNumber, hexNumber,
                textHexNumber);

        HBox sixthLine = new HBox(5);
        sixthLine.setPadding(new Insets(0, 0, 0, 10));
        sixthLine.getChildren().addAll(sixthLineColumnOne, sixthLineColumnTwo);
        /*------*/

        /*Main menu*/
        BorderPane topBorder = new BorderPane();
        VBox topContainer = new VBox();
        MenuBar mainMenu = new MenuBar();

        Menu file = new Menu("File");

        Menu saveFile = new Menu("Save file");

        MenuItem saveFileSer = new MenuItem("To serialize");
        saveFileSer.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                        "BIN files (*.bin)","*.bin");
                fileChooserSave.getExtensionFilters().clear();
                fileChooserSave.getExtensionFilters().add(extFilter);
                File saveFileDir = fileChooserSave.showSaveDialog(primaryStage);

                add.setOperation("serialization");
                new SerializationMethods().toWriteObject(add, saveFileDir);
                LogsLogic.addSaveLogs(add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        MenuItem saveFileXML = new MenuItem("Save to XML");
        saveFileXML.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilterXML = new FileChooser.ExtensionFilter(
                        "XML files (*.xml)","*.xml");
                fileChooserSave.getExtensionFilters().clear();
                fileChooserSave.getExtensionFilters().add(extFilterXML);
                File saveFileDir = fileChooserSave.showSaveDialog(primaryStage);

                add.setOperation("XML");
                new SerializationMethods().toWriteObjectXML(add, saveFileDir);
                LogsLogic.addSaveLogs(add);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        MenuItem saveFileJSON = new MenuItem("Save to JSON");
        saveFileJSON.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilterJSON = new FileChooser.ExtensionFilter(
                        "JSON files (*.json)","*.json");
                fileChooserSave.getExtensionFilters().clear();
                fileChooserSave.getExtensionFilters().add(extFilterJSON);
                File saveFileDir = fileChooserSave.showSaveDialog(primaryStage);

                add.setOperation("JSON");
                new SerializationMethods().toWriteObjectJSON(add, saveFileDir);
                LogsLogic.addSaveLogs(add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saveFile.getItems().addAll(saveFileSer, saveFileXML, saveFileJSON);

        Menu downloadFile = new Menu("Download");

        MenuItem downloadFileSer = new MenuItem("Deserialize");
        downloadFileSer.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                        "BIN files (*.bin)","*.bin");
                fileChooserLoad.getExtensionFilters().clear();
                fileChooserLoad.getExtensionFilters().add(extFilter);
                File loadFile = fileChooserLoad.showOpenDialog(primaryStage);
                Calculations newAdd = new SerializationMethods().toReadObject(loadFile);

                newAdd.setOperation("serialization");
                textFieldX.setText(newAdd.getX() + "");
                textFieldY.setText(newAdd.getY() + "");
                textAnswer.setText(newAdd.getAnswer() + "");
                textBinNumber.setText(newAdd.getBin() + "");
                textOctNumber.setText(newAdd.getOct() + "");
                textDecNumber.setText(newAdd.getDec() + "");
                textHexNumber.setText(newAdd.getHex());
                LogsLogic.addDownloadLogs(newAdd);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        MenuItem downloadFileXML = new MenuItem("Download from XML");
        downloadFileXML.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilterXML = new FileChooser.ExtensionFilter(
                        "XML files (*.xml)","*.xml");
                fileChooserLoad.getExtensionFilters().clear();
                fileChooserLoad.getExtensionFilters().add(extFilterXML);
                File loadFile = fileChooserLoad.showOpenDialog(primaryStage);
                Calculations newAdd = new SerializationMethods().toReadObjectXML(loadFile);

                newAdd.setOperation("XML");
                textFieldX.setText(newAdd.getX() + "");
                textFieldY.setText(newAdd.getY() + "");
                textAnswer.setText(newAdd.getAnswer() + "");
                textBinNumber.setText(newAdd.getBin() + "");
                textOctNumber.setText(newAdd.getOct() + "");
                textDecNumber.setText(newAdd.getDec() + "");
                textHexNumber.setText(newAdd.getHex());
                LogsLogic.addDownloadLogs(newAdd);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        MenuItem downloadFileJSON = new MenuItem("Download from JSON");
        downloadFileJSON.setOnAction(event -> {
            try {
                FileChooser.ExtensionFilter extFilterJSON = new FileChooser.ExtensionFilter(
                        "JSON files (*.json)","*.json");
                fileChooserLoad.getExtensionFilters().clear();
                fileChooserLoad.getExtensionFilters().add(extFilterJSON);
                File loadFile = fileChooserLoad.showOpenDialog(primaryStage);
                Calculations newAdd = new SerializationMethods().toReadObjectJSON(loadFile);

                newAdd.setOperation("JSON");
                textFieldX.setText(newAdd.getX() + "");
                textFieldY.setText(newAdd.getY() + "");
                textAnswer.setText(newAdd.getAnswer() + "");
                textBinNumber.setText(newAdd.getBin() + "");
                textOctNumber.setText(newAdd.getOct() + "");
                textDecNumber.setText(newAdd.getDec() + "");
                textHexNumber.setText(newAdd.getHex());
                LogsLogic.addDownloadLogs(newAdd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        downloadFile.getItems().addAll(downloadFileSer, downloadFileXML, downloadFileJSON);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> {
            Platform.exit();
        });

        file.getItems().addAll(saveFile, downloadFile, exit);

        Menu service = new Menu("Service");

        MenuItem showLogs = new MenuItem("Show logs");
        showLogs.setOnAction(event -> showLogs());
        service.getItems().addAll(showLogs);

        mainMenu.getMenus().addAll(file, service);
        topContainer.getChildren().add(mainMenu);

        topBorder.setTop(topContainer);
        /*---------*/

        root.getChildren().addAll(topBorder, firstLine, secondLine, thirdLine, fourthLine,
                split, fifthLine, sixthLine);

        Scene scene = new Scene(root,  350, 350);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(String[] args) {
        launch(args);
    }

    public void showLogs() {
        Stage stageLogs = new Stage();

        TextArea areaLogs = new TextArea();
        areaLogs.setText(LogsLogic.showLogs());

        VBox vboxLogs = new VBox();
        vboxLogs.getChildren().addAll(areaLogs);

        Scene showLogs = new Scene(vboxLogs, 550, 350);
        stageLogs.setTitle("logs");
        stageLogs.setScene(showLogs);
        stageLogs.show();
    }
}
