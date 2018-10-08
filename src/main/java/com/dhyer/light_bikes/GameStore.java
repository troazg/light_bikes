package com.dhyer.light_bikes;

import java.util.*;

public class GameStore {
  private Map<UUID, Game> games;
  private final Object lock = new Object();

  GameStore() {
    this.games = new HashMap<>();
  }

  public void addGame(Game game) {
    synchronized(lock) {
      this.games.put(game.getId(), game);
    }
  }

  public Game findById(UUID id) {
    synchronized(lock) {
      return this.games.get(id);
    }
  }

  public Collection<Game> getGames() {
    synchronized(lock) {
      return this.games.values();
    }
  }

  public void removeGame(UUID id) {
    synchronized(lock) {
      this.games.remove(id);
    }
  }

  public void removeGames(Collection<UUID> ids) {
    synchronized(lock) {
      ids.forEach(id -> this.games.remove(id));
    }
  }

  public void clear() {
    synchronized(lock) {
      this.games.clear();
    }
  }
}



