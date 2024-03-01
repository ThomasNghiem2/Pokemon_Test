import java.util.Scanner;
import java.lang.Math;

public class Pokemon {
    String name;
    int hp;
    String type;

    public Pokemon(String str) {
        if (!str.equalsIgnoreCase("Charmander") ||
                !str.equalsIgnoreCase("Bulbasaur") ||
                !str.equalsIgnoreCase("Squirtle")) {
            System.out.println("Not a valid Pokemon");
            return;
        }
        if (str.equalsIgnoreCase("Charmander")) {
            this.name = "Charmander";
            this.hp = 10;
            this.type = "fire";
        }
        if (str.equalsIgnoreCase("Bulbasaur")) {
            this.name = "Bulbasaur";
            this.hp = 10;
            this.type = "grass";
        }
        if (str.equalsIgnoreCase("Squirtle")) {
            this.name = "Squirtle";
            this.hp = 10;
            this.type = "water";
        }
        if (str.equalsIgnoreCase("Snorlax")) {
            this.name = "Snorlax";
            this.hp = 20;
            this.type = "normal";
        }
        
    }

    public void attack(Pokemon otherPokemon, String move) {
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int rand = (Math.random() * range) + min;

        otherPokemon.hp -= rand;
        System.out.println(this.name + "used" + move + "against" + otherPokemon.name + 
                "/n" + otherPokemon.name + "took" + rand + "damage and has" + otherPokemon.hp +
                "left");
    }

    public String pokemonBattle(Pokemon otherPokemon) {
        java.util.Scanner scan = new Scanner();
        while (this.hp > 0 && otherPokemon.hp > 0) {
            String playerMove = scan.nextLine();
            this.attack(otherPokemon, playerMove);
            otherPokemon.attack(this, "Belly Drum");
        }
        if (this.hp <= 0) {
            return "computer";
        }
        else {
            return "player";
        }
    }
}
