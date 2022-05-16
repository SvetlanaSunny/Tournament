package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

  public Game() {

  }

  private Collection<Player> players = new ArrayList<Player>();

  private Player getPlayer(String playerName) {
    for (Player pl : players) {
      if (pl.getName() == playerName)
        return pl;
    }
    return null;
  }

  public void register(Player player) {
    players.add(player);
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
