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
        //Variables and Objects 
        String playerName = "";
        String pokemonName = "";
        ArrayList<String> pokemonArray = new ArrayList<>() ;
        Scanner scan = new Scanner(System.in);
        Sound mySound = new Sound("pokemonSong.wav");
        //Reads Pokemon names
        Scanner sc = new Scanner(new File("PokemonNames.csv"));  
        sc.useDelimiter(",");  
        while (sc.hasNext())   
        {  
            String tempPokemon = sc.next();
            pokemonArray.add(tempPokemon);
        }   
        sc.close();
        mySound.play();  
        //Play Game Loop
        while (true){
            //Game Setup
            setup:
            while (true)
            {
                System.out.println("Welcome to Pokemon Battle! What is your name?");
                playerName = scan.nextLine();
                System.out.print("\nHi " + playerName + ", what Pokemon do you want to use?" + "\n" +
                "You can choose");
                for(int i = 0; i < pokemonArray.size(); i++)
                {
                    System.out.print(" " + pokemonArray.get(i));
                }
                System.out.println();
                pokemonName = scan.nextLine();
                //Checks if Pokemon name is valid
                while (!Pokemon.checkPokeName(pokemonName,pokemonArray))
                {
                    System.out.println("\nInvalid Pokemon, Try again");
                    pokemonName = scan.nextLine();
                }
                pokemonName = pokemonName.substring(0,1).toUpperCase()
                + pokemonName.substring(1);
                System.out.println("Cool, " + pokemonName + " is a strong one.");
                break setup;
            }
            Pokemon playerPokemon = new Pokemon(pokemonName);
            int randPokemon = (int) (Math.random() * 3);
            Pokemon computerPokemon = new Pokemon(pokemonArray.get(randPokemon));
            System.out.println("Your opponent is Thomas and his " + pokemonArray.get(randPokemon));
            System.out.println(playerPokemon.pokemonBattle(computerPokemon));
            //Play Again
            if(scan.nextLine().equals("q"))
            {
                System.out.println("Thank you for playing");
                System.exit(0);
            }
    }
}
}