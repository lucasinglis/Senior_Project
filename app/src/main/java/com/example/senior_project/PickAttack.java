package com.example.senior_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PickAttack extends AppCompatActivity {
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
    TextView playerStatus;
    TextView opponentStatus;
    Button attack1;
    Button attack2;
    Button attack3;
    Button attack4;
    TextView playerTurn;

/*
	NAME:
	    onCreate
	SYNOPSIS:
	    onCreate for the PickAttack activity
	DESCRIPTION:
	    sets up buttons and views for the PickAttack activity
	    checks if the attacking player's moves has enough pp
	        if not then the pokemon uses struggle
	    based on what button is press the passthrough is set and what the user did is saved for later
	RETURNS:
	    none
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_attack);
        game = (Game) getIntent().getSerializableExtra("GAME");

        attack1 = findViewById(R.id.attack_1);
        attack2 = findViewById(R.id.attack_2);
        attack3 = findViewById(R.id.attack_3);
        attack4 = findViewById(R.id.attack_4);

        if(game.getPlayerIndex() == 0)
        {
            pokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();
            opponentPokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();

            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() + 1);
        }
        else if (game.getPlayerIndex() == 1)
        {
            pokemonIndex = game.getPlayerAtIndex(1).getPokemonIndex();
            opponentPokemonIndex = game.getPlayerAtIndex(0).getPokemonIndex();

            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() - 1);
        }

        refreshView(player1,player2);

        //checks the current pokemon's move's pp if all are 0 then pokemon is forced to use a move called struggle
        if(checkAllMoves(player1))
        {
            game.setInfo(player1.getPokemonAtIndex(player1.getPokemonIndex()).getName() + " ran out of moves and struggled around!\n");

            if(game.getPlayerIndex() == 0)
            {
                game.saveTurn(false, 4);
                game.setPassthrough(game.getPassthrough() + 1);
                game.setPlayerIndex(1);
                Intent intent = new Intent(PickAttack.this, MainBattle.class);
                intent.putExtra("GAME", game);
                startActivity(intent);
            }
            else if(game.getPlayerIndex() == 1)
            {
                game.saveTurn(false, 4);
                game.setPlayerIndex(0);
                game.setPassthrough(0);
                Intent intent = new Intent(PickAttack.this, SwapDownPokemon.class);
                intent.putExtra("GAME", game);
                startActivity(intent);
            }
        }

        Button attackButton = findViewById(R.id.attack_button);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });

        //onclick for swap button
        Button swapButton = findViewById(R.id.pokemon_button);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //swap to swap pokemon and return int that is the index in the pokemon vector
                Intent intent = new Intent(PickAttack.this, SwapPokemon.class);
                intent.putExtra("GAME",game);
                startActivity(intent);

            }
        });

        attack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(game.getPlayerIndex() == 0)
                {
                    Move move1 = game.getPlayerAtIndex(0).getPokemonAtIndex(game.getPlayerAtIndex(0).getPokemonIndex()).getMoveAtIndex(0);
                    if(checkMove(move1))
                    {
                        //set the players swap value to false(meaning player decided to attack)
                        //increment the player index
                        //set the players move index to the button pressed (in this case its the first move)
                        //set the passthrough to 1 for second time through for player 2
                        //minus 1 pp from the move used
                        //call main battle this time for player 2 to go
                        game.saveTurn(false, 0);
                        game.setPassthrough(game.getPassthrough() + 1);
                        game.setPlayerIndex(1);
                        move1.setPP(move1.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, MainBattle.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(game.getPlayerIndex() == 1)
                {
                    Move move1 = game.getPlayerAtIndex(1).getPokemonAtIndex(game.getPlayerAtIndex(1).getPokemonIndex()).getMoveAtIndex(0);
                    if(checkMove(move1))
                    {
                        //set the players swap value to false(meaning player decided to attack)
                        //set the players move index to the button pressed (in this case its the first move)
                        //reset passthrough and player index back to 0
                        //call SwapDownPokemon to switch out any down pokemon at the end of the turn
                        game.saveTurn(false, 0);
                        game.setPlayerIndex(0);
                        game.setPassthrough(0);
                        move1.setPP(move1.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, SwapDownPokemon.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        attack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(game.getPlayerIndex() == 0)
                {
                    Move move2 = game.getPlayerAtIndex(0).getPokemonAtIndex(game.getPlayerAtIndex(0).getPokemonIndex()).getMoveAtIndex(1);
                    if(checkMove(move2))
                    {
                        game.saveTurn(false, 1);
                        game.setPassthrough(game.getPassthrough() + 1);
                        game.setPlayerIndex(1);
                        move2.setPP(move2.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, MainBattle.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(game.getPlayerIndex() == 1)
                {
                    Move move2 = game.getPlayerAtIndex(1).getPokemonAtIndex(game.getPlayerAtIndex(1).getPokemonIndex()).getMoveAtIndex(1);
                    if(checkMove(move2))
                    {
                        game.saveTurn(false, 1);
                        game.setPlayerIndex(0);
                        game.setPassthrough(0);
                        move2.setPP(move2.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, SwapDownPokemon.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        attack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(game.getPlayerIndex() == 0)
                {
                    Move move3 = game.getPlayerAtIndex(0).getPokemonAtIndex(game.getPlayerAtIndex(0).getPokemonIndex()).getMoveAtIndex(2);
                    if(checkMove(move3))
                    {
                        game.saveTurn(false, 2);
                        game.setPassthrough(game.getPassthrough() + 1);
                        game.setPlayerIndex(1);
                        move3.setPP(move3.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, MainBattle.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(game.getPlayerIndex() == 1)
                {
                    Move move3 = game.getPlayerAtIndex(1).getPokemonAtIndex(game.getPlayerAtIndex(1).getPokemonIndex()).getMoveAtIndex(2);
                    if(checkMove(move3))
                    {
                        game.saveTurn(false, 2);
                        game.setPlayerIndex(0);
                        game.setPassthrough(0);
                        move3.setPP(move3.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, SwapDownPokemon.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        attack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(game.getPlayerIndex() == 0)
                {
                    Move move4 = game.getPlayerAtIndex(0).getPokemonAtIndex(game.getPlayerAtIndex(0).getPokemonIndex()).getMoveAtIndex(3);
                    if(checkMove(move4))
                    {
                        game.saveTurn(false, 3);
                        game.setPassthrough(game.getPassthrough() + 1);
                        game.setPlayerIndex(1);
                        move4.setPP(move4.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, MainBattle.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }
                else if(game.getPlayerIndex() == 1)
                {
                    Move move4 = game.getPlayerAtIndex(1).getPokemonAtIndex(game.getPlayerAtIndex(1).getPokemonIndex()).getMoveAtIndex(3);
                    if(checkMove(move4))
                    {
                        game.saveTurn(false, 3);
                        game.setPlayerIndex(0);
                        game.setPassthrough(0);
                        move4.setPP(move4.getPP() - 1);
                        Intent intent = new Intent(PickAttack.this, SwapDownPokemon.class);
                        intent.putExtra("GAME", game);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(PickAttack.this,"Cannot select a move with 0 PP!",Toast.LENGTH_SHORT).show();
                    }
                }
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

        playerTurn.setText("Player " + Integer.toString(game.getPlayerIndex() + 1));

        if(game.getPlayerIndex() == 0) {
            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() + 1);
        }
        else if (game.getPlayerIndex() == 1)
        {
            player1 = game.getPlayerAtIndex(game.getPlayerIndex());
            player2 = game.getPlayerAtIndex(game.getPlayerIndex() - 1);
        }

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

            //set button names
            attack1.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(0).getName());
            attack2.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(1).getName());
            attack3.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(2).getName());
            attack4.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(3).getName());

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

            //set button names
            attack1.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(0).getName());
            attack2.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(1).getName());
            attack3.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(2).getName());
            attack4.setText(player1.getPokemonAtIndex(pokemonIndex).getMoveAtIndex(3).getName());

        }

    }

    /*
	NAME:
	    checkMove
	SYNOPSIS:
	    checks the pp of a move
	DESCRIPTION:
	    sees if a single move has enough pp to use
	RETURNS:
	    true if player can use the move
	    false if the player cant
*/
    public boolean checkMove(Move move)
    {
        boolean enoughPP = true;

        if(move.getPP() <= 0)
        {
            enoughPP = false;
        }

        return enoughPP;
    }

    /*
	NAME:
	    checkAllMoves
	SYNOPSIS:
	    checksAll the moves of a players pokemon
	DESCRIPTION:
	    see if the pokemon currently out on the field doesn't have 0 pp in all its moves
	RETURNS:
	    true if all the moves have no pp
	    false if one move has pp
*/
    public boolean checkAllMoves(Player player)
    {
        boolean useStruggle = false;

        Pokemon playersPokemon = player.getPokemonAtIndex(player.getPokemonIndex());
        Move move1 = playersPokemon.getMoveAtIndex(0);
        Move move2 = playersPokemon.getMoveAtIndex(1);
        Move move3 = playersPokemon.getMoveAtIndex(2);
        Move move4 = playersPokemon.getMoveAtIndex(3);

        if( (move1.getPP() <= 0) && (move2.getPP() <= 0) && (move3.getPP() <= 0) && (move4.getPP() <= 0))
        {
            useStruggle = true;
        }

        return useStruggle;
    }
}
