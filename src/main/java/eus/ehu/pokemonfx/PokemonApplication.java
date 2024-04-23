package eus.ehu.pokemonfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PokemonApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PokemonApplication.class.getResource("pokemon.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Pokemon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}