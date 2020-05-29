package com.revature.beans;

public class Card {
	Integer cardId;
	Integer value;
	String color;
	String suit;
	String cardName;
	
	public Card() {
		this.cardId = 0;
		this.value = 0;
		this.color = "";
		this.suit = "";
		this.cardName = "";
	}
	
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", value=" + value + ", color=" + color + ", suit=" + suit + ", cardName="
				+ cardName + "]";
	}

}
