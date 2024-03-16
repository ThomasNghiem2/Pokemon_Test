/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow, GeeksForGeeks

This file is the main method that runs the game. 
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class sets up the game variables and runs the game, while
 *  checking that inputs are valid
 */
class Game {
    public static void main(String[] args) throws Exception{
        //Variables 
        String goForward = "";
        String playerName = "";
        String pokemonName = "";
        String playAgain = "";
        ArrayList<String> pokemonArray = new ArrayList<>() ;
        Scanner scan = new Scanner(System.in);
        String namesOfPokemon = "";
        Sound mySound = new Sound("pokemonSong.wav");
        mySound.play();
        //Reads Pokemon names
        Scanner sc = new Scanner(new File("PokemonNames.csv"));  
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext())  //returns a boolean value  
        {  
            String tempPokemon = sc.next();
            pokemonArray.add(tempPokemon);
            namesOfPokemon += tempPokemon + " ";
        }   
        sc.close();  //closes the scanner  
        //Play Game Loop
        while (!playAgain.equals("q")){
            //Game Setup
            while (!goForward.equals("c"))
            {
                System.out.println("Welcome to Pokemon Battle! What is your name?");
                playerName = scan.nextLine();
                System.out.println("Hi " + playerName + ", what Pokemon do you want to use?" + "\n" +
                "You can choose " + namesOfPokemon);
                outerloop:
                //Checks if Pokemon name is valid
                while (true)
                {
                    pokemonName = scan.nextLine();
                    for(int i = 0; i < pokemonArray.size(); i++)
                    {
                        if(pokemonName.equalsIgnoreCase(pokemonArray.get(i)))
                        {
                            pokemonName = pokemonArray.get(i);
                            break outerloop;
                        }
                    }
                    System.out.println("Invalid Pokemon, Try again");
                }
        
                System.out.println("Cool, " + pokemonName + " is a strong one. Are you ready? (type c if yes, anything else if no)");
                goForward = scan.nextLine();
            }
            Pokemon playerPokemon = new Pokemon(pokemonName);
            int randPokemon = (int) (Math.random() * 3);
            Pokemon computerPokemon = new Pokemon(pokemonArray.get(randPokemon));
            System.out.println("Your opponent is Thomas and his " + pokemonArray.get(randPokemon));
            String winner = playerPokemon.pokemonBattle(computerPokemon);
            //Outcomes
            if (winner.equals("player"))
            {
                System.out.println("Congratulations! You won! Do you want to play again? (type q if you are done, anything else to play again)");
            }
            else if(winner.equals("computer"))
            {
                System.out.println("Oh No! You Lost! Do you want to try again? (type q if you are done, anything else to play again)");
            }
            else if(winner.equals("tie"))
            {
                System.out.println("You Tied! Do you want to try again? (type q if you are done, anything else to play again)");
            }
            //Play Again
            playAgain = scan.nextLine();
            goForward = "continue";
            if(playAgain.equals("q"))
            {
                System.out.println("Thank you for playing");
                System.exit(0);
            }
    }
}
}