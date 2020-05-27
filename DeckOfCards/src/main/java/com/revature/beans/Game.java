package com.revature.beans;

public class Game {
	private Integer id;
	private Integer userId;
	private Integer deckId;
	private GameType type;
	private Integer score;
	private Integer winnerId;
	private Float amount_won;
	
	public Game() {
		id = 0;
		userId = 0;
		deckId = 0;
		type = null;
		score = 0;
		winnerId = 0;
		amount_won = 0f;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return amount_won;
	}

	public void setAmount_won(Float amount_won) {
		this.amount_won = amount_won;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount_won == null) ? 0 : amount_won.hashCode());
		result = prime * result + ((deckId == null) ? 0 : deckId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (amount_won == null) {
			if (other.amount_won != null)
				return false;
		} else if (!amount_won.equals(other.amount_won))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
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
		return "Game [id=" + id + ", userId=" + userId + ", deckId=" + deckId + ", type=" + type + ", score=" + score
				+ ", winnerId=" + winnerId + ", amount_won=" + amount_won + "]";
	}
	
}
