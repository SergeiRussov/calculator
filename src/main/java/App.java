import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        HBox firstLine = new HBox();

        root.setAlignment(Pos.CENTER);

        Label input = new Label("Введите числа x и y:");
        //первая строка
        firstLine.getChildren().addAll(input);

        Label labelX = new Label("x = ");
        Label labelY = new Label("y = ");

        TextField textFieldX = new TextField();
        TextField textFieldY = new TextField();

        HBox secondLine = new HBox();
        secondLine.getChildren().addAll(labelX, textFieldX, labelY, textFieldY);

        Label answer = new Label("Ответ");
        TextField textAnswer = new TextField();

        Button buttonPositive = new Button("+");
        Button buttonNegative = new Button("-");

        buttonPositive.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            textAnswer.setText(Calculations.toAdd(x, y) + "");
        });

        buttonNegative.setOnAction(event -> {
            double x = Double.parseDouble(textFieldX.getText());
            double y = Double.parseDouble(textFieldY.getText());
            textAnswer.setText(Calculations.toSubstract(x, y) + "");
        });

        HBox thirdLine = new HBox(answer, textAnswer);

        HBox fourthLine = new HBox();
        fourthLine.getChildren().addAll(buttonPositive, buttonNegative);

        root.getChildren().addAll(firstLine, secondLine, thirdLine, fourthLine);

        Scene scene = new Scene(root, 400, 500);

        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void start(String[] args) {
        launch(args);
    }
}
