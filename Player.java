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
        if(this.curr.name.equalsIgnoreCase(desiredPokemon.name))
        {
            return "Pokemon is in play, please try again!"; 
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
    public Pokemon nameToPokemon(String pokename)
    {
        for(int i = 0; i < team.length; i++)
        {
            if(team[i].name.equalsIgnoreCase(pokename))
            {
                return team[i];
            }
        }
        return null;
    }
    //Returns alive Pokemon
    public ArrayList returnAlive(Pokemon[] team)
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
        return team[0].name + ", " + team[1].name + ", and " + team[2].name;
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
    //Ensures string option is correct.
    public boolean ChoiceChecker (String response)
    {
        if(!response.equals("1") && 
            !response.equals("2") &&
            !response.equals("3"))
            {
                return true;
            }
        return false;
    }
    //The Player battle
    public String playerBattle(Player other) {
        battleLoop:
        while (teamAlive(this) && teamAlive(other))
        {
            //Beginning of round
            ArrayList<String> teamArrayList = new ArrayList<>();    
            for(int i = 0; i < team.length; i++)
            {
                teamArrayList.add(team[i].name);
            }
            System.out.println();
            System.out.println(this.name + " turn:");
            System.out.println("Your current Pokemon is " + curr.name + " and it has " + curr.hp + " hp left" );
            System.out.println();
            System.out.println("What do you want to do? (Enter 1 to switch Pokemon, 2 to heal, 3 to battle)");
            Scanner scan = new Scanner(System.in);
            System.out.println();
            String response = scan.nextLine();
            //Error Checking
            if(ChoiceChecker(response))
            {
                System.out.println("Invalid input, try again!");
                response = scan.nextLine();
            }
            //Player Switches Pokemon
            if(response.equals("1"))
            {
                System.out.print("You can switch to ");
                //Prints available pokemon
                for(int i = 0; i < team.length; i++)
                {
                    if(!team[i].equals(curr) && team[i].alive)
                    {
                        System.out.print(team[i].name + " ");
                    }
                }
                System.out.println();
                String switchPoke = scan.nextLine();
                //Errror Checking
                while(!Pokemon.checkPokeName(switchPoke,teamArrayList)) 
                {
                    System.out.println("Invalid!");
                    switchPoke = scan.nextLine();
                }
                System.out.println();
                System.out.println(selectPokemon(this.nameToPokemon(switchPoke)));
                System.out.println();
            }
            //Heals Pokemon
            if(response.equals("2"))
            {
                if(this.potions == 0)
                {
                    System.out.println(this.name + " has ran out of potions");
                }
                else
                {
                    System.out.println(this.healPokemon(this.curr));
                    System.out.println(this.name +  " has " + this.potions + " potions left");
                }
                System.out.println(); 
            }
            //Player attack other Pokemon
            if(response.equals("3"))
            {
                curr.pokemonBattle(other.curr);  
                if(!other.curr.alive)
                {
                    System.out.println(other.curr.name + " has fainted.");
                    //Checks for battle ending
                    if (!teamAlive(other)) 
                    {
                        break battleLoop;
                    }
                    ArrayList alivePokemon = returnAlive(other.team);
                    int randPoke = (int) (Math.random() * alivePokemon.size());
                    other.selectPokemon((Pokemon) alivePokemon.get(randPoke));
                    System.out.println("Thomas has switched to " + other.curr.name);
                    System.out.println();
                }     
            } 
            //CPU's Turn
            int cpuChoice = (int) (Math.random() * 3) + 1 ;
            System.out.println("Thomas turn:");
            System.out.println("Thomas's Pokemon is " + other.curr.name + " and it has " + other.curr.hp + " left" );
            System.out.println();
            //Forces CPU to switch if their Pokemon faints
            if(!other.curr.alive)
            {
                cpuChoice = 1;
            }
            //CPU switches
            if(cpuChoice == 1)
            {
                ArrayList<Pokemon> availableCPUPokemon = new ArrayList<>();
                //Adds only available Pokemon
                for(int i = 0; i < other.team.length; i++)
                {
                    
                    if(!other.team[i].equals(other.curr) && other.team[i].alive)
                    {
                        availableCPUPokemon.add(other.team[i]);
                    }
                }
                //Only allows switches if there is a possible Pokemon to switch to
                if(availableCPUPokemon.size() > 0)
                {
                    int cpuSwitchPoke = (int) (Math.random() * availableCPUPokemon.size());
                    other.selectPokemon(availableCPUPokemon.get(cpuSwitchPoke));
                    System.out.println("Thomas switched to " + other.curr.name);
                }
                else
                {
                    System.out.println("Thomas is unable to switch Pokemons");
                }
            } 
            //CPU heals
            if(cpuChoice == 2)
            {
                if(other.potions == 0)
                {
                    System.out.println("Thomas ran out of potions");
                }
                else
                {
                    System.out.println(other.healPokemon(other.curr));
                    System.out.println("Thomas has " + other.potions + " potions left");
                }
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
                    System.out.print("You can switch to ");
                    for(int i = 0; i < team.length; i++)
                    {
                        if(!team[i].equals(curr) && team[i].alive)
                        {
                            System.out.print(team[i].name + " ");
                        }
                    }
                    System.out.println();
                    String switchPoke = scan.nextLine();
                    //Error Checking
                    while(!Pokemon.checkPokeName(switchPoke,teamArrayList) || 
                        switchPoke.equalsIgnoreCase(this.curr.name)) 
                    {
                        System.out.println("Invalid, try again!");
                        switchPoke = scan.nextLine();
                    }
                    System.out.println();
                    System.out.println(selectPokemon(this.nameToPokemon(switchPoke)));
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

