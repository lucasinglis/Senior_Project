package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainBattle extends AppCompatActivity {
    Game game;
    int pokemonIndex = 0;
    int opponentPokemonIndex = 0;
    int oldOpponentPokemonIndex = 0;
    Player player1;
    Player player2;
    String pokemon;
    TextView infoBox;
    TextView playerRemainHeath;
    TextView playerHealth;
    TextView opponentRemainHeath;
    TextView opponentHealth;
    TextView pokemonName;
    TextView opponentPokemonName;
    TextView playerTurn;
    TextView playerStatus;
    TextView opponentStatus;

    /*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate for MainBattle
	DESCRIPTION:
	    sets up buttons and refreshes the view based on what player's turn it is
	    also calls the computer's actions if the opponent is a computer and it is their turn
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_battle);

        //setting up buttons and variables
        game = (Game) getIntent().getSerializableExtra("GAME");
        if(game.getPlayerIndex() == 0)
        {
            pokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();
            opponentPokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();

        }
        else if (game.getPlayerIndex() == 1)
        {
            if(game.getPlayerAtIndex(1).getType().equals("Computer"))
            {
                boolean swap = game.getPlayerAtIndex(1).computerAction(game.getPlayerAtIndex(0));
                if(swap == true)
                {
                    game.saveTurn(swap,game.getPlayerAtIndex(1).getPokemonIndex());
                }
                else
                {
                    game.saveTurn(swap,game.getPlayerAtIndex(1).getMoveIndex());
                }
                game.setPlayerIndex(0);
                game.setPassthrough(0);
                Intent intent = new Intent(MainBattle.this, SwapDownPokemon.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
            else {
                pokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();
                opponentPokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();
            }
        }

        refreshView(player1,player2);

        //onclick for attack button
        Button attackButton = findViewById(R.id.attack_button);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainBattle.this, PickAttack.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
        });

        //onclick for swap button
        Button swapButton = findViewById(R.id.pokemon_button);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainBattle.this, SwapPokemon.class);
                intent.putExtra("GAME",game);
                startActivity(intent);
            }
        });
    }

    /*
	NAME:
	    refreshView
	SYNOPSIS:
	    refreshes the view of the battle
	DESCRIPTION:
	    sets the sprites on the field to have the players who turn it is be facing away while the opponent is facing forward.
	    sets the remaining health, name, and turn indicator
	RETURNS:
	    none
*/
    public void refreshView (Player player1, Player player2)
    {
        opponentHealth = findViewById(R.id.opponent_total_health);
        opponentRemainHeath = findViewById(R.id.opponent_remaining_health);
        playerRemainHeath = findViewById(R.id.pokemon_remaining_health);
        playerHealth = findViewById(R.id.pokemon_total_health);
        pokemonName = findViewById(R.id.player_pokemon_name);
        opponentPokemonName = findViewById(R.id.opponent_pokemon_name);
        playerTurn = findViewById(R.id.player_turn);
        playerStatus =findViewById(R.id.player_status);
        opponentStatus = findViewById(R.id.opponent_status);
        infoBox = findViewById(R.id.info_box);

        ImageView playersPokemon = findViewById(R.id.player_pokemon_sprite);
        ImageView opponentsPokemon = findViewById(R.id.opponent_pokemon_sprite);

        if(game.getPlayerIndex() == 0) {
            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() + 1);
        }
        else if (game.getPlayerIndex() == 1)
        {
            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() - 1);
        }

        playerTurn.setText("Player " + Integer.toString(game.getPlayerIndex() + 1));
        infoBox.setMovementMethod(new ScrollingMovementMethod());

        if(game.getPlayerIndex() == 0) {
            //sets pokemons sprites
            pokemon = player1.getPokemonAtIndex(pokemonIndex).getName() + "back";
            int id = getResources().getIdentifier(pokemon, "drawable", getPackageName());
            playersPokemon.setImageResource(id);

            pokemon = player2.getPokemonAtIndex(opponentPokemonIndex).getName();
            id = getResources().getIdentifier(pokemon, "drawable", getPackageName());
            opponentsPokemon.setImageResource(id);

            //set pokemons names
            pokemonName.setText(player1.getPokemonAtIndex(pokemonIndex).getName());
            opponentPokemonName.setText(player2.getPokemonAtIndex(opponentPokemonIndex).getName());

            //set pokemons health
            playerRemainHeath.setText(Integer.toString(player1.getPokemonAtIndex(pokemonIndex).getHp()));
            String totalHealth = Integer.toString(player1.getPokemonAtIndex(pokemonIndex).getTotalHp());
            playerHealth.setText(totalHealth);

            opponentRemainHeath.setText(Integer.toString(player2.getPokemonAtIndex(opponentPokemonIndex).getHp()));
            String Health = Integer.toString(player2.getPokemonAtIndex(opponentPokemonIndex).getTotalHp());
            opponentHealth.setText(Health);

            //set pokemon status
            playerStatus.setText(player1.getPokemonAtIndex(pokemonIndex).getStatus());
            opponentStatus.setText(player2.getPokemonAtIndex(opponentPokemonIndex).getStatus());

            //set info Box
            infoBox.append(game.getInfo());
            String info = "What will " + game.getPlayerAtIndex(game.getPlayerIndex()).getPokemonAtIndex(pokemonIndex).getName() + " do?" + "\n";
            infoBox.append(info);

            player1.setOldPokemonIndex(player1.getPokemonIndex());
        }
        else
        {
            oldOpponentPokemonIndex = player2.getOldPokemonIndex();
            //sets pokemons sprites
            pokemon = player1.getPokemonAtIndex(pokemonIndex).getName() + "back";
            int id = getResources().getIdentifier(pokemon, "drawable", getPackageName());
            playersPokemon.setImageResource(id);

            pokemon = player2.getPokemonAtIndex(oldOpponentPokemonIndex).getName();
            id = getResources().getIdentifier(pokemon, "drawable", getPackageName());
            opponentsPokemon.setImageResource(id);

            //set pokemons names
            pokemonName.setText(player1.getPokemonAtIndex(pokemonIndex).getName());
            opponentPokemonName.setText(player2.getPokemonAtIndex(oldOpponentPokemonIndex).getName());

            //set pokemons health
            playerRemainHeath.setText(Integer.toString(player1.getPokemonAtIndex(pokemonIndex).getHp()));
            String totalHealth = Integer.toString(player1.getPokemonAtIndex(pokemonIndex).getTotalHp());
            playerHealth.setText(totalHealth);

            opponentRemainHeath.setText(Integer.toString(player2.getPokemonAtIndex(oldOpponentPokemonIndex).getHp()));
            String Health = Integer.toString(player2.getPokemonAtIndex(oldOpponentPokemonIndex).getTotalHp());
            opponentHealth.setText(Health);

            //set pokemon status
            playerStatus.setText(player1.getPokemonAtIndex(pokemonIndex).getStatus());
            opponentStatus.setText(player2.getPokemonAtIndex(oldOpponentPokemonIndex).getStatus());

            infoBox.append(game.getInfo());
            String info = "What will " + game.getPlayerAtIndex(game.getPlayerIndex()).getPokemonAtIndex(pokemonIndex).getName() + " do?" + "\n";
            infoBox.append(info);
        }
    }
}
