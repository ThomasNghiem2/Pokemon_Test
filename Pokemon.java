import java.util.Scanner;
import java.lang.Math;

public class Pokemon {
    String name;
    int hp;
    String type;

    public Pokemon(String str) {
        String charmanderArt = 
        "              _.--\"\"`-..\r\n" + //
                        "            ,'          `.\r\n" + //
                        "          ,'          __  `.\r\n" + //
                        "         /|          \" __   \\\r\n" + //
                        "        , |           / |.   .\r\n" + //
                        "        |,'          !_.'|   |\r\n" + //
                        "      ,'             '   |   |\r\n" + //
                        "     /              |`--'|   |\r\n" + //
                        "    |                `---'   |\r\n" + //
                        "     .   ,                   |                       ,\".\r\n" + //
                        "      ._     '           _'  |                    , ' \\ `\r\n" + //
                        "  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\r\n" + //
                        "  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\r\n" + //
                        "-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\r\n" + //
                        "  `,         \"\"\"\"'     `.              ,'         |   |  ',,\r\n" + //
                        "    `.      '            '            /          '    |'. |/\r\n" + //
                        "      `.   |              \\       _,-'           |       ''\r\n" + //
                        "        `._'               \\   '\"\\                .      |\r\n" + //
                        "           |                '     \\                `._  ,'\r\n" + //
                        "           |                 '     \\                 .'|\r\n" + //
                        "           |                 .      \\                | |\r\n" + //
                        "           |                 |       L              ,' |\r\n" + //
                        "           `                 |       |             /   '\r\n" + //
                        "            \\                |       |           ,'   /\r\n" + //
                        "          ,' \\               |  _.._ ,-..___,..-'    ,'\r\n" + //
                        "         /     .             .      `!             ,j'\r\n" + //
                        "        /       `.          /        .           .'/\r\n" + //
                        "       .          `.       /         |        _.'.'\r\n" + //
                        "        `.          7`'---'          |------\"'_.'\r\n" + //
                        "       _,.`,_     _'                ,''-----\"'\r\n" + //
                        "   _,-_    '       `.     .'      ,\\\r\n" + //
                        "   -\" /`.         _,'     | _  _  _.|\r\n" + //
                        "    \"\"--'---\"\"\"\"\"'        `' '! |! /\r\n" + //
                        "                            `\" \" -'";

        String bulbasaurArt = 
        "                                           /\r\n" + //
                        "                        _,.------....___,.' ',.-.\r\n" + //
                        "                     ,-'          _,.--\"        |\r\n" + //
                        "                   ,'         _.-'              .\r\n" + //
                        "                  /   ,     ,'                   `\r\n" + //
                        "                 .   /     /                     ``.\r\n" + //
                        "                 |  |     .                       \\.\\\r\n" + //
                        "       ____      |___._.  |       __               \\ `.\r\n" + //
                        "     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\\r\n" + //
                        "    .  ,            __               `              |   .\r\n" + //
                        "    `,'         ,-\"'  .               \\             |    L\r\n" + //
                        "   ,'          '    _.'                -._          /    |\r\n" + //
                        "  ,`-.    ,\".   `--'                      >.      ,'     |\r\n" + //
                        " . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'\r\n" + //
                        " ||:, .           ,'  ;  /  / \\ `        `.    .      .'/\r\n" + //
                        " j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /\r\n" + //
                        "/ L:_  |                 .  \"' :_;                `.'.'\r\n" + //
                        ".    \"\"'                  \"\"\"\"\"'                    V\r\n" + //
                        " `.                                 .    `.   _,..  `\r\n" + //
                        "   `,_   .    .                _,-'/    .. `,'   __  `\r\n" + //
                        "    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .\r\n" + //
                        "   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |\r\n" + //
                        "  .   _  `\"\"'--.._____..--\"   ,             '         |\r\n" + //
                        "  | .\" `. `-.                /-.           /          ,\r\n" + //
                        "  | `._.'    `,_            ;  /         ,'          .\r\n" + //
                        " .'          /| `-.        . ,'         ,           ,\r\n" + //
                        " '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'\r\n" + //
                        " `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--'";

        String squirtleArt = 
        "               _,........__\r\n" + //
                        "            ,-'            \"`-.\r\n" + //
                        "          ,'                   `-.\r\n" + //
                        "        ,'                        \\\r\n" + //
                        "      ,'                           .\r\n" + //
                        "      .'\\               ,\"\".       `\r\n" + //
                        "     ._.'|             / |  `       \\\r\n" + //
                        "     |   |            `-.'  ||       `.\r\n" + //
                        "     |   |            '-._,'||       | \\\r\n" + //
                        "     .`.,'             `..,'.'       , |`-.\r\n" + //
                        "     l                       .'`.  _/  |   `.\r\n" + //
                        "     `-.._'-   ,          _ _'   -\" \\  .     `\r\n" + //
                        "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\r\n" + //
                        ".'        `\"-..___      __,'\\          \\  \\     \\\r\n" + //
                        "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\r\n" + //
                        "  `.          |              `.          |  .     L\r\n" + //
                        "    `.        |`--...________.'.        j   |     |\r\n" + //
                        "      `._    .'      |          `.     .|   ,     |\r\n" + //
                        "         `--,\\       .            `7\"\"' |  ,      |\r\n" + //
                        "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\r\n" + //
                        "             \\ `.     .          /      |  '      |  ,'          `.\r\n" + //
                        "              \\  v.__  .        '       .   \\    /| /              \\\r\n" + //
                        "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\r\n" + //
                        "                `        .        `._ ___,j.  `/ .-       ,---.     |\r\n" + //
                        "                ,`-.      \\         .\"     `.  |/        j     `    |\r\n" + //
                        "               /    `.     \\       /         \\ /         |     /    j\r\n" + //
                        "              |       `-.   7-.._ .          |\"          '         /\r\n" + //
                        "              |          `./_    `|          |            .     _,'\r\n" + //
                        "              `.           / `----|          |-............`---'\r\n" + //
                        "                \\          \\      |          |\r\n" + //
                        "               ,'           )     `.         |\r\n" + //
                        "                7____,,..--'      /          |\r\n" + //
                        "                                  `---.__,--.'";

        if (!str.equalsIgnoreCase("Charmander") &&
            !str.equalsIgnoreCase("Bulbasaur") &&
            !str.equalsIgnoreCase("Squirtle") &&
            !str.equalsIgnoreCase("Snorlax")) {
            System.out.println("Not a valid Pokemon");
            return;
        }
        if (str.equalsIgnoreCase("Charmander")) {
            this.name = "Charmander";
            this.hp = 10;
            this.type = "fire";
            System.out.println(charmanderArt);
        }
        if (str.equalsIgnoreCase("Bulbasaur")) {
            this.name = "Bulbasaur";
            this.hp = 10;
            this.type = "grass";
            System.out.println(bulbasaurArt);
        }
        if (str.equalsIgnoreCase("Squirtle")) {
            this.name = "Squirtle";
            this.hp = 10;
            this.type = "water";
            System.out.println(squirtleArt);
        }
        if (str.equalsIgnoreCase("Snorlax")) {
            this.name = "Snorlax";
            this.hp = 20;
            this.type = "normal";
        }
    }

    public void attack(Pokemon otherPokemon, String move) {
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;

        otherPokemon.hp -= rand;
        if (this.hp < 0) {
            this.hp = 0;
        }
        if (otherPokemon.hp < 0) {
            otherPokemon.hp = 0;
        }
        System.out.println(this.name + " used " + move + " against " + otherPokemon.name + 
                "\n" + otherPokemon.name + " took " + rand + " damage and has " + otherPokemon.hp +
                " left ");
    }

    public String pokemonBattle(Pokemon otherPokemon) {
        java.util.Scanner scan = new Scanner(System.in);
        while (this.hp > 0 && otherPokemon.hp > 0) {
            System.out.println();
            System.out.println("What move do you want to use?");
            String playerMove = scan.nextLine();
            this.attack(otherPokemon, playerMove);
            System.out.println();
            otherPokemon.attack(this, "Belly Drum");
        }
        if (this.hp == 0 && otherPokemon.hp == 0) {
            return "tie";
        }
        else if (otherPokemon.hp == 0) {
            return "player";
        }
        else {
            return "computer";
        }
    }
}