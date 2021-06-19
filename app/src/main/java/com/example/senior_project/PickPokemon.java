package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class PickPokemon extends AppCompatActivity
{
    Vector<String> Pokemon = new Vector();
    String[] pokemonNames = {
            "treecko",
            "grovyle",
            "sceptile",
            "torchic",
            "combusken",
            "blaziken",
            "mudkip",
            "marshtomp",
            "swampert",
            "poochyena",
            "mightyena",
            "zigzagoon",
            "linoone",
            "wurmple",
            "silcoon",
            "cascoon",
            "dustox",
            "lotad",
            "lombre",
            "ludicolo",
            "seedot",
            "nuzleaf",
            "shiftry",
            "taillow",
            "swellow",
            "wingull",
            "pelipper",
            "ralts",
            "kirlia",
            "gardevoir",
            "surskit",
            "masquerain",
            "shroomish",
            "breloom",
            "slakoth",
            "vigoroth",
            "slaking",
            "nincada",
            "ninjask",
            "shedinja",
            "whismur",
            "loudred",
            "exploud",
            "makuhita",
            "hariyama",
            "azurill",
            "nosepass",
            "skitty",
            "delcatty",
            "sableye",
            "mawile",
            "aron",
            "lairon",
            "aggron",
            "meditite",
            "medicham",
            "electrike",
            "manectric",
            "plusle",
            "minun",
            "volbeat",
            "illumise",
            "roselia",
            "gulpin",
            "swalot",
            "carvanha",
            "sharpedo",
            "wailmer",
            "wailord",
            "numel",
            "camerupt",
            "torkoal",
            "spoink",
            "grumpig",
            "spinda",
            "trapinch",
            "vibrava",
            "flygon",
            "cacnea",
            "cacturne",
            "swablu",
            "altaria",
            "zangoose",
            "seviper",
            "lunatone",
            "solrock",
            "barboach",
            "whiscash",
            "corphish",
            "crawdaunt",
            "baltoy",
            "claydol",
            "lileep",
            "cradily",
            "anorith",
            "armaldo",
            "feebas",
            "milotic",
            "castform",
            "kecleon",
            "shuppet",
            "banette",
            "duskull",
            "dusclops",
            "tropius",
            "chimecho",
            "absol",
            "wynaut",
            "snorunt",
            "glalie",
            "spheal",
            "sealeo",
            "walrein",
            "clamperl",
            "huntail",
            "gorebyss",
            "relicanth",
            "luvdisc",
            "bagon",
            "shelgon",
            "salamence",
            "beldum",
            "metang",
            "metagross",
            "regirock",
            "regice",
            "registeel",
            "latias",
            "latios",
            "kyogre",
            "groudon",
            "rayquaza",
            "jirachi",
            "deoxys"
    };
    Game game = new Game();

    /*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate function for the PickPokemon activity
	DESCRIPTION:
	    sets up buttons to take in who the player will play against
	    calls pickPokemonLayout
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_player);
        game.addPlayers(game.getHuman1());
        Button humanOpponent = findViewById(R.id.human_button);
        humanOpponent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                game.addPlayers(game.getHuman2());
                pickPokemonLayout();
            }
        });

        Button computerOpponent = findViewById(R.id.computer_button);
        computerOpponent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                game.addPlayers(game.getComputer());
                game.getPlayerAtIndex(1).setType("Computer");
                pickPokemonLayout();

            }
        });

    }

    EditText pokemon1;
    EditText pokemon2;
    EditText pokemon3;
    EditText pokemon4;
    EditText pokemon5;
    EditText pokemon6;
    TextView player;
    Button random;

    /*
	NAME:
	    pickPokemonLayout
	SYNOPSIS:
	    refresh view for entering in pokemon
	DESCRIPTION:
	    changes the layout to the menu for players to enter pokemon
	    checks the pokemon are valid and enters them into the player's party
	RETURNS:
	    none
*/
    private void pickPokemonLayout()
    {
        setContentView(R.layout.activity_pick_pokemon);

        player = (TextView) findViewById(R.id.player);
        pokemon1 = (EditText) findViewById(R.id.pokemon_enter_1);
        pokemon2 = (EditText) findViewById(R.id.pokemon_enter_2);
        pokemon3 = (EditText) findViewById(R.id.pokemon_enter_3);
        pokemon4 = (EditText) findViewById(R.id.pokemon_enter_4);
        pokemon5 = (EditText) findViewById(R.id.pokemon_enter_5);
        pokemon6 = (EditText) findViewById(R.id.pokemon_enter_6);
        random = findViewById(R.id.random_button);
        player.setText("Player " + (game.getPlayerIndex()+1));

        Button nextPlayer = findViewById(R.id.next_player);
        nextPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Pokemon.add(pokemon1.getText().toString());
                Pokemon.add(pokemon2.getText().toString());
                Pokemon.add(pokemon3.getText().toString());
                Pokemon.add(pokemon5.getText().toString());
                Pokemon.add(pokemon4.getText().toString());
                Pokemon.add(pokemon6.getText().toString());

                //check the pokemon to see if they are all real and move to next player
                game.getPlayerAtIndex(game.getPlayerIndex()).setStringPokemon(Pokemon);
                DataInputStream textFileStream = null;
                try {
                    textFileStream = new DataInputStream(getAssets().open(String.format("pokemon.txt")));
                    //Scanner sc = new Scanner(textFileStream);
                    game.parsePokemon(textFileStream);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(PickPokemon.this,"Players pokemon entered!",Toast.LENGTH_SHORT).show();
                Pokemon.clear();
                //go to next player and read things again
                game.setPlayerIndex(1);
                player.setText("Player " + (game.getPlayerIndex()+1));
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pick random pokemon
                for(int i = 0; i<6 ; i++)
                {
                    Random rand = new Random();
                    int pokemonNum = 0;
                    pokemonNum = rand.nextInt(pokemonNames.length);
                    Pokemon.add(pokemonNames[pokemonNum]);
                }

                game.getPlayerAtIndex(game.getPlayerIndex()).setStringPokemon(Pokemon);
                DataInputStream textFileStream = null;
                try {
                    textFileStream = new DataInputStream(getAssets().open(String.format("pokemon.txt")));
                    //Scanner sc = new Scanner(textFileStream);
                    game.parsePokemon(textFileStream);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(PickPokemon.this,"Player's random pokemon entered!",Toast.LENGTH_SHORT).show();
                Pokemon.clear();
                //go to next player and read things again
                game.setPlayerIndex(1);
                player.setText("Player " + (game.getPlayerIndex()+1));
            }
        });

        Button submitPokemon = findViewById(R.id.submit_pokemon);
        submitPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check the pokemon to see if they are all real
                game.setPlayerIndex(0);
                Intent intent = new Intent(PickPokemon.this, PickPokemonMoves.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
        });
    }
}

