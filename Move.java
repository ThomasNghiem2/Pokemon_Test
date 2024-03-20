/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow, GeeksForGeeks

This file is for all of the moves in the game. 
*/
import java.lang.Math;
/**
 * This class creates all of the moves in the game
 */
public class Move {
    String name;
    String type;
    int attack;
    //Creates all of the move objects for the game
    public Move(String str)
    {
        //Charmander moves
        if(str.equalsIgnoreCase("Scratch"))
        {
            name = "Scratch";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Ember"))
        {
            name = "Ember";
            type = "Fire";
            int range = 2;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Fire Fang"))
        {
            name = "Fire Fang";
            type = "Fire";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Flamethrower"))
        {
            name = "Flamethrower";
            type = "Fire";
            int range = 2;
            attack = (int) (Math.random() * range) + 4;
        }
        //Bulbasaur moves
        if(str.equalsIgnoreCase("Tackle"))
        {
            name = "Tackle";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Vine Whip"))
        {
            name = "Vine Whip";
            type = "Grass";
            int range = 2;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Razor Leaf"))
        {
            name = "Razor Leaf";
            type = "Grass";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Solar Beam"))
        {
            name = "Solar Beam";
            type = "Fire";
            int range = 2;
            attack = (int) (Math.random() * range) + 4;
        }
        //Squirtle Moves
        if(str.equalsIgnoreCase("Tail Whip"))
        {
            name = "Tail Whip";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Water Gun"))
        {
            name = "Water Gun";
            type = "Water";
            int range = 2;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Water Pulse"))
        {
            name = "Water Pulse";
            type = "Water";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Hydro Pump"))
        {
            name = "Hydro Pump";
            type = "Water";
            int range = 2;
            attack = (int) (Math.random() * range) + 4;
        }
        //Snorlax Moves
        if(str.equalsIgnoreCase("Belly Drum"))
        {
            name = "Belly Drum";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Tackle"))
        {
            name = "Tackle";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Body Slam"))
        {
            name = "Body Slam";
            type = "Normal";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Giga Impact"))
        {
            name = "Giga Impact";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 6;
        }
        //Eevee Moves
        if(str.equalsIgnoreCase("Tail Whip"))
        {
            name = "Tail Whip";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Tackle"))
        {
            name = "Tackle";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Swift"))
        {
            name = "Swift";
            type = "Normal";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Take Down"))
        {
            name = "Take Down";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 4;
        }
        //Pikachu Moves
        if(str.equalsIgnoreCase("Tail Whip"))
        {
            name = "Tail Whip";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 1;
        }
        if(str.equalsIgnoreCase("Thunder Shock"))
        {
            name = "Thunder Shock";
            type = "Electric";
            int range = 2;
            attack = (int) (Math.random() * range) + 2;
        }
        if(str.equalsIgnoreCase("Electro Ball"))
        {
            name = "Electro Ball";
            type = "Electric";
            int range = 3;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Thunder"))
        {
            name = "Thunder";
            type = "Electric";
            int range = 2;
            attack = (int) (Math.random() * range) + 4;
        }
        //Mewtwo Moves
        if(str.equalsIgnoreCase("Disable"))
        {
            name = "Disable";
            type = "Normal";
            int range = 2;
            attack = (int) (Math.random() * range) + 3;
        }
        if(str.equalsIgnoreCase("Psycho Cut"))
        {
            name = "Psycho Cut";
            type = "Psychic";
            int range = 2;
            attack = (int) (Math.random() * range) + 5;
        }
        if(str.equalsIgnoreCase("Psychic"))
        {
            name = "Psychic";
            type = "Psychic";
            int range = 3;
            attack = (int) (Math.random() * range) + 6;
        }
        if(str.equalsIgnoreCase("Psystrike"))
        {
            name = "Psystrike";
            type = "Psychic";
            int range = 2;
            attack = (int) (Math.random() * range) + 12;
        }
    }
    //Returns name of the Pokemon when printed
    public String toString()
    {
        return name;
    }
}
