package com.mycompany.leaguetracker;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       
        Label instructionText = new Label("Please type your username");
        PasswordField usernameField = new PasswordField();
        Button loginButton = new Button("Login");
        Label errorMessage = new Label("");
        
        GridPane loginPane = new GridPane();

        loginPane.add(instructionText, 0, 0);
        loginPane.add(usernameField, 0, 1);
        loginPane.add(loginButton, 0, 2);
        loginPane.add(errorMessage, 0, 3);
        
        loginPane.setPrefSize(300, 180);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setVgap(10);
        loginPane.setHgap(10);
        loginPane.setPadding(new Insets(20, 20, 20, 20));
        
        Scene loginScene = new Scene(loginPane);
        
        Button logoutButton = new Button("Logout");
        Label tervetuloaTeksti = new Label("Welcome!");

        StackPane welcomePane = new StackPane();
        welcomePane.setPrefSize(300, 180);
        welcomePane.getChildren().add(tervetuloaTeksti);
        welcomePane.setAlignment(Pos.TOP_CENTER);
        welcomePane.getChildren().add(logoutButton);
        welcomePane.setAlignment(Pos.BOTTOM_CENTER);

        Scene welcomeScene = new Scene(welcomePane);
        
        loginButton.setOnAction((event) -> {
          if (!usernameField.getText().trim().equals("salasana")) {
              errorMessage.setText("There's no such user!");
              return;
          }

          stage.setScene(welcomeScene);
        });
        logoutButton.setOnAction((event) -> {
            stage.setScene(loginScene);
        });
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();*/
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
