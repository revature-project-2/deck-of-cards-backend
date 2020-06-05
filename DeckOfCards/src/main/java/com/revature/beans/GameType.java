package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="game_type")
public class GameType {
	@Id
	@SequenceGenerator(name="game_typeGen", sequenceName="game_type_seq", allocationSize=1)
	@GeneratedValue(generator="game_typeGen", strategy=GenerationType.SEQUENCE)
	@Column(name="game_type_id")
	private Integer id;
	@Column(name="type_name")
	private String name;
	
	public GameType() {
		id = 0;
		name = "";
	}
	public GameType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GameType other = (GameType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameType [id=" + id + ", name=" + name + "]";
	}
	
	
}
