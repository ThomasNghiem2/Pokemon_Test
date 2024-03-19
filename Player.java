/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow, GeeksForGeeks

This file creates all of the Pokemon in the game. 
*/
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class creates the players in the game
 */
public class Player 
{
    //Instance variables
    String name;
    Pokemon curr;
    Pokemon[] team;
    int potions;
    //Constructor
    public Player(String name, Pokemon one, Pokemon two, Pokemon three)
    {
        team = new Pokemon[3];
        this.name = name;
        curr = one;
        team[0] = one;
        team[1] = two;
        team[2] = three;
        potions = 2;
    }
    //Switches Pokemon during the battle
    public String selectPokemon(Pokemon desiredPokemon) {
        if(!desiredPokemon.alive)
        {
            return "This Pokemon has fainted";
        }
        for (Pokemon p: team) {
            if (desiredPokemon.name.equalsIgnoreCase(p.name)) {
                curr = p;
                return curr.name + ", I choose you!";
            }
        }
        return "Null";
    }
    //Heals Pokemon
    public String healPokemon(Pokemon pokemon) {
        int potionHealAmt = 3;
        if (potions > 0) {
            pokemon.hp += potionHealAmt;
            if(pokemon.hp >  pokemon.maxHP) {
                pokemon.hp = pokemon.maxHP;
            }
            potions--;
            return "Success! " + pokemon.name + " gained " + potionHealAmt + " hp! " + 
                pokemon.name + " has " + pokemon.hp +" hp left";
        }
        else {
            return "Oh no, you're out of potions :(";
        }
    }
    //Returns Pokemon from its name
    public Pokemon nameToPokemon(String pokemon)
    {
        for(int i = 0; i < team.length; i++)
        {
            if(team[i].name.equalsIgnoreCase(pokemon))
            {
                return team[i];
            }
        }
        return null;
    }
    //Returns alive Pokemon
    public ArrayList<Pokemon> returnAlive(Pokemon[] team)
    {
        ArrayList<Pokemon> alive = new ArrayList<>();
        for(int i = 0; i < team.length; i++)
        {
            if(team[i].alive)
            {
                alive.add(team[i]);
            }
        }
        return alive;
    }
    //Prints team
    public String printTeam() {
        return team[0].name + ", " + team[1].name + ", and " 
            + team[2].name;
    }
    //Prints available switch Pokemon
    public String printSwitchAvailable(Player player)
    {
        String returnString = "You can switch to ";
        for(int i = 0; i < player.team.length; i++)
        {
            if(!this.team[i].equals(curr) && team[i].alive)
            {
                returnString += this.team[i].name + " ";
            }
        }
        return returnString;
    }
    //Checks if the team is alive
    public boolean teamAlive(Player player)
    {
        for(int i = 0; i < player.team.length; i++)
        {
            if(player.team[i].alive)
            {
                return true;
            }
        }
        return false;
    }
    //Ensures intial option is correct.
    public boolean choiceChecker (String response)
    {
        if(!response.equals("1") && 
            !response.equals("2") &&
            !response.equals("3"))
            {
                return true;
            }
        return false;
    }
    //Returns available Pokemon to switch to
    public ArrayList<Pokemon> returnSwitchAvailablePokemon (Player player)
    {
        ArrayList<Pokemon> availablePokemon = new ArrayList<>();
        for(int i = 0; i < this.team.length; i++)
        {            
            if(!this.team[i].equals(this.curr) && this.team[i].alive)
            {
                availablePokemon.add(this.team[i]);
            }
        }
        return availablePokemon;
    }
    //When Cpu switches Pokemon
    public void cpuSwitch (ArrayList<Pokemon> pokemons)
    {
        if(!(pokemons.size() > 0))
        {
            System.out.println("Thomas is unable to switch Pokemons");
        }
        else
        {
            int randPoke = (int) (Math.random() * pokemons.size());
            this.selectPokemon(pokemons.get(randPoke));
            System.out.println("Thomas has switched to " + this.curr.name);
        }
    }
    //Heal process
    public void healProcess ()
    {
        if(this.potions == 0)
        {
            System.out.println(this.name + " ran out of potions");
        }
        else            
        {
            System.out.println(this.healPokemon(this.curr));
            System.out.println(this.name + " has " + this.potions + " potions left");
        }
    }
    //Player switching process
    public String playerSwitchProcess (Player player, ArrayList<Pokemon> list)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(printSwitchAvailable(this));
        System.out.println();
        String switchPoke = scan.nextLine();
        //Errror Checking
        while(!Pokemon.checkPokeName(switchPoke,list) ||
            nameToPokemon(switchPoke).equals(curr)) 
        {
            System.out.println("Invalid!");
            switchPoke = scan.nextLine();
        }
        System.out.println();
        return(selectPokemon(this.nameToPokemon(switchPoke)));
    }
    //The Player battle
    public String playerBattle(Player other) {
        battleLoop:
        while (true)
        {
            //Beginning of round
            ArrayList<Pokemon> teamArrayList = returnAlive(this.team);
            System.out.println();
            System.out.println(this.name + " turn:");
            System.out.println("Your current Pokemon is " + curr.name + " and it has " + curr.hp + " hp left" );
            System.out.println();
            System.out.println("What do you want to do? (Enter 1 to switch Pokemon, 2 to heal, 3 to battle)");
            Scanner scan = new Scanner(System.in);
            System.out.println();
            String response = scan.nextLine();
            //Error Checking
            if(choiceChecker(response))
            {
                System.out.println("Invalid input, try again!");
                response = scan.nextLine();
            }
            //Player Switches Pokemon
            if(response.equals("1"))
            {
                System.out.println(playerSwitchProcess(this, teamArrayList));
                System.out.println();
            }
            //Heals Pokemon
            if(response.equals("2"))
            {
                this.healProcess();
                System.out.println(); 
            }
            //Player attack other Pokemon
            if(response.equals("3"))
            {
                curr.pokemonBattle(other.curr); 
                //Checks if computer Pokemon fainted 
                if(!other.curr.alive)
                {
                    System.out.println(other.curr.name + " has fainted.");
                    //Checks for battle ending
                    if (!teamAlive(other)) 
                    {
                        break battleLoop;
                    }
                    ArrayList<Pokemon> alivePokemon = returnAlive(other.team);
                    other.cpuSwitch(alivePokemon);
                    System.out.println();
                }     
            } 
            //CPU's Turn
            int cpuChoice = (int) (Math.random() * 3) + 1 ;
            System.out.println("Thomas turn:");
            System.out.println("Thomas's Pokemon is " + other.curr.name + " and it has " + other.curr.hp + " left\n");
            //Forces CPU to switch if their Pokemon faints
            if(!other.curr.alive)
            {
                cpuChoice = 1;
            }
            //CPU switches
            if(cpuChoice == 1)
            {
                ArrayList<Pokemon> availableCPUPokemon = returnSwitchAvailablePokemon(other);
                other.cpuSwitch(availableCPUPokemon);
            } 
            //CPU heals
            if(cpuChoice == 2)
            {
                other.healProcess();
            }
            //CPU attacks
            if(cpuChoice == 3)
            {
                int randAttack = (int) (Math.random() * 4) ;
                other.curr.attack(this.curr, other.curr.moveSet.moveList[randAttack].name);
                if(!this.curr.alive)
                {
                    //Forces player to switch if their Pokemon faints
                    System.out.println("Your Pokemon has fainted");
                    System.out.println();
                    //Checks for battle ending
                    if (!teamAlive(this)) 
                    {
                        break battleLoop;
                    }
                    System.out.println(playerSwitchProcess(this, teamArrayList));
                    System.out.println();   
                }
            }      
        }
        //End of game check 
        if (!teamAlive(this) && !teamAlive(other)) {
            return "You Tied! Do you want to try again? (type q if you are done, anything else to play again)";
        }
        else if (!teamAlive(other)) {
            return "Congratulations! You won! Do you want to play again? (type q if you are done, anything else to play again)";
        }
        else {
            return "Oh No! You Lost! Do you want to try again? (type q if you are done, anything else to play again)";
        }
    }
}