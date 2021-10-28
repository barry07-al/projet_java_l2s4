package Game;

import java.util.*;
import Game.util.Resource;

public abstract class Game {

		protected List<Player> players;
		protected Cell[][] board;
		protected int nbRounds;
		
		public Game(List<Player> players, int nbRounds, int width, int height) {
			this.players = players;
			this.nbRounds = nbRounds;
			setBoard(width, height);
		}
		
		public int getNbRounds() {
			return this.nbRounds;
		}
		
		public List<Player> winners() {
			int bestScore = 0;
			int tmpScore;
			List<Player> winners = new ArrayList<Player>();
			for(Player p: this.players) {
				tmpScore = p.calculateScore();
				if (tmpScore >= bestScore) {
					bestScore = tmpScore;
				}
			}
			for(Player p: this.players) {
				if (p.calculateScore() == bestScore) {
					winners.add(p);
				}
			}
			return winners;
		}
		
		public abstract void setBoard(int width, int height);
		public abstract void deploy(Player player, Character character, Cell cell);
		public abstract void collect(Player player);
		public abstract boolean convert(Player player, Resource resource, int nbResource);
		public abstract void distribute(Player player);
		public abstract void playOneRound(Player player);
		public abstract void play();
		
}


