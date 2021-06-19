package com.example.senior_project;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;
import java.util.Scanner;

public class Game implements Serializable {
    //game class variables
    //players
    private Player Human1;
    private Player Human2;
    private Player Computer;
    //player vector
    private Vector<Player> players;
    private int playerIndex;
    //passthrough for ordering events
    private int passthrough;
    //game info
    private String info;
    //trun counter
    private int Turn;

    /*
	NAME:
	    Game
	SYNOPSIS:
	    Game constructor
	DESCRIPTION:
	    Default constructor for the Game object
	RETURNS:
	    none
*/
    public Game() {

        this.Human1 = new Player();
        this.Human2 = new Player();
        this.Computer = new Player();
        this.players = new Vector();
        playerIndex = 0;
        passthrough = 0;
        this.Turn = 2;
        info = "";
    }

    /*
	NAME:
	    getInfo
	SYNOPSIS:
	    returns info string
	DESCRIPTION:
	    returns the info that has happened so far in the game
	RETURNS:
	    string info - info of game
*/
    public String getInfo() {
        return info;
    }

    /*
	NAME:
	    getHuman1
	SYNOPSIS:
	    returns human1
	DESCRIPTION:
	    return human1 who is always player 1
	RETURNS:
	    Player Human1 - player in the game
*/
    public Player getHuman1() {
        return Human1;
    }

    /*
	NAME:
	    getPlayerIndex
	SYNOPSIS:
	    returns playerIndex
	DESCRIPTION:
	    returns the current index in the player vector
	RETURNS:
	    int playerIndex - index in player vector
*/
    public int getPlayerIndex() {
        return playerIndex;
    }

/*
	NAME:
	    getHuman2
	SYNOPSIS:
	    returns Human2
	DESCRIPTION:
	    returns player object Human2 which is only used for when the user wants to play against another human
	RETURNS:
	    Player Human2 - human player 2
*/
    public Player getHuman2() {
        return Human2;
    }

    /*
	NAME:
	    getComputer
	SYNOPSIS:
	    returns Computer
	DESCRIPTION:
	    returns Computer object which is only used for when player wants to play against a computer
	RETURNS:
	    Player Computer - computer player 2
*/
    public Player getComputer() {
        return Computer;
    }

    /*
	NAME:
	    getPlayerAtIndex
	SYNOPSIS:
	    return Player at a specific index in player vector
	DESCRIPTION:
	    takes the index given and returns the player in that index in the player vector
	RETURNS:
	    Player object at index x
*/
    public Player getPlayerAtIndex(int index) {
        return players.get(index);
    }

    /*
	NAME:
	    getPassthough
	SYNOPSIS:
	    return passthrough variable
	DESCRIPTION:
	    returns passthrough which is used for ordering events in the battle
	RETURNS:
	    int passthrough
*/
    public int getPassthrough() {
        return passthrough;
    }

    /*
	NAME:
	    setPlayerIndex
	SYNOPSIS:
	    sets the player index
	DESCRIPTION:
	    take in index and sets that to the playerIndex for the player vector
	RETURNS:
	    none
*/
    public void setPlayerIndex(int inIndex) {
        playerIndex = inIndex;
    }

    /*
	NAME:
	    setInfo
	SYNOPSIS:
	    concats string to the info string
	DESCRIPTION:
	    take the incoming sting and concats that to the info string and also adds a new line
	RETURNS:
	    none
*/
    public void setInfo(String inInfo) {
        info = info.concat(inInfo + "\n");
    }

    /*
	NAME:
	    setPassthrough
	SYNOPSIS:
	    sets passthrough to inIndex
	DESCRIPTION:
	    sets the passthrough to the incoming index
	RETURNS:
	    none
*/
    public void setPassthrough(int inIndex) {
        passthrough = inIndex;
    }

    /*
	NAME:
	    addPlayer
	SYNOPSIS:
	    adds player to player vector
	DESCRIPTION:
	    adds a player to the players vector for the game
	RETURNS:
	    none
*/
    public void addPlayers(Player inPlayer) {
        players.add(inPlayer);
    }

    /*
	NAME:
	    parsePokemon
	SYNOPSIS:
	    parse pokemon info into a pokemon object
	DESCRIPTION:
	    reads pokemon from text file and enters it to the pokemon object and then adds it to the players pokemon vector
	RETURNS:
	    none
*/
    public void parsePokemon(DataInputStream textFileStream) throws IOException {
        Vector<String> stringPokemon = players.get(playerIndex).getStringPokemon();
        for (int i = 0; i < stringPokemon.size(); i++) {
            Scanner sc = new Scanner(textFileStream);
            Pokemon setPokemon = new Pokemon();
            players.get(playerIndex).addPokemon(setPokemon);
            String currentPokemon = stringPokemon.get(i);
            while (sc.hasNext()) {
                String oneLine = sc.nextLine();
                if (oneLine.contains(currentPokemon)) {
                    players.get(playerIndex).getPokemonAtIndex(i).setName(oneLine);
                    for(int j = 0; j <= 10; j++)
                    {
                        if (oneLine.contains("type1")) {
                            players.get(playerIndex).getPokemonAtIndex(i).setType1(parseWord(oneLine));
                        }
                        else if (oneLine.contains("type2")) {
                            players.get(playerIndex).getPokemonAtIndex(i).setType2(parseWord(oneLine));
                        }
                        else if (oneLine.contains("hp")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setHp(number);
                            players.get(playerIndex).getPokemonAtIndex(i).setTotalHp(number);
                        }
                        else if (oneLine.contains("attack")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setAttack(number);
                        }
                        else if (oneLine.contains("defense")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setDefense(number);
                        }
                        else if (oneLine.contains("specialAttack")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setSpecialAttack(number);
                        }
                        else if (oneLine.contains("specialDefense")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setSpecialDefense(number);
                        }
                        else if (oneLine.contains("speed")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            players.get(playerIndex).getPokemonAtIndex(i).setSpeed(number);
                        }
                        else if (oneLine.contains("weakness")) {
                            String temp = oneLine;
                            players.get(playerIndex).getPokemonAtIndex(i).setWeakness(parseTypes(oneLine));
                        }
                        else if (oneLine.contains("strength")) {
                            String temp = oneLine;
                            players.get(playerIndex).getPokemonAtIndex(i).setStrength(parseTypes(oneLine));
                        }
                        if(sc.hasNext())
                        {
                            oneLine = sc.nextLine();
                        }
                    }
                    break;
                }
            }
            textFileStream.reset();
        }
    }

    /*
	NAME:
	    parseMoves
	SYNOPSIS:
	    parse move info into move object
	DESCRIPTION:
	    parse move from text file and enters it into the pokemon given in the players pokemon vector
	RETURNS:
	    none
*/
    public void parseMoves(Vector<String> stringMoves, Pokemon inPokemon, DataInputStream textFileStream) throws IOException {

        for (int i = 0; i < stringMoves.size(); i++) {
            Scanner sc = new Scanner(textFileStream);
            String currentMove = stringMoves.get(i);
            Move move = new Move();
            inPokemon.addMove(move);
            while (sc.hasNext()) {
                String oneLine = sc.nextLine();
                if (oneLine.contains(currentMove)) {
                    inPokemon.getMoveAtIndex(i).setName(oneLine);
                    for(int j =0 ; j<=6; j++)
                    {
                        if (oneLine.contains("type :")) {
                            String temp = oneLine;
                            inPokemon.getMoveAtIndex(i).setType(parseWord(temp));
                        }
                        else if (oneLine.contains("category :")) {
                            String temp = oneLine;
                            inPokemon.getMoveAtIndex(i).setCategory(parseWord(temp));
                        }
                        else if (oneLine.contains("power :")) {
                                String temp = oneLine;
                                int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                                inPokemon.getMoveAtIndex(i).setPower(number);
                        }
                        else if (oneLine.contains("accuracy :")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            inPokemon.getMoveAtIndex(i).setAccuracy(number);
                        }
                        else if (oneLine.contains("pp :")) {
                            String temp = oneLine;
                            int number = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
                            inPokemon.getMoveAtIndex(i).setPP(number);
                        }
                        else if (oneLine.contains("info :")) {
                            String temp = oneLine;
                            inPokemon.getMoveAtIndex(i).setInfo(parseWord(temp));
                        }

                        if(sc.hasNext())
                        {
                            oneLine = sc.nextLine();
                        }
                    }
                    break;
                }
            }
            textFileStream.reset();
        }
    }

    /*
	NAME:
	    parseTypes
	SYNOPSIS:
	    parses pokemon's weaknesses and strengths
	DESCRIPTION:
	    takes line with pokemon's strength or weakness and puts it into an vector of pokemon types to return
	RETURNS:
	    Vector<String> types - pokemon types
*/
    public Vector<String> parseTypes(String oneLine) {
        Vector<String> types = new Vector();
        String[] words = oneLine.split(" ");

        for (int i = 1; i < words.length; i++) {
            if (words[i].equals("\\s") || words[i].equals("") || words[i].equals("weakness") || words[i].equals("strength") || words[i].equals(":")) {
                continue;
            }
            types.add(words[i]);
        }

        return types;
    }

    /*
	NAME:
	    parseWord
	SYNOPSIS:
	    parses a single word
	DESCRIPTION:
	    parses a pokemon's type or a moves type or status effect
	RETURNS:
	    String word - Pokemon/Move type
*/
    public String parseWord(String oneLine) {
        String word = "";
        String[] words = oneLine.split(" ");

        for (int i = 1; i < words.length; i++) {
            if (words[i].equals("\\s") || words[i].equals("") || words[i].equals("type") || words[i].equals("category") || words[i].equals(":") || words[i].equals("type1") || words[i].equals("type2") || words[i].equals("info")) {
                continue;
            }
            word = words[i];
        }

        return word;
    }

    /*
	NAME:
	    saveTurn
	SYNOPSIS:
	    saves the option made by a player
	DESCRIPTION:
	    saves the option of the player to attack or switch as a boolean (swap) and depending on that sets the players pokemonIndex or moveIndex for that turn
	RETURNS:
	    none
*/
    public void saveTurn(boolean swap, int index) {

        if (passthrough == 0) {
            //save player ones move (attack - > index of the move being picked or switch - > index of what pokemon to switch)
            players.get(playerIndex).setSwapPokemon(swap);
            if (swap == true) {
                players.get(playerIndex).setPokemonIndex(index);
            } else if (swap == false) {
                players.get(playerIndex).setMoveIndex(index);
            }
        }
        if (passthrough == 1) {
            //save player twos move (attack or switch)
            players.get(playerIndex).setSwapPokemon(swap);
            if (swap == true) {
                players.get(playerIndex).setPokemonIndex(index);
            } else if (swap == false) {
                players.get(playerIndex).setMoveIndex(index);
            }
            executeTurn();
        }
    }

    /*
	NAME:
	    executeTurn
	SYNOPSIS:
	    executes a single turn in a battle
	DESCRIPTION:
	    depending on the choices the players made the turn either switches a players pokemon out or has their pokemon attack
	    switching pokemon always goes before attacking
	RETURNS:
	    none
*/
    private void executeTurn()
    {
        String outcome = "";

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Pokemon player1Pokemon = player1.getPokemonAtIndex(player1.getPokemonIndex());
        Pokemon player2Pokemon = player2.getPokemonAtIndex(player2.getPokemonIndex());

        //see if anyone swapped pokemon and execute (highest priority)
        //if yes then execute the swap (if both swap just do player 1 first then player 2)
        if (player1.getSwapPokemon() == true)
        {
            outcome = outcome.concat("Player 1 switched out to " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + "\n");
            player1Pokemon = player1.getPokemonAtIndex(player1.getPokemonIndex());
        }
        if (player2.getSwapPokemon() == true)
        {
            outcome = outcome.concat("Player 2 switched out to " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + "\n");
            player2Pokemon = player2.getPokemonAtIndex(player2.getPokemonIndex());
        }

        info = info.concat(outcome);

        //check speed of each pokemon
        //who ever has the highest speed attacks first
        //execute first attack
        //set damages and status conditions
        if (player1.getSwapPokemon() == false && player2.getSwapPokemon() == false)
        {
            calculateAttack(player1Pokemon, player2Pokemon, calculateSpeed(player1Pokemon, player2Pokemon));
        }
        else if (player1.getSwapPokemon() == false)
        {
            calculateAttack(player1Pokemon, player2Pokemon, 3);
        }
        else if(player2.getSwapPokemon() == false)
        {
            calculateAttack(player1Pokemon, player2Pokemon, 4);
        }

        //check status damage to both pokemon with player 1 going first
        calculateStatusDamage(player1);
        calculateStatusDamage(player2);
        info = info.concat("----------------Turn " + Turn + " ----------------" + "\n");
        Turn++;
    }

    /*
	NAME:
	    calculateSpeed
	SYNOPSIS:
	    sees which pokemon is faster
	DESCRIPTION:
	    compares the speeds of each pokemon
	    whoever has a larger speed stat goes first
	    if equal then it is random
	RETURNS:
	    none
*/
    private int calculateSpeed(Pokemon player1Pokemon,Pokemon player2Pokemon)
    {
        //return 1 if player 1 attacks first, 2 if player 2, and 3 if speeds are equal
        int speed1 = player1Pokemon.getSpeed();
        int speed2 = player2Pokemon.getSpeed();

        if(speed1 > speed2)
        {
            return 1;
        }
        if (speed1 < speed2)
        {
            return 2;
        }
        if(speed1 == speed2) {
            Random rnad = new Random();
            int random = rnad.nextInt(2);
            if (random == 0) {
                return 1;
            } else if (random == 1)
            {
                return 2;
            }
        }

        return 0;
    }

    /*
	NAME:
	    calculateAttack
	SYNOPSIS:
	    calculates which pokemon's attack will go first
	DESCRIPTION:
	    based on who attacks first the move is executed and damage is calculated
	    if defending pokemon goes down then they are not able to attack and need to be switched out and the turn ends
	    if not then defending pokemon gets a chance to attack
	RETURNS:
	    none
*/
    private void calculateAttack(Pokemon player1Pokemon,Pokemon player2Pokemon,int option)
    {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Move move = new Move();

        //player1 attacks first
        if(option == 1)
        {
            //check if move is status move or attacking move
            move = player1.getPokemonAtIndex(player1.getPokemonIndex()).getMoveAtIndex(player1.getMoveIndex());
            info = info.concat("[Player 1] " + player1Pokemon.getName() + " used " + player1Pokemon.getMoveAtIndex(player1.getMoveIndex()).getName() + "!" + "\n");
            if(move.getCategory().equals("status"))
            {
                applyStatus(player1,player2);
            }
            else {
                if(calculateAccuracy(player1,player2))
                {
                    int hp = player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp();
                    int dmg = calculateDamage(player1Pokemon, player2Pokemon, move);
                    info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                    hp = hp - dmg;
                    player2.getPokemonAtIndex(player2.getPokemonIndex()).setHp(hp);
                    //check if defending pokemon is down
                    if (player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp() <= 0)
                    {
                        info = info.concat("[player 2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " fainted!" + "\n");
                    }
                }
                else
                {
                    info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " missed its attack" + "\n");
                }
            }

            if(player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp() > 0)
            {
                //defending pokemon now attacks
                move = player2.getPokemonAtIndex(player2.getPokemonIndex()).getMoveAtIndex(player2.getMoveIndex());
                info = info.concat("[Player 2] " + player2Pokemon.getName() + " used " + player2Pokemon.getMoveAtIndex(player2.getMoveIndex()).getName() + "!" + "\n");
                if(move.getCategory().equals("status"))
                {
                    applyStatus(player2,player1);
                }
                else {
                    if(calculateAccuracy(player2,player1)) {
                        int hp = player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp();
                        int dmg = calculateDamage(player2Pokemon, player1Pokemon, move);
                        info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                        hp = hp - dmg;
                        player1.getPokemonAtIndex(player1.getPokemonIndex()).setHp(hp);
                        //check if all pokemon are down
                        if (player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp() <= 0)
                        {
                            info = info.concat("[player 1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " fainted!" + "\n");
                        }
                    }
                    else
                    {
                        info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " missed its attack" + "\n");
                    }
                }
            }


        }

        //player2 attacks first
        else if (option == 2)
        {
            //attacker attacks
            move = player2.getPokemonAtIndex(player2.getPokemonIndex()).getMoveAtIndex(player2.getMoveIndex());
            info = info.concat("[Player 2] " + player2Pokemon.getName() + " used " + player2Pokemon.getMoveAtIndex(player2.getMoveIndex()).getName() + "!" + "\n");
            if(move.getCategory().equals("status"))
            {
                applyStatus(player2,player1);
            }
            else {
                if(calculateAccuracy(player2,player1))
                {
                    int hp = player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp();
                    int dmg = calculateDamage(player2Pokemon, player1Pokemon, move);
                    info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                    hp = hp - dmg;
                    player1.getPokemonAtIndex(player1.getPokemonIndex()).setHp(hp);
                    if (player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp() <= 0) {
                        info = info.concat("[player 1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " fainted!" + "\n");
                    }
                }
                else
                {
                    info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " missed its attack" + "\n");
                }
            }

            //defender attacks
            if(player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp() > 0)
            {
                move = player1.getPokemonAtIndex(player1.getPokemonIndex()).getMoveAtIndex(player1.getMoveIndex());
                info = info.concat("[Player 1] " + player1Pokemon.getName() + " used " + player1Pokemon.getMoveAtIndex(player1.getMoveIndex()).getName() + "!" + "\n");
                if(move.getCategory().equals("status"))
                {
                    applyStatus(player1,player2);
                }
                else {
                    if(calculateAccuracy(player1,player2))
                    {
                        int hp = player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp();
                        int dmg = calculateDamage(player1Pokemon, player2Pokemon, move);
                        info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                        hp = hp - dmg;
                        player2.getPokemonAtIndex(player2.getPokemonIndex()).setHp(hp);
                        //check if defending pokemon is down
                        if (player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp() <= 0)
                        {
                            info = info.concat("[player 2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " fainted!" + "\n");
                        }
                    }
                    else
                    {
                        info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " missed its attack" + "\n");
                    }
                }
            }
        }

        //only player 1 attacks
        else if (option == 3)
        {
            move = player1.getPokemonAtIndex(player1.getPokemonIndex()).getMoveAtIndex(player1.getMoveIndex());
            info = info.concat("[Player 1] " + player1Pokemon.getName() + " used " + player1Pokemon.getMoveAtIndex(player1.getMoveIndex()).getName() + "!" + "\n");
            if(move.getCategory().equals("status"))
            {
                applyStatus(player1,player2);
            }
            else {
                if(calculateAccuracy(player1,player2))
                {
                    int hp = player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp();
                    int dmg = calculateDamage(player1Pokemon, player2Pokemon, move);
                    info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                    hp = hp - dmg;
                    player2.getPokemonAtIndex(player2.getPokemonIndex()).setHp(hp);
                    //check if defending pokemon is down
                    if (player2.getPokemonAtIndex(player2.getPokemonIndex()).getHp() <= 0)
                    {
                        info = info.concat("[player 2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " fainted!" + "\n");
                    }
                }
                else
                {
                    info = info.concat("[player1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " missed its attack" + "\n");
                }
            }
        }
        //only player 2 attacks
        else if(option == 4)
        {
            move = player2.getPokemonAtIndex(player2.getPokemonIndex()).getMoveAtIndex(player2.getMoveIndex());
            info = info.concat("[Player 2] " + player2Pokemon.getName() + " used " + player2Pokemon.getMoveAtIndex(player2.getMoveIndex()).getName() + "!" + "\n");
            if(move.getCategory().equals("status"))
            {
                applyStatus(player2,player1);
            }
            else {
                if(calculateAccuracy(player2,player1)) {
                    int hp = player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp();
                    int dmg = calculateDamage(player2Pokemon, player1Pokemon, move);
                    info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " did " + dmg + " damage!" + "\n");
                    hp = hp - dmg;
                    player1.getPokemonAtIndex(player1.getPokemonIndex()).setHp(hp);
                    if (player1.getPokemonAtIndex(player1.getPokemonIndex()).getHp() <= 0) {
                        info = info.concat("[player 1] " + player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " fainted!" + "\n");
                    }
                }
                else
                {
                    info = info.concat("[player2] " + player2.getPokemonAtIndex(player2.getPokemonIndex()).getName() + " missed its attack" + "\n");
                }
            }
        }

    }

    /*
	NAME:
	    calculateDamage
	SYNOPSIS:
	    calculates how much damage a move does to a pokemon
	DESCRIPTION:
	    based on if the move is special or physical a pokemon's attack or special attack stat is used for the calculations
	    damage is then calculated and applied to the defending pokemon
	RETURNS:
	    damage output from move
*/
    private int calculateDamage(Pokemon attackingPokemon,Pokemon defendingPokemon,Move attackingMove)
    {
        int movePower = 0;
        int attackPower = 0;
        int defenderPower = 0;
        int damage = 0;

        if(attackingMove.getCategory().equals("physical"))
        {
            attackPower = attackingPokemon.getAttack();
            defenderPower = defendingPokemon.getDefense();
        }
        else if(attackingMove.getCategory().equals("special"))
        {
            attackPower = attackingPokemon.getSpecialAttack();
            defenderPower = defendingPokemon.getSpecialDefense();
        }

        movePower = attackingMove.getPower();

        //damage formula of pokemon
        damage = ((22 * movePower * attackPower/defenderPower)/50) + 2;
        damage = (int) (damage * calculateModifier(attackingPokemon,defendingPokemon,attackingMove));

        return damage;
    }

    /*
	NAME:
	    calculateModifier
	SYNOPSIS:
	    calculate the damage modifier for the attack
	DESCRIPTION:
	    takes account for pokemon's weaknesses/strengths, critical hit chance, STAB to create a damage modifier for the attack
	RETURNS:
	    damage modifier
*/
    private double calculateModifier(Pokemon attackingPokemon,Pokemon defendingPokemon,Move attackingMove)
    {
        double mod = 0;
        Random r = new Random();
        double critical = 1;
        double random = 1;
        double STAB = 1;
        double type = 1;
        double burn = 1; // if pokemon has burn the attacks are weaker

        critical = calculateCriticalHit();
        random = (r.nextInt((int)((1.00-0.85)*100+1))+0.85*100) / 100.0;
        STAB = calculateSTAB(attackingPokemon,attackingMove);
        type = calculateEffectiveness(defendingPokemon,attackingMove);
        mod = critical * random * STAB * type * burn;

        return mod;
    }

    /*
	NAME:
	    calculateCriticalHit
	SYNOPSIS:
	    calculates critical hit
	DESCRIPTION:
	    there is a 1/255 chance a move critically hits
	    random number between 0 and 255 is selected
	    if that number equals 13 then the move critically hits
	RETURNS:
	    multiplier for critical hit
*/
    private double calculateCriticalHit()
    {
        Random rand = new Random();
        int critical = 0;
        critical = rand.nextInt(226);

        if(critical == 13)
        {
            return 1.5;
        }
        else
        {
            return 1;
        }
    }

    /*
	NAME:
	    calculateSTAB
	SYNOPSIS:
	    calculates a moves stab
	DESCRIPTION:
	    if the moves type matches with the attacking pokemon's type then the move used gets a damage multiplier
	RETURNS:
	    multiplier for STAB
*/
    private double calculateSTAB(Pokemon attackingPokemon,Move attackingMove)
    {
        double STAB = 1;

        for(int i =0;i<attackingPokemon.getMoves().size();i++)
        {
            if(attackingMove.getType().equals(attackingPokemon.getType1()) || attackingMove.getType().equals(attackingPokemon.getType2()))
            {
                STAB = 1.5;
            }
        }

        return STAB;
    }

    /*
	NAME:
	    calculateEffectiveness
	SYNOPSIS:
	    calculates a moves effectiveness on a pokemon
	DESCRIPTION:
	    checks if the type of the move is the same as one of the weaknesses or strengths of the defending pokemon
	    if its a weakness then the move does double damage
	    if its strong against the move then the move does half damage
	RETURNS:
	    multiplier fr effectiveness
*/
    private double calculateEffectiveness(Pokemon defendingPokemon, Move attackingMove)
    {
        double effectiveness = 1;

        for(int i =0; i<defendingPokemon.getWeakness().size(); i++)
        {
            String type = defendingPokemon.getWeakness().get(i);
            if (type.equals(attackingMove.getType()))
            {
                effectiveness = 2;
                info = info.concat(attackingMove.getName() + " is super effective!\n");
                break;
            }
        }

        for(int i =0; i<defendingPokemon.getStrength().size(); i++)
        {
            String type = defendingPokemon.getStrength().get(i);
            if (type.equals(attackingMove.getType()))
            {
                effectiveness = .5;
                info = info.concat(attackingMove.getName() + " is not that effective!\n");
                break;
            }
        }

        return effectiveness;
    }

    /*
	NAME:
	    applyStatus
	SYNOPSIS:
	    applys a status effect to a pokemon
	DESCRIPTION:
	    based on the status effect of a move the defending pokemon is given that specific status effect
	RETURNS:
	    none
*/
    private void applyStatus(Player attackingPlayer, Player defendingPlayer)
    {
        Pokemon pokemon = defendingPlayer.getPokemonAtIndex(defendingPlayer.getPokemonIndex());
        Move move = attackingPlayer.getPokemonAtIndex(attackingPlayer.getPokemonIndex()).getMoveAtIndex(attackingPlayer.getMoveIndex());
        String status = move.getInfo();
        if(pokemon.getStatus().equals("burn") | pokemon.getStatus().equals("freeze") | pokemon.getStatus().equals("paralysis") | pokemon.getStatus().equals("poison"))
        {
            info = info.concat("This Pokemon already has " + pokemon.getStatus() + " you cannot stack statuses" + "\n");
            return;
        }
        if(calculateAccuracy(attackingPlayer,defendingPlayer) == false)
        {
            info = info.concat(attackingPlayer.getPokemonAtIndex(attackingPlayer.getPokemonIndex()).getName() + " missed its attack" + "\n");
            return;
        }
        //burn
        if(status.equals("burn"))
        {
            if(pokemon.getStatus().equals("burn"))
            {
                info = info.concat("This Pokemon is already burned!" + "\n");
            }
            else
            {
                pokemon.setStatus("burn");
            }
        }
        //frozen
        else if(status.equals("freeze"))
        {
            if(pokemon.getStatus().equals("freeze"))
            {
                info = info.concat("This Pokemon is already frozen!" + "\n");
            }
            else
            {
                pokemon.setStatus("freeze");
            }
        }
        //paralysis
        else if(status.equals("paralysis"))
        {
            if(pokemon.getStatus().equals("paralysis"))
            {
                info = info.concat("This Pokemon is already paralyzed!" + "\n");
            }
            else
            {
                pokemon.setStatus("paralysis");
            }
        }
        //poison
        else if(status.equals("poison"))
        {
            if(pokemon.getStatus().equals("poison"))
            {
                info = info.concat("This Pokemon is already poisoned!" + "\n");
            }
            else
            {
                pokemon.setStatus("poison");
            }
        }
    }

    /*
	NAME:
	    calculateBurn
	SYNOPSIS:
	    calculates burn damage
	DESCRIPTION:
	    removes 1/8th of a pokemon's total health at the end of each turn
	RETURNS:
	    none
*/
    private void calculateBurn(Pokemon pokemon)
    {
        int oneEighthHealth = pokemon.getTotalHp()/8;
        int hp = pokemon.getHp() - oneEighthHealth;
        pokemon.setHp(hp);
        info = info.concat(pokemon.getName() + " was hurt by burn" + " ["+ oneEighthHealth + " damage]"+"\n");
    }

    /*
	NAME:
	    calculateFreeze
	SYNOPSIS:
	    calculates freeze effect
	DESCRIPTION:
	    pokemon has a 20% chance to break out of freeze
	    if yes then the pokemon is free and can attack again
	    if not then the pokemon cannon attack for that turn
	RETURNS:
	    none
*/
    private void calculateFreeze(Pokemon pokemon)
    {
        Random rand = new Random();
        int stillFrozen = 0;
        stillFrozen = rand.nextInt(101);
        if(stillFrozen <= 20)
        {
            pokemon.setStatus("None");
            info = info.concat(pokemon.getName() + " thawed out" + "\n");
        }
        else
        {
            info = info.concat(pokemon.getName() + " is frozen solid" + "\n");
        }
    }

    /*
	NAME:
	    calculateParalysis
	SYNOPSIS:
	    calculates paralysis effect
	DESCRIPTION:
	    the pokemon has a 25% chance of not attacking that turn
	RETURNS:
	    none
*/
    private boolean calculateParalysis(Pokemon pokemon)
    {
        Random rand = new Random();
        int stillPara = 0;
        stillPara = rand.nextInt(101);
        if(stillPara <= 25)
        {
            info = info.concat(pokemon.getName() + " is fully paralized" + "\n");
            return false;
        }
        return true;
    }

    /*
    NAME:
        calculatePoison
    SYNOPSIS:
        calculates poison damage
    DESCRIPTION:
        removes 1/8th of a pokemon's total health at the end of each turn
    RETURNS:
        none
*/
    private void calculatePoison(Pokemon pokemon)
    {
        int oneEighthHealth = pokemon.getTotalHp()/8;
        int hp = pokemon.getHp() - oneEighthHealth;
        pokemon.setHp(hp);
        info = info.concat(pokemon.getName() + " was hurt by poison" + " ["+ oneEighthHealth + " damage]"+ "\n");
    }

    /*
	NAME:
	    calculateStatusDamage
	SYNOPSIS:
	    calculates status damage
	DESCRIPTION:
	    based on what status effect is on the pokemon the proper function is called to apply that status's effect
	RETURNS:
	    none
*/
    private void calculateStatusDamage(Player player)
    {
        Pokemon pokemon = player.getPokemonAtIndex(player.getPokemonIndex());
        String status = pokemon.getStatus();
        //burn
        if(status.equals("burn"))
        {
            calculateBurn(pokemon);
        }
        //frozen
        if(status.equals("freeze"))
        {
            calculateFreeze(pokemon);
        }
        //poison
        if(status.equals("poison"))
        {
            calculatePoison(pokemon);
        }
        //none
    }

    /*
	NAME:
	    calculateAccuracy
	SYNOPSIS:
	    calculates a moves accuracy
	DESCRIPTION:
	    calculates if a move will attack or miss the defending pokemon
	RETURNS:
	    none
*/
    private Boolean calculateAccuracy(Player attackingPlayer, Player defendingPlayer)
    {
        boolean moveHits = true;
        Pokemon attacking = attackingPlayer.getPokemonAtIndex(attackingPlayer.getPokemonIndex());
        Pokemon defending = defendingPlayer.getPokemonAtIndex(defendingPlayer.getPokemonIndex());
        int threshold = 0;
        threshold = attacking.getMoveAtIndex(attackingPlayer.getMoveIndex()).getAccuracy() * (attacking.getAccuracy() / defending.getEvasion());
        if(attacking.getStatus().equals("paralysis"))
        {
            return calculateParalysis(attacking);
        }
        else if(attacking.getStatus().equals("freeze"))
        {
            threshold = -1;
        }
        Random rand = new Random();
        int attackHit = 0;
        attackHit = rand.nextInt(101);

        if(attackHit <= threshold)
        {
            moveHits = true;
        }
        else
        {
            moveHits = false;
        }
        return moveHits;
    }
}
