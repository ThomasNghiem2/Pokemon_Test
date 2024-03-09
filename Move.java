import java.lang.Math;

public class Move {
    String name;
    String type;
    int attack;

    //int max = 3;
    //int min = 1;
    //int range = max - min + 1;
    //int rand = (int) (Math.random() * range) + min;

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
    }

    public String toString()
    {
        return name;

    }
    
}
