public class Player 
{
    String name;
    Pokemon[] team;

    public Player(String name, Pokemon one, Pokemon two, Pokemon three)
    {
        team = new Pokemon[3];
        this.name = name;
        team[0] = one;
        team[1] = two;
        team[2] = three;
    }

    public boolean switchPokemon(Pokemon currentPokemon, Pokemon switchPokemon)
    {
        return true;

    }
    
}
