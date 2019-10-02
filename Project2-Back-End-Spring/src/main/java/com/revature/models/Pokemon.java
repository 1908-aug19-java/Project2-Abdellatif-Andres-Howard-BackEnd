package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Pokemon implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column(name="userId")
	private Integer userId;
	@Id
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pokemonId")
	private Integer pokemonId;
	
	
	
	@NotBlank
	private String pokemonName;
	private String pokemonNickName;

	private String type;
	private String move;	

	public Pokemon() {
		super();
	}
	public Pokemon(@NotNull Integer pokemonId, Integer userId, @NotBlank String pokemonName, String pokemonNickName,
			String type, String move) {
		super();
		this.pokemonId = pokemonId;
		this.userId = userId;
		this.pokemonName = pokemonName;
		this.pokemonNickName = pokemonNickName;
		this.type = type;
		this.move = move;
	}
	public Integer getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getPokemonNickName() {
		return pokemonNickName;
	}
	public void setPokemonNickName(String pokemonNickName) {
		this.pokemonNickName = pokemonNickName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		result = prime * result + ((pokemonId == null) ? 0 : pokemonId.hashCode());
		result = prime * result + ((pokemonName == null) ? 0 : pokemonName.hashCode());
		result = prime * result + ((pokemonNickName == null) ? 0 : pokemonNickName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (move == null) {
			if (other.move != null)
				return false;
		} else if (!move.equals(other.move))
			return false;
		if (pokemonId == null) {
			if (other.pokemonId != null)
				return false;
		} else if (!pokemonId.equals(other.pokemonId))
			return false;
		if (pokemonName == null) {
			if (other.pokemonName != null)
				return false;
		} else if (!pokemonName.equals(other.pokemonName))
			return false;
		if (pokemonNickName == null) {
			if (other.pokemonNickName != null)
				return false;
		} else if (!pokemonNickName.equals(other.pokemonNickName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", userId=" + userId + ", pokemonName=" + pokemonName
				+ ", pokemonNickName=" + pokemonNickName + ", type=" + type + ", move=" + move + "]";
	}

	


	
}
