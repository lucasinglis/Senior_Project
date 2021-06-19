package com.example.senior_project;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

public class Player implements Serializable {
    private Vector<Pokemon> pokemon;
    private Vector<String> stringPokemon;
    private String type;
    private boolean swapPokemon;
    private int moveIndex;
    private int pokemonIndex;
    private int oldPokemonIndex;

    /*
	NAME:
	    Player
	SYNOPSIS:
	    default constructor for player object
	DESCRIPTION:
	    sets player object's variables to default values
	RETURNS:
	    none
*/

    public Player()
    {
        this.stringPokemon = new Vector();
        this.stringPokemon.clear();
        this.pokemon = new Vector();
        this.pokemon.clear();
        this.type = "None";
        this.pokemonIndex = 0;
        this.swapPokemon = false;
        this.moveIndex = 0;
        this.oldPokemonIndex = 0;
    }

    /*
	NAME:
	    getOldPokemonIndex
	SYNOPSIS:
	    return the oldPokemonIndex
	DESCRIPTION:
	    return the oldPokemonIndex so player two always see the same pokemon through the turn
	RETURNS:
	    int oldPokemonIndex
*/
    public int getOldPokemonIndex()
    {
        return oldPokemonIndex;
    }

    /*
	NAME:
	    getPokemon
	SYNOPSIS:
	    returns the players pokemon party
	DESCRIPTION:
	    returns the players pokemon vector
	RETURNS:
	    Vector<Pokemon> pokemon
*/
    public Vector<Pokemon> getPokemon()
    {
        return pokemon;
    }

    /*
	NAME:
	    getStringPokemon
	SYNOPSIS:
	    returns the string representation of a players pokemon party
	DESCRIPTION:
	    returns string representation of the pokemon party for parsing
	RETURNS:
	    Vector<String> Pokemon
*/
    public Vector<String> getStringPokemon()
    {
        return stringPokemon;
    }

    /*
	NAME:
	    getType
	SYNOPSIS:
	    returns a players type
	DESCRIPTION:
	    returns the type of the player (computer or human)
	RETURNS:
	    String type
*/
    public String getType()
    {
        return type;
    }

    /*
	NAME:
	    getPokemonAtIndex
	SYNOPSIS:
	    returns a pokemon at a given index
	DESCRIPTION:
	    takes in a index and returns the pokemon from the pokemon vector at that index
	RETURNS:
	    Pokemon pokemon
*/
    public Pokemon getPokemonAtIndex(int index)
    {
        return pokemon.get(index);
    }

    /*
	NAME:
	    getPokemonIndex
	SYNOPSIS:
	    return the pokemonIndex
	DESCRIPTION:
	    returns the current index in the pokemon vector
	RETURNS:
	    int pokemonIndex
*/
    public int getPokemonIndex()
    {
        return pokemonIndex;
    }

    /*
	NAME:
	    getSwapPokemon
	SYNOPSIS:
	    returns swapPokemon
	DESCRIPTION:
	    returns swapPokemon which is used to tell if the player decided to switch out their pokemon (true)
	    or they decided to attack the opponent (false)
	RETURNS:
	    boolean swapPokemon
*/
    public boolean getSwapPokemon()
    {
        return swapPokemon;
    }

    /*
	NAME:
	    getMoveIndex
	SYNOPSIS:
	    returns the moveIndex
	DESCRIPTION:
	    returns the moveIndex that tells the game what move the user selected
	RETURNS:
	    int moveIndex
*/
    public int getMoveIndex()
    {
        return moveIndex;
    }

    /*
	NAME:
	    setOldPokemonIndex
	SYNOPSIS:
	    sets oldPokemonIndex
	DESCRIPTION:
	    sets oldPokemon index to the previous pokemonIndex to keep player 2 from seeing player 1's pokemon early
	RETURNS:
	    none
*/
    public void setOldPokemonIndex(int inIndex)
    {
        oldPokemonIndex = inIndex;
    }

    /*
	NAME:
	    setSwapPokemon
	SYNOPSIS:
	    sets the swapPokemon
	DESCRIPTION:
	    sets swapPokemon to true or false depending on if the user switched out that turn or attacked
	RETURNS:
	    none
*/
    public void setSwapPokemon(boolean inBool)
    {
        swapPokemon = inBool;
    }

    /*
	NAME:
	    setMoveIndex
	SYNOPSIS:
	    sets the moveIndex
	DESCRIPTION:
	    sets users moveIndex for the game to know what move the user selected
	RETURNS:
	    none
*/
    public void setMoveIndex(int inIndex)
    {
        moveIndex = inIndex;
    }

    /*
	NAME:
	    setStringPokemon
	SYNOPSIS:
	    sets the stringPokemon vector
	DESCRIPTION:
	    sets the stringPokemon vector to be used for parsing the pokemon
	RETURNS:
	    none
*/
    public void setStringPokemon(Vector <String> inStringPokemon)
    {
        stringPokemon = (Vector)inStringPokemon.clone();
    }

    /*
	NAME:
	    setPokemon
	SYNOPSIS:
	    sets the users pokemon
	DESCRIPTION:
	    sets the users pokemon vector to the incoming pokemon vector
	RETURNS:
	    none
*/
    public void setPokemon(Vector<Pokemon> inPokemon)
    {
        pokemon = inPokemon;
    }

    /*
	NAME:
	    setType
	SYNOPSIS:
	    sets the players type
	DESCRIPTION:
        sets the players type to computer or human
	RETURNS:
	    none
*/
    public void setType(String inType)
    {
        type = inType;
    }

    /*
	NAME:
	    setPokemonIndex
	SYNOPSIS:
	    sets the pokemonIndex
	DESCRIPTION:
	    sets the users pokemonIndex to know what pokemon in the party is out on the field
	RETURNS:
	    none
*/
    public void setPokemonIndex(int inIndex)
    {
        pokemonIndex = inIndex;
    }

    /*
	NAME:
	    addPokemon
	SYNOPSIS:
	    add a pokemon to the pokemon vector
	DESCRIPTION:
	    add pokemon to the players pokemon vector after seeing if it is a valid pokemon and its stats have been parsed
	RETURNS:
	    none
*/
    public void addPokemon(Pokemon inPokemon)
    {
        pokemon.add(inPokemon);
    }

    /*
	NAME:
	    computerAction
	SYNOPSIS:
	    controls what the computer player will do
	DESCRIPTION:
	    if the computer's pokemon is weak to the opponents pokemon it then looks for one that isnt then switches into that
	        if not then the computer switches into a pokemon that is equal with the opponent
	    if computers pokemon is equal or strong against the opponent then the computer picks a move that is strong against the opponent
	        if not then the computer picks a random move
	RETURNS:
	    boolean swap - if the computer switched out(true) or didnt (false)
*/
    public boolean computerAction(Player opponent)
    {
        boolean swap = false;
        Pokemon opponentPokemon = opponent.getPokemonAtIndex(opponent.getPokemonIndex());

        for(int i =0; i<getPokemonAtIndex(pokemonIndex).getWeakness().size(); i++)
        {
            String type1 = opponentPokemon.getType1();
            String type2 = opponentPokemon.getType2();
            if (type1.equals(getPokemonAtIndex(pokemonIndex).getWeakness().get(i)) | type2.equals(getPokemonAtIndex(pokemonIndex).getWeakness().get(i)))
            {
                //swap in pokemon that is not weak to opponent
                swap = true;
                pokemonIndex = computerPickPokemon(opponentPokemon);
                return swap;
            }
        }
        moveIndex = computerPickMove(opponentPokemon);

        return swap;
    }

    /*
	NAME:
	    computerPickPokemon
	SYNOPSIS:
	    picks which pokemon the computer switched into
	DESCRIPTION:
	    looks at remaining pokemon to see if any are strong against the opponent
	        if yes then switch into that pokemon
	        if no then choose a random
	RETURNS:
	    int pokemonNumber - index of the pokemon in the pokemon vector
*/
    public int computerPickPokemon(Pokemon opponentPokemon)
    {
        int pokemonNumber = -1;
        String type1 = opponentPokemon.getType1();
        String type2 = opponentPokemon.getType2();
        //look at all remaining pokemon
        for(int i =0; i<getPokemon().size(); i++)
        {
            if(getPokemonAtIndex(i).getHp() > 0)
            {
                for (int j = 0; j < getPokemonAtIndex(i).getStrength().size(); j++)
                {
                    if (type1.equals(getPokemonAtIndex(i).getStrength().get(j)) | type2.equals(getPokemonAtIndex(i).getStrength().get(j))) {
                        //swap in pokemon that is not weak to opponent
                        pokemonNumber = i;
                        return pokemonNumber;
                    }
                }
            }
        }
        //if one is strong to opponent pokemon switch that guy in
        //if not pick random
        if(pokemonNumber == -1) {
            do {
                Random rand = new Random();
                int randomPoke = 0;
                randomPoke = rand.nextInt(6);
                if (getPokemonAtIndex(randomPoke).getHp() > 0) {
                    pokemonNumber = randomPoke;
                }
            } while (getPokemonAtIndex(pokemonNumber).getHp() > 0);
        }

        return pokemonNumber;
    }

    /*
	NAME:
	    computerPickMove
	SYNOPSIS:
	    what move the computer picks
	DESCRIPTION:
	    looks at pokemon moves to see if any are strong against the opponent
	        if yes then use that move
	        if no then choose a random
	RETURNS:
	    int moveNumber - index of the pokemon's move in their move vector
*/
    public int computerPickMove(Pokemon opponentPokemon)
    {
        String type1 = opponentPokemon.getType1();
        String type2 = opponentPokemon.getType2();
        int moveNumber = -1;
        for(int i =0; i < getPokemonAtIndex(pokemonIndex).getMoves().size(); i++)
        {
            if (type1.equals(getPokemonAtIndex(pokemonIndex).getMoveAtIndex(i).getType()) | type2.equals(getPokemonAtIndex(pokemonIndex).getMoveAtIndex(i).getType())) {
                continue;
            }
            moveNumber = i;
            break;
        }

        if(moveNumber == -1) {
            Random rand = new Random();
            int randomMove = 0;
            randomMove = rand.nextInt(5);
            moveNumber = randomMove;
        }
        return moveNumber;
    }
}
