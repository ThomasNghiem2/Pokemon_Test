public class MoveSet 
{
    Move[] moveList;

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
            Move move2 = new Move ("Belly Drum");
            Move move3 = new Move ("Belly Drum");
            Move move4 = new Move ("Belly Drum");
            moveList[0] = move1;
            moveList[1] = move2;
            moveList[2] = move3;
            moveList[3] = move4;
        }
    }
}
