/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow, GeeksForGeeks

This file creates all of the Pokemon in the game. 
*/
import java.util.Scanner;
/**
 * This class creates all of the Pokemon in the game
 */
public class Pokemon {
    String name;
    double hp;
    String type;
    MoveSet moveSet;
    //Creates Pokemon objects
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
        String snorlaxArt = 
        "                                   75221                                                           \n" + //
                        "                                   455546427                   1255257                             \n" + //
                        "                                  55555544664545555555521  15555555561                             \n" + //
                        "                                 7455555554444555555555556455555555563                             \n" + //
                        "                                 1555555555522222555555555555555555463                             \n" + //
                        "                                 5555555555552255555555555555555554663                             \n" + //
                        "                                75555555555555555555555555555555544691                             \n" + //
                        "                               122555552313455555555553354555555546693                             \n" + //
                        "                             725222421777771555555552777771255546666686421                         \n" + //
                        "                         7355544225777777777724444217777777773466666699666641                      \n" + //
                        "                      7455555552237777777777777227777777777711156666669666666662                   \n" + //
                        "                   7552222255555517777777777777777777777777111113966668666666655441                \n" + //
                        "                 15522222255554643777177777777777777777711111111159669966666645555541              \n" + //
                        "               3552222222555555495777133111177777777113333322311159699666666455555555427           \n" + //
                        "             3552555222255555555495117777777777111111111111111113969966666645555555555543          \n" + //
                        "           15555555555555555555555465111113211111111133111111112666666666445555555555555551        \n" + //
                        "          3644455555555555544444446942531133222311132521111112235666666644555555555555555554       \n" + //
                        "         2666666666666446666666641711133354511111111111112553333333466666644455555555555555543     \n" + //
                        "        266666666666666666699627777777111113333332555333333333333311126666666644455555555555555    \n" + //
                        "       296666666666666669664377777777777777111113333333111111111117777724666666666444444444444457  \n" + //
                        "       2466666666666666664377777777777777777777777777777777777777777777715669666666666666666666627 \n" + //
                        "        2222523372666666517777777777777777777777777777777777777777777777772466666666666666666666957\n" + //
                        "          17    36666662777777777777777777777777777777777777777777777777777266666666966666666666657\n" + //
                        "               75666665777777777777777777777777777777777777777777777777777774666666666617235442223 \n" + //
                        "               1966666777777777777777777777777777777777777777777777777777777766666666662  27       \n" + //
                        "               26666677777777777777777777777777777777777777777777777777777777166666669947          \n" + //
                        "               69666377777777777777777777777777777777777777777777777777777777766666699963          \n" + //
                        "               69966317777777777777777777777777777777777777777777777777777777726666699995          \n" + //
                        "      333    73729963111177777777777777777777777777777777777777777777777777777259996999427         \n" + //
                        "      371221141714963111111117777777777777777777777777777777777777777777711113372999992731         \n" + //
                        "    734112377155552633331111111111177777777777777777777777777777777771111111161112372311353   737  \n" + //
                        "1256517777777777777115333333111111111111111777777777777777777711111111111332215223177353221343717  \n" + //
                        " 31337777777777777711325333333333111111111111111111111111111111111333333332177777777777777732131   \n" + //
                        " 72217771133311777111132533333333333333333333333113111333331333333333333251177777777777777771227   \n" + //
                        "  1177342222255211111113543333333333333333333333333333333333333333333333431117777711111777777711   \n" + //
                        "  7177522222222555311113349423333333333333333333333333333333333333333334311111132552225537777711   \n" + //
                        "   13725555555544453113334969642333333333333333333333333333333333333246831133364455552225317712    \n" + //
                        "    7215444444444442311114996999664333333333333333333333333333333466696623333444444444555517137    \n" + //
                        "      1234444444444331112446644421   35533333333333333333333569966666669633324444444444465115      \n" + //
                        "        72225444521113257                 733255555552231     735446644232331444444444443353       \n" + //
                        "            3322255527                                                    3231125544533321         \n" + //
                        "                                                                            13233332337            ";

        if (str.equalsIgnoreCase("Charmander")) {
            this.name = "Charmander";
            this.hp = 10;
            this.type = "Fire";
            moveSet = new MoveSet("charmander");
            System.out.println(charmanderArt);
        }
        if (str.equalsIgnoreCase("Bulbasaur")) {
            this.name = "Bulbasaur";
            this.hp = 10;
            this.type = "Grass";
            moveSet = new MoveSet("bulbasaur");
            System.out.println(bulbasaurArt);
        }
        if (str.equalsIgnoreCase("Squirtle")) {
            this.name = "Squirtle";
            this.hp = 10;
            this.type = "Water";
            moveSet = new MoveSet("squirtle");
            System.out.println(squirtleArt);
        }
        if (str.equalsIgnoreCase("Snorlax")) {
            this.name = "Snorlax";
            this.hp = 15;
            this.type = "Normal";
            moveSet = new MoveSet("snorlax");
            System.out.println(snorlaxArt);
        }
    }
    //Pokemon attacks another Pokemon
    public void attack(Pokemon otherPokemon, String move) {
        int invalid = -1;
        int attackNumber = -1;
        for(int i = 0; i < moveSet.moveList.length; i++)
        {
            if(move.equalsIgnoreCase(moveSet.moveList[i].toString()))
            {
                invalid = 1;
                attackNumber = i;
            }
        }
        if(invalid == -1)
        {
            return;
        }
        double damage = moveSet.moveList[attackNumber].attack;
        double multiplier = checkTyping(moveSet.moveList[attackNumber], otherPokemon);
        String multiplierText = "";
        if(multiplier == 1.2)
        {
            multiplierText = "It was super effective!";
        }
        if(multiplier == 0.8)
        {
            multiplierText = "It was not effective.";
        }
        damage = Math.round(damage * multiplier * 10.0) / 10.0;
        otherPokemon.hp -= damage;
        otherPokemon.hp = Math.round(otherPokemon.hp * 10.0) / 10.0;
        //Doesn't allow negative numbers
        if (this.hp < 0) {
            this.hp = 0;
        }
        if (otherPokemon.hp < 0) {
            otherPokemon.hp = 0;
        }
        System.out.println(this.name + " used " + moveSet.moveList[attackNumber].name + " against " + 
        otherPokemon.name + "\n" + otherPokemon.name + " took " + damage + " damage and has " + 
        otherPokemon.hp + " hp left. " + multiplierText);
    }
    //Checks for any type advantages
    public double checkTyping(Move move, Pokemon pokemon)
    {
        String[] arrayTypes = {"Fire", "Grass", "Water"};
        for(int i = 0; i < arrayTypes.length; i++)
        {
            if(move.type.equalsIgnoreCase(arrayTypes[i]) && 
            pokemon.type.equalsIgnoreCase(arrayTypes[(i+1) % 3]))
            {
                return 1.2;
            }
            if(pokemon.type.equalsIgnoreCase(arrayTypes[i]) && 
            move.type.equalsIgnoreCase(arrayTypes[(i+1) % 3]))
            {
                return 0.8;
            }
        }
        return 1;
    }
    //Conducts a Pokemon battle
    public String pokemonBattle(Pokemon otherPokemon) {
        java.util.Scanner scan = new Scanner(System.in);
        while (this.hp > 0 && otherPokemon.hp > 0) {
            System.out.println();
            System.out.println("What move do you want to use?");
            System.out.println("Your moves are " + this.moveSet.moveList[0] + ", " 
            + this.moveSet.moveList[1] + ", " + this.moveSet.moveList[2] + ", " 
            + this.moveSet.moveList[3]);
            String playerMove = scan.nextLine();
            System.out.println();
            while (checkMoveValid(playerMove) == false) {
                System.out.println("Invalid move, try again. Enter valid move \n");
                playerMove = scan.nextLine();
                System.out.println();
            }
            this.attack(otherPokemon, playerMove);
            System.out.println();
            int randAttack = (int) (Math.random() * 4) ;
            otherPokemon.attack(this, otherPokemon.moveSet.moveList[randAttack].name);
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
    //Checks that all moves are valid
    public boolean checkMoveValid(String move) {
        return move.equalsIgnoreCase(moveSet.moveList[0].name) || move.equalsIgnoreCase(moveSet.moveList[1].name) ||
            move.equalsIgnoreCase(moveSet.moveList[2].name) || move.equalsIgnoreCase(moveSet.moveList[3].name);
    }
}