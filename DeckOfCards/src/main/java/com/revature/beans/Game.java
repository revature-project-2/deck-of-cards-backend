package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllGames", query="FROM Game")
})

@Table
public class Game {
	@Id
	@SequenceGenerator(name="gameGen", sequenceName="game_seq", allocationSize=1)
	@GeneratedValue(generator="gameGen", strategy=GenerationType.SEQUENCE)
	@Column(name="game_id")
	private Integer id;
	@Column(name="player_id")
	private Integer playerId;
	@Column(name="deck_id")
	private Integer deckId;
	private GameType type;
	private Integer score;
	@Column(name="winner_id")
	private Integer winnerId;
	@Column(name="amount_won")
	private Float amountWon;
	
	public Game() {
		id = 0;
		playerId = 0;
		deckId = 0;
		type = null;
		score = 0;
		winnerId = 0;
		amountWon = 0f;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return playerId;
	}

	public void setUserId(Integer userId) {
		this.playerId = userId;
	}

	public Integer getDeckId() {
		return deckId;
	}

	public void setDeckId(Integer deckId) {
		this.deckId = deckId;
	}

	public GameType getType() {
		return type;
	}

	public void setType(GameType type) {
		this.type = type;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}

	public Float getAmount_won() {
		return amountWon;
	}

	public void setAmount_won(Float amount_won) {
		this.amountWon = amount_won;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountWon == null) ? 0 : amountWon.hashCode());
		result = prime * result + ((deckId == null) ? 0 : deckId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((winnerId == null) ? 0 : winnerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (amountWon == null) {
			if (other.amountWon != null)
				return false;
		} else if (!amountWon.equals(other.amountWon))
			return false;
		if (deckId == null) {
			if (other.deckId != null)
				return false;
		} else if (!deckId.equals(other.deckId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (type != other.type)
			return false;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (winnerId == null) {
			if (other.winnerId != null)
				return false;
		} else if (!winnerId.equals(other.winnerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", userId=" + playerId + ", deckId=" + deckId + ", type=" + type + ", score=" + score
				+ ", winnerId=" + winnerId + ", amount_won=" + amountWon + "]";
	}
	
}
