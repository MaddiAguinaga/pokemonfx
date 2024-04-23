package eus.ehu.pokemonfx;

import com.google.gson.Gson;

import eus.ehu.pokemonfx.domain.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextArea content;

    @FXML
    private ImageView icon;

    @FXML
    private TextField name;

    @FXML
    void actionGet(ActionEvent event) {

        Gson gson = new Gson();
        String json = null;

        try{
            json = Utils.query("https://pokeapi.co/api/v2/pokemon/" + name.getText().toLowerCase());
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        Pokemon pokemon = gson.fromJson(json, Pokemon.class);
        String url = pokemon.getSprite();
        icon.setImage(new Image(url));
        content.setText(pokemon.toString());

    }

    @FXML
    void initialize() {

    }

}
