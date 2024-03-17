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
        String pokemonName1, pokemonName2, pokemonName3 = "";
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
                System.out.print("\nHi " + playerName + 
                    ", what Pokemon do you want to use? (choose 3 Pokemon, press Enter after each one)"
                     + "\n" + "You can choose");
                for(int i = 0; i < pokemonArray.size(); i++)
                {
                    System.out.print(" " + pokemonArray.get(i));
                }
                System.out.println();
                pokemonName1 = scan.nextLine();
                while (!Pokemon.checkPokeName(pokemonName1,pokemonArray))
                {
                    System.out.println("\nInvalid Pokemon 1, Try again");
                    pokemonName1 = scan.nextLine();
                }
                System.out.println("\nPerfect, what's your next Pokemon?");
                pokemonName2 = scan.nextLine();
                while (!Pokemon.checkPokeName(pokemonName2,pokemonArray))
                {
                    System.out.println("\nInvalid Pokemon 2, Try again");
                    pokemonName2 = scan.nextLine();
                }
                System.out.println("\nPerfect, what's your next Pokemon?");
                pokemonName3 = scan.nextLine();
                while (!Pokemon.checkPokeName(pokemonName3,pokemonArray))
                {
                    System.out.println("\nInvalid Pokemon 3, Try again");
                    pokemonName3 = scan.nextLine();
                }
                pokemonName1 = pokemonName1.substring(0,1).toUpperCase()
                + pokemonName1.substring(1);
                pokemonName2 = pokemonName2.substring(0,1).toUpperCase()
                + pokemonName2.substring(1);
                pokemonName3 = pokemonName3.substring(0,1).toUpperCase()
                + pokemonName3.substring(1);
                break setup;
            }
            Pokemon playerPokemon1 = new Pokemon(pokemonName1);
            Pokemon playerPokemon2 = new Pokemon(pokemonName2);
            Pokemon playerPokemon3 = new Pokemon(pokemonName3);
            Player player = new Player(playerName, playerPokemon1, playerPokemon2, playerPokemon3);
            System.out.println("Cool, your team of " + player.printTeam() + " is a strong one.");
            int randPokemon1 = (int) (Math.random() * 3);
            int randPokemon2 = (int) (Math.random() * 3);
            int randPokemon3 = (int) (Math.random() * 3);
            Pokemon computerPokemon1 = new Pokemon(pokemonArray.get(randPokemon1));
            Pokemon computerPokemon2 = new Pokemon(pokemonArray.get(randPokemon2));
            Pokemon computerPokemon3 = new Pokemon(pokemonArray.get(randPokemon3));
            Player cpPlayer = new Player("Thomas", computerPokemon1, computerPokemon2, computerPokemon3);
            System.out.println("Your opponent is Thomas and his team of " + cpPlayer.printTeam());
            System.out.println(player.playerBattle(cpPlayer));
            //Play Again
            if(scan.nextLine().equals("q"))
            {
                System.out.println("Thank you for playing");
                System.exit(0);
            }
    }
}
}