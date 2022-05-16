package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

  @Test
  void playerWinner(){
    Game game = new Game();
    Player player1 = new Player(1, "Vasiliy", 255);
    Player player2 = new Player(2, "Petr", 125);
    game.register(player1);
    game.register(player2);
    int expected = 1;
    int actual = game.round("Vasiliy", "Petr");
    assertEquals(expected, actual);
  }

  @Test
  void playerWinner2(){
    Game game = new Game();
    Player player1 = new Player(1, "Vasiliy", 255);
    Player player2 = new Player(2, "Petr", 325);
    game.register(player1);
    game.register(player2);
    int expected = 2;
    int actual = game.round("Vasiliy", "Petr");
    assertEquals(expected, actual);
  }

  @Test
  void playerDraw(){
    Game game = new Game();
    Player player1 = new Player(1, "Vasiliy", 255);
    Player player2 = new Player(2, "Petr", 255);
    game.register(player1);
    game.register(player2);
    int expected = 0;
    int actual = game.round("Vasiliy", "Petr");
    assertEquals(expected, actual);
  }

  @Test
  void unregisteredPlayer(){
    Game game = new Game();
    Player player1 = new Player(1, "Vasiliy", 255);
    game.register(player1);
    assertThrows(NotRegisteredException.class,() ->{
     game.round("Vasiliy", "Petr");
    });
  }

  @Test
  void unregisteredPlayer2(){
    Game game = new Game();
    Player player2 = new Player(1, "Petr", 255);
    game.register(player2);
    assertThrows(NotRegisteredException.class,() ->{
      game.round("Vasiliy", "Petr");
    });
  }


}
