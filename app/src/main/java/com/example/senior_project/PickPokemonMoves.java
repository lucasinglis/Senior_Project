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

public class PickPokemonMoves extends AppCompatActivity {
    Game game;
    Vector<String> pokemonMoves = new Vector();
    Vector<Pokemon> playerPokemon = new Vector();
    String moveNames[] = {
            "astonish",
            "poison powder",
            "needle arm" ,
            "poison fang",
            "aerial ace",
            "air cutter",
            "blast burn",
            "blaze kick",
            "brick break",
            "covet",
            "crush claw",
            "dragon claw",
            "eruption",
            "extrasensory",
            "frenzy plant",
            "hyper voice",
            "knock off",
            "poison tail",
            "rock tomb",
            "shadow punch",
            "shock wave",
            "signal beam",
            "silver wind",
            "sky uppercut",
            "will-o-wisp",
            "water spout",
            "volt tackle",
            "glare",
            "stun spore",
            "thunder wave",
            "poison gas",
            "toxic thread",
            "freeze-dry",
            "powder snow",
            "meteor mash",
            "mud shot",
            "doom desire",
            "bone club",
            "earthquake",
            "moongeist beam",
            "shadow ball",
            "shadow claw",
            "aurora beam",
            "ice beam",
            "ice fang",
            "ice hammer",
            "heart stamp",
            "psychic fangs",
            "psychic",
            "bug bite",
            "steamroller",
            "ancient power",
            "power gem",
            "rock wrecker",
            "clanging scales",
            "dragon pulse",
            "aqua jet",
            "hydro cannon",
            "hydro pump",
            "surf",
            "water pulse",
            "razor shell",
            "waterfall",
            "drum beating",
            "energy ball"
    };
    int pokemonIndex = 0;
    int movesIndex = 0;

    EditText move1;
    EditText move2;
    EditText move3;
    EditText move4;
    TextView pokemon;
    TextView player;

/*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate function for the PickPokemonMoves activity
	DESCRIPTION:
	    sets view for the users to enter their pokemon's moves
	    checks to see if those moves are valid and add them to the pokemon's moves
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_pokemon_moves);
        pokemon = (TextView) findViewById(R.id.pokemons_name);
        player = (TextView) findViewById(R.id.pokemon_moves_title);
        move1 = (EditText) findViewById(R.id.pokemon_move_1);
        move2 = (EditText) findViewById(R.id.pokemon_move_2);
        move3 = (EditText) findViewById(R.id.pokemon_move_3);
        move4 = (EditText) findViewById(R.id.pokemon_move_4);
        Button submitMovesButton = findViewById(R.id.submit_moves);
        Button startBattle = findViewById(R.id.start_battle);
        Button nextPokemon = findViewById(R.id.next_pokemon);
        Button randomMoves = findViewById(R.id.random_moves_button);
        game = (Game) getIntent().getSerializableExtra("GAME");
        player.setText("Pick Your pokemon's moves player " + (game.getPlayerIndex()+1));
        pokemon.setText(game.getPlayerAtIndex(game.getPlayerIndex()).getPokemonAtIndex(0).getName() + " (Pokemon 1)");

        submitMovesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //move to next player
                pokemonIndex=0;
                movesIndex=0;
                game.setPlayerIndex(1);
                player.setText("Pick Your pokemon's moves player " + (game.getPlayerIndex()+1));
                pokemon.setText(game.getPlayerAtIndex(game.getPlayerIndex()).getPokemonAtIndex(0).getName() + " (Pokemon 1)");
            }
        });

        randomMoves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(pokemonIndex <= 5)
                {
                    playerPokemon = (Vector) game.getPlayerAtIndex(game.getPlayerIndex()).getPokemon().clone();
                    Pokemon onePokemon = playerPokemon.get(pokemonIndex);
                    pokemon.setText(onePokemon.getName() + " (Pokemon " + (pokemonIndex + 1) + ")");
                    for (int i = 0; i < 4; i++) {
                        Random rand = new Random();
                        int moveNum = 0;
                        moveNum = rand.nextInt(moveNames.length);
                        pokemonMoves.add(moveNames[moveNum]);
                    }

                    pokemonMoves.add("struggle");

                    DataInputStream textFileStream = null;
                    try {
                        textFileStream = new DataInputStream(getAssets().open(String.format("moves.txt")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        game.parseMoves(pokemonMoves, onePokemon, textFileStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    pokemonMoves.clear();
                    //move on to next pokemon
                    pokemonIndex++;
                    Toast.makeText(PickPokemonMoves.this, "Random moves have been entered!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                pickMoves(pokemon);
            }
        });

        startBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                game.setPlayerIndex(0);
                Intent intent = new Intent(PickPokemonMoves.this,MainBattle.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
        });
    }

    /*
	NAME:
	    pickMoves
	SYNOPSIS:
	    sets the entered moves to the pokemon's moves
	DESCRIPTION:
	    takes the moves entered by the user and calls a function that checks and makes sure the move is valid
	    if yes then the move is added to the pokemon
	RETURNS:
	    none
*/
    public void pickMoves(TextView pokemonName)
    {
        if(pokemonIndex <= 5) {

            playerPokemon = (Vector) game.getPlayerAtIndex(game.getPlayerIndex()).getPokemon().clone();
            Pokemon onePokemon = playerPokemon.get(pokemonIndex);
            pokemonName.setText(onePokemon.getName() + " (Pokemon " + (pokemonIndex+1) + ")");

            pokemonMoves.add(move1.getText().toString());
            pokemonMoves.add(move2.getText().toString());
            pokemonMoves.add(move3.getText().toString());
            pokemonMoves.add(move4.getText().toString());
            pokemonMoves.add("struggle");

            //check if all the moves are real
            //set the pokemons moves
            DataInputStream textFileStream = null;
            try {
                textFileStream = new DataInputStream(getAssets().open(String.format("moves.txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                game.parseMoves(pokemonMoves, onePokemon, textFileStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pokemonMoves.clear();
            //move on to next pokemon
            pokemonIndex++;
        }
    }

}
