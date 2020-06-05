package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllGames", query="FROM Game")
})

@Entity
@Table
public class Game implements Comparable<Game>{
	@Id
	@SequenceGenerator(name="gameGen", sequenceName="game_seq", allocationSize=1)
	@GeneratedValue(generator="gameGen", strategy=GenerationType.SEQUENCE)
	@Column(name="game_id")
	private Integer id;
	@Column(name="deck_id")
	private String deckId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="game_type_id")
	private GameType type;
	private Integer score;
	@Column(name="amount_won")
	private Float amountWon;
	
	public Game() {
		id = 0;
		deckId = "";
		type = new GameType(1, "Blackjack");
		score = 0;
		amountWon = 0f;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
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
		return true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", userId=" + ", deckId=" + deckId + ", type=" + type + ", score=" + score
				+ ", amount_won=" + amountWon + "]";
	}

	@Override
	public int compareTo(Game g) {
		return this.id - g.getId();
	}
	
}
