package com.example.senior_project;
import java.io.Serializable;
import java.util.Vector;

public class Pokemon implements Serializable{
    private Boolean random; //true for if there is a pokemon created by the player false for if they didnt want one
    private String status; //the status effect if applied to the pokemon based on a move
    private String name; //name of pokemon
    private String type1; //main type of pokemon
    private String type2; //second type of pokemon if there is none then value set to "None"
    private Vector<String> weakness; // vector of strings for the weaknesses of the pokemon
    private int hp;
    private int totalHp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int movesIndex;
    private int accuracy;
    private int evasion;
    private Vector<Move> moves;
    private Vector<String> strength;

/*
	NAME:
	    Pokemon
	SYNOPSIS:
	    default constructor for pokemon object
	DESCRIPTION:
	    default constructor to set default variables for the pokemon object
	RETURNS:
	    none
*/
    public Pokemon()
    {
        random = false;
        status = "";
        name = "None";
        type1 = "None";
        type2 = "None";
        weakness = new Vector();
        weakness.clear();
        strength = new Vector();
        strength.clear();
        hp = 0;
        totalHp = 0;
        attack = 0;
        defense = 0;
        specialAttack = 0;
        specialDefense = 0;
        speed = 0;
        moves = new Vector();
        moves.clear();
        movesIndex = 0;
        accuracy = 100;
        evasion = 100;
    }

    /*
	NAME:
	    getName
	SYNOPSIS:
	    gets pokemon's name
	DESCRIPTION:
	    returns the pokemon's name
	RETURNS:
	    String name
*/
    public String getName()
    {
        return name;
    }

    /*
	NAME:
	    getType1
	SYNOPSIS:
	    returns one type of the pokemon
	DESCRIPTION:
	    returns the main type of the pokemon
	RETURNS:
	    String type1
*/
    public String getType1()
    {
        return type1;
    }

    /*
	NAME:
	    getType2
	SYNOPSIS:
	    returns the second type of the pokemon
	DESCRIPTION:
	    returns the second type of the pokemon, if there isnt one then it returns "none"
	RETURNS:
	    String type2
*/
    public String getType2()
    {
        return type2;
    }

    /*
	NAME:
	    getWeakness
	SYNOPSIS:
	    returns a pokemons weaknesses
	DESCRIPTION:
	    returns the vector of strings that contains the types that the pokemon is weak to
	RETURNS:
	    Vector<String> weakness
*/
    public Vector<String> getWeakness()
    {
        return weakness;
    }

    /*
	NAME:
	    getHp
	SYNOPSIS:
	    returns pokemons hp
	DESCRIPTION:
	    returns pokemons remaining hp
	RETURNS:
	    int hp
*/
    public int getHp()
    {
        return hp;
    }

    /*
	NAME:
	    getAttack
	SYNOPSIS:
	    returns attack stat
	DESCRIPTION:
	    returns pokemon's attack stat for damage calculation
	RETURNS:
	    int attack
*/
    public int getAttack()
    {
        return attack;
    }

    /*
	NAME:
	    getSpecialAttack
	SYNOPSIS:
	    returns special attack stat
	DESCRIPTION:
	    returns pokemon's special attack stat for damage calculation
	RETURNS:
	    int specialAttack
*/
    public int getSpecialAttack()
    {
        return specialAttack;
    }

    /*
	NAME:
	    getSpecialDefense
	SYNOPSIS:
	    returns special defense stat
	DESCRIPTION:
	    returns special defense stat for damage calculation
	RETURNS:
	    int specialDefense
*/
    public int getSpecialDefense()
    {
        return specialDefense;
    }

    /*
NAME:
    getDefense
SYNOPSIS:
    returns defense stat
DESCRIPTION:
    returns defense stat for damage calculation
RETURNS:
    int Defense
*/
    public int getDefense()
    {
        return defense;
    }

    /*
	NAME:
	    getSpeed
	SYNOPSIS:
	    returns speed stat
	DESCRIPTION:
	    returns speed stat to see what pokemon goes first
	RETURNS:
	    int speed
*/
    public int getSpeed()
    {
        return speed;
    }

    /*
	NAME:
	    getAccuracy
	SYNOPSIS:
	    returns accuracy stat
	DESCRIPTION:
	    returns accuracy stat for calculating if a move hits an opponent
	RETURNS:
	    int accuracy
*/
    public int getAccuracy()
    {
        return accuracy;
    }

    /*
	NAME:
	    getEvasion
	SYNOPSIS:
	    returns evasion stat
	DESCRIPTION:
	    returns evasion stat that is used to see if a pokemon doges an attack
	RETURNS:
	    int evasion
*/
    public int getEvasion()
    {
        return evasion;
    }

    /*
	NAME:
	    getMoves
	SYNOPSIS:
	    returns move vector
	DESCRIPTION:
	    returns the vector of moves the pokemon has
	RETURNS:
	    Vector<Move> moves
*/
    public Vector<Move> getMoves()
    {
        return moves;
    }

    /*
	NAME:
	    getMoveAtIndex
	SYNOPSIS:
	    returns a single move
	DESCRIPTION:
	    returns the move in the move vector at the given index
	RETURNS:
	    Move move
*/
    public Move getMoveAtIndex(int index)
    {
        return moves.get(index);
    }

    /*
	NAME:
	    getStrength
	SYNOPSIS:
	    returns a pokemons strengths
	DESCRIPTION:
	    returns a list of the types the pokemon is strong against
	RETURNS:
	    Vector <String> strength
*/
    public Vector<String> getStrength()
    {
        return strength;
    }

    /*
	NAME:
	    getStatus
	SYNOPSIS:
	    returns the status of the pokemon
	DESCRIPTION:
	    returns the status effect that is currently affecting the pokemon
	RETURNS:
	    String status
*/
    public String getStatus()
    {
        return status;
    }

    /*
	NAME:
	    getTotalHp
	SYNOPSIS:
	    returns the total hp of a pokemon
	DESCRIPTION:
	    returns the total hp of a pokemon for outputs and visuals
	RETURNS:
	    int totalHp
*/
    public int getTotalHp()
    {
        return totalHp;
    }

    /*
	NAME:
	    setName
	SYNOPSIS:
	    sets pokemon's name
	DESCRIPTION:
	    sets the name of the pokemon to the incoming string
	RETURNS:
	    none
*/
    public void setName(String inName)
    {
        name = inName;
    }

    /*
	NAME:
	    setType1
	SYNOPSIS:
	    sets the first type of the pokemon
	DESCRIPTION:
	    sets the pokemon's main type to the incoming string
	RETURNS:
	    none
*/
    public void setType1(String inType)
    {
        type1 = inType;
    }

    /*
	NAME:
	    setType2
	SYNOPSIS:
	    sets the secondary type of a pokemon
	DESCRIPTION:
	    sets the secondary type to the incoming string
	    type2 is default to none since not all pokemon have 2 types
	RETURNS:
	    none
*/
    public void setType2(String inType)
    {
        type2 = inType;
    }

    /*
	NAME:
	    setWeakness
	SYNOPSIS:
	    sets the pokemon's weaknesses
	DESCRIPTION:
	    sets the pokemon's weakness vector to the incoming one
	RETURNS:
	    none
*/
    public void setWeakness(Vector<String> inWeakness)
    {
        weakness = (Vector)inWeakness.clone();
    }

    /*
	NAME:
	    setHp
	SYNOPSIS:
	    sets the hp of a pokemon
	DESCRIPTION:
	    sets the hp of a pokemon
	        this is used for the remaining health of the pokemone
	RETURNS:
	    none
*/
    public void setHp(int inHp)
    {
        if(inHp <= 0)
        {
            hp = 0;
        }
        else
        {
            hp = inHp;
        }
    }

    /*
	NAME:
	    setAttack
	SYNOPSIS:
	    sets the attack stat of a pokemon
	DESCRIPTION:
	    sets the attack stat to the incoming int
	RETURNS:
	    none
*/
    public void setAttack(int inAttack)
    {
        attack = inAttack;
    }

    /*
	NAME:
	    setTotalHp
	SYNOPSIS:
	    sets the total hp of a pokemon
	DESCRIPTION:
	    sets the total hp to the incoming int
	    this is used to show the total health of a pokemon
	    this number doesnt change based on damage the pokemon gets
	RETURNS:
	    none
*/
    public void setTotalHp(int inHp)
    {
        totalHp = inHp;
    }

    /*
	NAME:
	    setSpecialAttack
	SYNOPSIS:
	    sets a pokemon's special attack stat
	DESCRIPTION:
	    sets a pokemon's special attack to the incoming int
	    stat is used for damage calculation
	RETURNS:
	    none
*/
    public void setSpecialAttack(int inSpecialAttack)
    {
        specialAttack = inSpecialAttack;
    }

    /*
    NAME:
        setSpecialDefense
    SYNOPSIS:
        sets a pokemon's special defense attack stat
    DESCRIPTION:
        sets a pokemon's special defense to the incoming int
        stat is used for damage calculation
    RETURNS:
        none
*/
    public void setDefense(int inDefense)
    {
        defense = inDefense;
    }

    /*
    NAME:
        setDefense
    SYNOPSIS:
        sets a pokemon's defense attack stat
    DESCRIPTION:
        sets a pokemon's defense to the incoming int
        stat is used for damage calculation
    RETURNS:
        none
*/
    public void setSpecialDefense(int inSpecialDefense)
    {
        specialDefense = inSpecialDefense;
    }

    /*
	NAME:
	    setSpeed
	SYNOPSIS:
	    sets the speed stat of a pokemon
	DESCRIPTION:
	    sets speed stat that is used to see what pokemon goes first
	RETURNS:
	    none
*/
    public void setSpeed(int inSpeed)
    {
        speed = inSpeed;
    }

    /*
	NAME:
	    addMove
	SYNOPSIS:
	    adds a move to a pokemon
	DESCRIPTION:
	    adds a move to a pokemon's move vector
	RETURNS:
	    none
*/
    public void addMove(Move move)
    {
        moves.add(move);
    }

    /*
	NAME:
	    setStrength
	SYNOPSIS:
	    sets the strengths of a pokemon
	DESCRIPTION:
	    sets the strength vector of a pokemon to see what types the pokemon is strong against
	RETURNS:
	    none
*/
    public void setStrength(Vector<String> inStrength)
    {
        strength = (Vector)inStrength.clone();
    }

    /*
	NAME:
	    setStatus
	SYNOPSIS:
	    sets the status of a pokemon
	DESCRIPTION:
	    sets the status affect of a pokemon
	RETURNS:
	    none
*/
    public void setStatus(String inStatus)
    {
        status = inStatus;
    }
}
