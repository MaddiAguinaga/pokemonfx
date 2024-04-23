package eus.ehu.pokemonfx;

import com.google.gson.Gson;

import eus.ehu.pokemonfx.domain.Pokemon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class PokemonController {

    @FXML
    private TextField height;

    @FXML
    private ImageView icon;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField weight;

    @FXML
    private Label warning;

    private List<String> names;

    private int position;


    @FXML
    void onNext(ActionEvent event) {

        if(position==names.size()-1){
            warning.setVisible(true);
            warning.setText("You are at the end");
            warning.setStyle("-fx-background-color: #eeaeae; -fx-text-fill: darkred; -fx-alignment: center");

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> warning.setVisible(false));
            });

            thread.start();
        }else{
            position++;
        }
        showPokemon();

    }

    @FXML
    void onPrevious(ActionEvent event) {

        if(position==0){
            warning.setVisible(true);
            warning.setText("You are at the beginning");
            warning.setStyle("-fx-background-color: #eeaeae; -fx-text-fill: darkred; -fx-alignment: center");

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> warning.setVisible(false));
            });

            thread.start();
        }else{
            position--;
        }
        showPokemon();
    }


    @FXML
    void initialize() {
        names = List.of("ditto", "pikachu", "magikarp", "charmander", "bulbasaur", "jigglypuff", "psyduck");
        warning.setVisible(false);
        position = 0;
        showPokemon();
    }

    @FXML
    void showPokemon(){
        Gson gson = new Gson();
        String json;
        try {
            json = Utils.query("https://pokeapi.co/api/v2/pokemon/" + names.get(position));
            Pokemon pokemon = gson.fromJson(json, Pokemon.class);
            String url = pokemon.getSprite();
            icon.setImage(new Image(url));
            id.setText(Integer.toString(pokemon.getId()));
            name.setText(pokemon.getName());
            weight.setText(Integer.toString(pokemon.getWeight()));
            height.setText(Integer.toString(pokemon.getHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
