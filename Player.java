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
    public String selectPokemon(String pokemonName, Pokemon current) {
        if(this.curr.name.equalsIgnoreCase(pokemonName))
        {
            return "Pokemon was not found, please try again!"; 
        }
        for (Pokemon p: team) {
            if (pokemonName.equalsIgnoreCase(p.name)) {
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
    //The Player battle
    public String playerBattle(Player other) {
        while (teamAlive(this) && teamAlive(other))
        {
            //Beginning of round
            System.out.println();
            System.out.println(this.name + " turn:");
            System.out.println("Your current Pokemon is " + curr.name + " and it has " + curr.hp + " hp left" );
            System.out.println();
            System.out.println("What do you want to do? (Enter 1 to switch Pokemon, 2 to heal, 3 to battle)");
            Scanner scan = new Scanner(System.in);
            System.out.println();
            ArrayList<String> teamArrayList = new ArrayList<>();    
            for(int i = 0; i < team.length; i++)
            {
                teamArrayList.add(team[i].name);
            }
            String response = scan.nextLine();
            //Error Checking
            if(!response.equals("1") && 
                !response.equals("2") &&
                !response.equals("3"))
            {
                System.out.println("Invalid input, try again!");
                response = scan.nextLine();
            }
            //Switches Pokemon
            if(response.equals("1"))
            {
                System.out.print("You can switch to ");
                for(int i = 0; i < team.length; i++)
                {
                    if(!team[i].equals(curr))
                    {
                        System.out.print(team[i].name + " ");
                    }
                }
                System.out.println();
                String switchPoke = scan.nextLine();
                //Errror Checking
                while(!Pokemon.checkPokeName(switchPoke,teamArrayList)) 
                {
                    System.out.println("Invalid Pokemon, try again!");
                    switchPoke = scan.nextLine();
                }
                System.out.println();
                System.out.println(selectPokemon(switchPoke, this.curr));
                System.out.println();
            }
            //Heals Pokemon
            if(response.equals("2"))
            {
                System.out.println(this.healPokemon(this.curr));  
                System.out.println(this.name + " has " + this.potions + " potion(s) left");
                System.out.println(); 
            }
            //Player attack other Pokemon
            if(response.equals("3"))
            {
                curr.pokemonBattle(other.curr);  
            } 
            //CPU's Turn
            int cpuChoice = (int) (Math.random() * 3) + 1 ;
            System.out.println("Thomas turn:");
            System.out.println("Thomas's Pokemon is " + other.curr.name + " and it has " + other.curr.hp + " left" );
            System.out.println();
            //CPU switches
            if(cpuChoice == 1)
            {
                ArrayList<String> availableCPUPokemon = new ArrayList<>();
                for(int i = 0; i < other.team.length; i++)
                {
                    if(!other.team[i].equals(other.curr))
                    {
                        availableCPUPokemon.add(other.team[i].name);
                    }
                }
                int cpuSwitchPoke = (int) (Math.random() * 2);
                other.selectPokemon(availableCPUPokemon.get(cpuSwitchPoke), other.curr);
                System.out.println("Thomas switched to " + other.curr.name);
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
            }      
        }
        //TBD Pokemon should faint and be forced to switch out
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
    //Prints team
    public String printTeam() {
        return team[0].name + ", " + team[1].name + ", and " + team[2].name;
    }
    //Checks if the team is alive
    public boolean teamAlive(Player player)
    {
        for(int i = 0; i < team.length; i++)
        {
            if(team[i].hp > 0)
            {
                return true;
            }
        }
        return false;
    }

}
