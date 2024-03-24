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
    //Ensures intial option is correct.
    public boolean choiceChecker (String response)
    {
        if(response.equals("1") || 
            response.equals("2") ||
            response.equals("3"))
        {
            return true;
        }
        return false;
    }
    //Makes CPU behavior more human-like
    public int cpuBehavior()
    {
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        if(returnSwitchAvailablePokemon(this).size() == 0)
        {
            possibleMoves.remove((Object) 1);
        }
        if(this.potions == 0)
        {
            possibleMoves.remove((Object) 2);
        }
        int returnInt = (int) (Math.random() * possibleMoves.size());
        return possibleMoves.get(returnInt);
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
    //Returns available Pokemon to switch to
    public ArrayList<Pokemon> returnSwitchAvailablePokemon (Player player)
    {
        ArrayList<Pokemon> availablePokemon = new ArrayList<>();
        for(int i = 0; i < player.team.length; i++)
        {            
            if(!player.team[i].equals(player.curr) && player.team[i].alive)
            {
                availablePokemon.add(player.team[i]);
            }
        }
        return availablePokemon;
    }
    //Switches Pokemon during the battle
    public String selectPokemon(Pokemon desiredPokemon) {
        if(!desiredPokemon.alive)
        {
            return Colors.RED_BOLD + "This Pokemon has fainted" + Colors.RESET;
        }
        for (Pokemon p: team) {
            if (desiredPokemon.name.equalsIgnoreCase(p.name)) {
                curr = p;
                return Colors.RED_BOLD + curr.name + ", I choose you!" + Colors.RESET;
            }
        }
        return "Null";
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
            switchPoke.equalsIgnoreCase(curr.name)) 
        {
            System.out.println(Colors.RED_BOLD + "Invalid!" + Colors.RESET);
            switchPoke = scan.nextLine();
        }
        System.out.println();
        return(selectPokemon(this.nameToPokemon(switchPoke)));
    }
    //When Cpu switches Pokemon
    public void cpuSwitch (ArrayList<Pokemon> pokemons)
    {
        int randPoke = (int) (Math.random() * pokemons.size());
        this.selectPokemon(pokemons.get(randPoke));
        System.out.println(Colors.RED_BOLD + "Thomas has switched to " + this.curr.name + Colors.RESET);
    }
    //Heal process
    public void healProcess ()
    {
        if(this.potions == 0)
        {
            System.out.println(Colors.RED_BOLD + this.name + " ran out of potions" + Colors.RESET);
        }
        else
        {
            int potionHealAmt = 3;
            this.curr.hp += potionHealAmt;
            if(this.curr.hp >  this.curr.maxHP) 
            {
                this.curr.hp = this.curr.maxHP;
            }
            potions--;
            System.out.println(Colors.BLUE_BOLD + this.name + " used a potion. " + this.curr.name + " gained " + potionHealAmt + " hp! " + 
                this.curr.name + " has " + this.curr.hp + " hp left. " + this.name + " has " + this.potions + " potions left." + Colors.RESET);
        }
    }
    //The Player battle
    public String playerBattle(Player other) throws Exception{
        int screenReset = 1;
        battleLoop:
        while (true)
        {
            //Beginning of round
            ArrayList<Pokemon> teamArrayList = returnAlive(this.team);
            System.out.println();
            System.out.println(Colors.CYAN_BOLD + this.name + " turn:" + Colors.RESET);
            System.out.println("Your current Pokemon is " + curr.name + " and it has " + curr.hp + " hp left. Thomas' "  
                + "current Pokemon is " + other.curr.name + " and it has " + other.curr.hp + " hp left.");
            System.out.println();
            System.out.println("What do you want to do? (Enter " + 
                Colors.RED_BOLD + "1 to switch Pokemon, " + Colors.RESET +
                Colors.BLUE_BOLD + "2 to heal, " + Colors.RESET + 
                Colors.GREEN_BOLD + "3 to battle)" + Colors.RESET);
            Scanner scan = new Scanner(System.in);
            String response = scan.nextLine();
            System.out.println();
            //Error Checking
            while(!choiceChecker(response) || 
            (this.potions == 0 && response.equals("2")) ||
            (returnSwitchAvailablePokemon(this).size() == 0 && response.equals("1"))) 
            {
                if(response.equals("2"))
                {
                    System.out.println(Colors.RED_BOLD + "You have run out of potions! Try something else." + 
                        "(Enter 1 to switch Pokemon, 2 to heal, 3 to battle)" + Colors.RESET);   
                }
                else if (response.equals("1"))
                {
                    System.out.println(Colors.RED_BOLD + "You have no Pokemon you can switch with! Try something else." + 
                    "(Enter 1 to switch Pokemon, 2 to heal, 3 to battle)" + Colors.RESET);
                }
                else
                {
                    System.out.println(Colors.RED_BOLD + "Invalid input, try again! (Enter 1 to switch Pokemon, 2 to heal, 3 to battle)"
                        + Colors.RESET);
                }
                response = scan.nextLine();
            }
            //Player Switches Pokemon
            if(response.equals("1"))
            {
                if(returnAlive(this.team).size() == 1)
                {
                    System.out.println(Colors.RED_BOLD + "No Pokemon available to switch to.\n" + Colors.RESET);
                }
                else
                {
                    System.out.println(playerSwitchProcess(this, teamArrayList));
                    System.out.println();
                }
                Thread.sleep(1000);
            }
            //Heals Pokemon
            if(response.equals("2"))
            {
                this.healProcess();
                System.out.println(); 
                Thread.sleep(1000);
            }
            //Player attack other Pokemon
            if(response.equals("3"))
            {
                Thread.sleep(500);
                curr.pokemonFight(other.curr); 
                //Checks if computer Pokemon fainted 
                if(!other.curr.alive)
                {
                    System.out.println(Colors.RED_BOLD + other.curr.name + " has fainted." + Colors.RESET);
                    //Checks for battle ending
                    if (!teamAlive(other)) 
                    {
                        Thread.sleep(1000);  
                        break battleLoop;
                    }
                    ArrayList<Pokemon> alivePokemon = returnAlive(other.team);
                    other.cpuSwitch(alivePokemon);
                    System.out.println();
                }   
                Thread.sleep(1000);  
            } 
            //CPU's Turn
            int cpuChoice = other.cpuBehavior();
            System.out.println(Colors.PURPLE_BOLD + "Thomas turn:" + Colors.RESET);
            System.out.println("Thomas's Pokemon is " + other.curr.name + " and it has " + other.curr.hp + " left\n");
            Thread.sleep(1000);
            //CPU switches
            if(cpuChoice == 1)
            {
                ArrayList<Pokemon> availableCPUPokemon = returnSwitchAvailablePokemon(other);
                other.cpuSwitch(availableCPUPokemon);
                Thread.sleep(700);
            } 
            //CPU heals
            if(cpuChoice == 2)
            {
                other.healProcess();
                Thread.sleep(700);
            }
            //CPU attacks
            if(cpuChoice == 3)
            {
                int randAttack = (int) (Math.random() * 4) ;
                other.curr.attack(this.curr, other.curr.moveSet.moveList[randAttack].name);
                if(!this.curr.alive)
                {
                    //Forces player to switch if their Pokemon faints
                    System.out.println();
                    System.out.println(Colors.RED_BOLD + "Your Pokemon has fainted" + Colors.RESET);
                    //Checks for battle ending
                    if (!teamAlive(this)) 
                    {
                        Thread.sleep(1000);  
                        break battleLoop;
                    }
                    System.out.println(playerSwitchProcess(this, teamArrayList));
                    System.out.println();   
                }
                Thread.sleep(700);
            }
            //Resets screen every two iterations
            if(screenReset == 2)
            {
                System.out.print("\033[H\033[2J");  
                System.out.print("\033[H\033[2J");
                System.out.flush();
                screenReset = 0;
            }
            screenReset = screenReset + 1;  
        }
        //End of game check 
        if (!teamAlive(this) && !teamAlive(other)) {
            return "You Tied! Do you want to try again? (type q if you are done, anything else to play again)";
        }
        else if (!teamAlive(other)) {
            return Colors.GREEN_BOLD + "Congratulations! You won! Do you want to play again? " 
                + "(type q if you are done, anything else to play again)" + Colors.RESET;
        }
        else {
            return Colors.RED_BOLD + "Oh No! You Lost! Do you want to try again? " 
                + "(type q if you are done, anything else to play again)" + Colors.RESET;
        }
    }
}