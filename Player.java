public class Player 
{
    String name;
    Pokemon curr;
    Pokemon[] team;
    int potions;

    public Player(String name, Pokemon one, Pokemon two, Pokemon three)
    {
        team = new Pokemon[3];
        this.name = name;
        curr = null;
        team[0] = one;
        team[1] = two;
        team[2] = three;
        potions = 2;
    }

    public String selectPokemon(String pokemonName) {
        for (Pokemon p: team) {
            if (pokemonName.equalsIgnoreCase(p.name)) {
                curr = p;
                return curr.name + ", I choose you!";
            }
        }
        return "Pokemon was not found, please try again!";
    }
    
    public String healPokemon(Pokemon pokemon) {
        int potionHealAmt = 5;
        if (potions > 0) {
            pokemon.hp += potionHealAmt;
            return "Success! Your pokemon gained " + potionHealAmt;
        }
        else {
            return "Oh no, you're out of potions :(";
        }
    }

    public void attack(Pokemon other) {
        curr.pokemonBattle(other);
    }
}
