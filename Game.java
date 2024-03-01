import java.util.Scanner;
class Game {
    public static void main(String[] args) {
        String goForward = "";
        String playerName = "";
        String pokemonName = "";
        String playAgain = "";
        Scanner scan = new Scanner(System.in);
        String namesOfPokemon = "Charmander, Bulbasaur, or Squirtle";
        Sound mySound = new Sound("pokemonSong.wav");
        mySound.play();
        while (!playAgain.equals("q")){
            while (!goForward.equals("c"))
            {
                System.out.println("Welcome to Pokemon Battle! What is your name?");
                playerName = scan.nextLine();
                System.out.println("Hi " + playerName + ", what Pokemon do you want to use?" + "\n" +
                "You can choose " + namesOfPokemon);
                pokemonName = scan.nextLine();
                System.out.println("Cool, " + pokemonName + " is a strong one");
                System.out.println("Your opponent is Thomas and his Snorlax, are you ready? (type c if yes, anything else if no)");
                goForward = scan.nextLine();
            }
            Pokemon playerPokemon = new Pokemon(pokemonName);
            Pokemon computerPokemon = new Pokemon("Snorlax");
            String winner = playerPokemon.pokemonBattle(computerPokemon);
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
            playAgain = scan.nextLine();
            goForward = "Thomas Sucks cock";
            if(playAgain.equals("q"))
            {
                System.out.println("Thank you for playing");
                System.exit(0);
            }
            scan.close();
    }
}
}