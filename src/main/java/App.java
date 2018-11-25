import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public void start(Stage primaryStage) throws Exception {

        Calculations add = new Calculations();

        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);

        /*First line*/
        Label input = new Label("Введите числа x и y:");

        HBox firstLine = new HBox(5);
        firstLine.setAlignment(Pos.CENTER);
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
        secondLine.setAlignment(Pos.CENTER);
        secondLine.getChildren().addAll(labelX, textFieldX, labelY, textFieldY);
        /*-------------*/

        /*Third line*/
        Label answer = new Label("Ответ");
        TextField textAnswer = new TextField();
        textAnswer.setPrefColumnCount(10);

        HBox thirdLine = new HBox(5);
        thirdLine.setAlignment(Pos.CENTER);
        thirdLine.getChildren().addAll(answer ,textAnswer);
        /*-------------*/

        /*Fourth line*/
        Button buttonPositive = new Button("+");
        Button buttonNegative = new Button("-");

        buttonPositive.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toAdd(add));
            textAnswer.setText(add.getAnswer() + "");
        });

        buttonNegative.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toSubstract(add));
            textAnswer.setText(add.getAnswer() + "");
        });

        HBox fourthLine = new HBox(5);
        fourthLine.setAlignment(Pos.CENTER);
        fourthLine.getChildren().addAll(buttonPositive, buttonNegative);
        /*----------------*/

        /*Fifth line*/
        Button buttonMultiply = new Button("*");
        Button buttonSplit = new Button("/");

        buttonMultiply.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toMultiply(add));
            textAnswer.setText(add.getAnswer() + "");
        });

        buttonSplit.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().toSplit(add));
            textAnswer.setText(add.getAnswer() + "");
        });

        HBox fifthLine = new HBox(5);
        fifthLine.setAlignment(Pos.CENTER);
        fifthLine.getChildren().addAll(buttonMultiply, buttonSplit);
        /*------------*/

        /*Sixth line*/
        Button buttonPercent = new Button("%");

        buttonPercent.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            add.setX(x);
            add.setY(y);
            add.setAnswer(new CalculationsLogic().calculatePercentage(add));
            textAnswer.setText(add.getAnswer() + "");
        });

        HBox sixthLine = new HBox(5);
        sixthLine.setAlignment(Pos.CENTER);
        sixthLine.getChildren().addAll(buttonPercent);
        /*----------*/

        /*Seventh line*/
        Button buttonSave = new Button("Сохранить данные");
        Button buttonLoad = new Button("Загрузить данные");

        buttonSave.setOnAction(event -> {
            try {
                new SerializationMethods().toWriteObject(add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonLoad.setOnAction(event -> {
            try {
                Calculations newAdd = new SerializationMethods().toReadObject();
                textFieldX.setText(newAdd.getX() + "");
                textFieldY.setText(newAdd.getY() + "");
                textAnswer.setText(newAdd.getAnswer() + "");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        HBox seventhLine = new HBox(5);
        seventhLine.setAlignment(Pos.CENTER);
        seventhLine.getChildren().addAll(buttonSave, buttonLoad);
        /*------------*/

        root.getChildren().addAll(firstLine, secondLine, thirdLine, fourthLine, fifthLine, sixthLine, seventhLine);

        Scene scene = new Scene(root, 350, 250);

        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void start(String[] args) {
        launch(args);
    }
}
