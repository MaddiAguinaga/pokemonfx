package eus.ehu.pokemonfx.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    String name;
    Integer id;
    Integer weight;
    Integer height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public void setSprites(SpriteWrapper sprites) {
        this.sprites = sprites;
    }

    public String getSprite(){
        return sprites.other.offiacialArtwork.front_shiny;
    }

    class SpriteWrapper{
        String front_default;
        String back_default;
        String front_shiny;
        String back_shiny;
        class Other {
            class OffiacialArtwork{
                String front_shiny;

                @Override
                public String toString() {
                    return "OffiacialArtwork{" +
                            "front_shiny='" + front_shiny + '\'' +
                            '}';
                }
            }
            @SerializedName("official-artwork")
            OffiacialArtwork offiacialArtwork;

            @Override
            public String toString() {
                return "Other{" +
                        "offiacialArtwork=" + offiacialArtwork +
                        '}';
            }
        }
        Other other;

        @Override
        public String toString() {
            return "SpriteWrapper{" +
                    "front_default='" + front_default + '\'' +
                    ", back_default='" + back_default + '\'' +
                    ", front_shiny='" + front_shiny + '\'' +
                    ", back_shiny='" + back_shiny + '\'' +
                    ", other=" + other +
                    '}';
        }
    }


    SpriteWrapper sprites;

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", sprites=" + sprites +
                '}';
    }
}
