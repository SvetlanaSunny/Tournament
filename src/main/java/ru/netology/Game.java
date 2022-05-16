package ru.netology;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game {

  public Game() {

  }

  private Map<String, Player> players = new HashMap<>();

  private Player getPlayer(String playerName) {
    return players.get(playerName);
  }

  public void register(Player player) {
    String playerName = player.getName();
    players.put(playerName, player);
  }

  public int round(String playerName1, String playerName2) {
    Player pl1 = getPlayer(playerName1);
    Player pl2 = getPlayer(playerName2);
    if (pl1 == null || pl2 == null) {
      throw new NotRegisteredException("Не зарегистрирован один игрок");
    }
    if (pl1.getStrength() - pl2.getStrength() == 0) {
      return 0;
    }
    if (pl1.getStrength() - pl2.getStrength() > 0) {
      return 1;
    } else
      return 2;
  }


}
