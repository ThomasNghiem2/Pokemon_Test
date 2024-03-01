import java.util.Scanner;
class Game {
    public static void main(String[] args) {
        String goForward = "";
        String playerName = "";
        String pokemonName = "";
        String playAgain = "";
        Scanner scan = new Scanner(System.in);
        while (!playAgain.equals("q")){
            while (!goForward.equals("c"))
            {
            System.out.println("Welcome to Pokemon Battle! What is your name?");
            playerName = scan.nextLine();
            System.out.println("Hi " + playerName + ", what Pokemon do you want to use?");
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
            System.out.println("Congratulations! You won! Do you want to play again? (type y if you want to play again, anything else if you are done)");
        }
        else if(winner.equals("computer"))
        {
            System.out.println("Oh No! You Lost! Do you want to try again? (type y if you want to play again, anything else if you are done)");
        }
        playAgain = scan.nextLine();
        goForward = "Thomas Sucks cock";
        if(playAgain.equals("q"))
        {
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }
}
}