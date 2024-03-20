/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow, GeeksForGeeks

This file creates movesets for all Pokemons. 
*/

/**
 * This class creats all of the movesets in the game
 */
public class MoveSet 
{
    Move[] moveList;
    //Creates movesets for all of the Pokemon in the game
    public MoveSet (String str)
    {
        moveList = new Move[4];
        if(str.equalsIgnoreCase("charmander"))
        {
            Move move1 = new Move ("Scratch");
            Move move2 = new Move ("Ember");
            Move move3 = new Move ("Fire Fang");
            Move move4 = new Move ("Flamethrower");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("bulbasaur"))
        {
            Move move1 = new Move ("Tackle");
            Move move2 = new Move ("Vine Whip");
            Move move3 = new Move ("Razor Leaf");
            Move move4 = new Move ("Solar Beam");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("squirtle"))
        {
            Move move1 = new Move ("Tail Whip");
            Move move2 = new Move ("Water Gun");
            Move move3 = new Move ("Water Pulse");
            Move move4 = new Move ("Hydro Pump");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("snorlax"))
        {
            Move move1 = new Move ("Belly Drum");
            Move move2 = new Move ("Tackle");
            Move move3 = new Move ("Body Slam");
            Move move4 = new Move ("Giga Impact");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("eevee"))
        {
            Move move1 = new Move ("Tail Whip");
            Move move2 = new Move ("Tackle");
            Move move3 = new Move ("Swift");
            Move move4 = new Move ("Take Down");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("pikachu"))
        {
            Move move1 = new Move ("Tail Whip");
            Move move2 = new Move ("Thunder Shock");
            Move move3 = new Move ("Electro Ball");
            Move move4 = new Move ("Thunder");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
        if(str.equalsIgnoreCase("mewtwo"))
        {
            Move move1 = new Move ("Disable");
            Move move2 = new Move ("Psycho Cut");
            Move move3 = new Move ("Psychic");
            Move move4 = new Move ("Psystrike");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
    }
}
