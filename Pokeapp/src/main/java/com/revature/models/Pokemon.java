package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable{

	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pokemon_id")
	private int pokemonId;
	
	//@Column(name="pokemonName", unique=true)
	private String pokemonName;
	private String pokemonNickname;
	private String type;
	private String move;
	private String move1;
	private String pokeImageUrl;
/*	
	@ManyToMany(orphanRemoval = true cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "pokemon_id", nullable = false)
//	@Getter //do i need these getter and setter if i have them on bottom>
//	@Setter
	private List<JoinTable> first = new ArrayList<JoinTable>();
	//is inserting inferred type arguements ok?
*/
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
public Pokemon(int pokemonId, String pokemonName, String pokemonNickname, String type, String move, String move1,
		String pokeImageUrl) {
	this.pokemonId = pokemonId;
	this.pokemonName = pokemonName;
	this.pokemonNickname = pokemonNickname;
	this.type = type;
	this.move = move;
	this.move1 = move1;
	this.pokeImageUrl = pokeImageUrl;
}
public int getPokemonId() {
	return pokemonId;
}
public void setPokemonId(int pokemonId) {
	this.pokemonId = pokemonId;
}
public String getPokemonName() {
	return pokemonName;
}
public void setPokemonName(String pokemonName) {
	this.pokemonName = pokemonName;
}
public String getPokemonNickname() {
	return pokemonNickname;
}
public void setPokemonNickname(String pokemonNickname) {
	this.pokemonNickname = pokemonNickname;
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
public String getMove1() {
	return move1;
}
public void setMove1(String move1) {
	this.move1 = move1;
}
public String getPokeImageUrl() {
	return pokeImageUrl;
}
public void setPokeImageUrl(String pokeImageUrl) {
	this.pokeImageUrl = pokeImageUrl;
}
public static long getSerialversionuid() {
	return SerialVersionUID;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((move == null) ? 0 : move.hashCode());
	result = prime * result + ((move1 == null) ? 0 : move1.hashCode());
	result = prime * result + ((pokeImageUrl == null) ? 0 : pokeImageUrl.hashCode());
	result = prime * result + pokemonId;
	result = prime * result + ((pokemonName == null) ? 0 : pokemonName.hashCode());
	result = prime * result + ((pokemonNickname == null) ? 0 : pokemonNickname.hashCode());
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
	Pokemon other = (Pokemon) obj;
	if (move == null) {
		if (other.move != null)
			return false;
	} else if (!move.equals(other.move))
		return false;
	if (move1 == null) {
		if (other.move1 != null)
			return false;
	} else if (!move1.equals(other.move1))
		return false;
	if (pokeImageUrl == null) {
		if (other.pokeImageUrl != null)
			return false;
	} else if (!pokeImageUrl.equals(other.pokeImageUrl))
		return false;
	if (pokemonId != other.pokemonId)
		return false;
	if (pokemonName == null) {
		if (other.pokemonName != null)
			return false;
	} else if (!pokemonName.equals(other.pokemonName))
		return false;
	if (pokemonNickname == null) {
		if (other.pokemonNickname != null)
			return false;
	} else if (!pokemonNickname.equals(other.pokemonNickname))
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}
@Override
public String toString() {
	return "Pokemon [pokemonId=" + pokemonId + ", pokemonName=" + pokemonName + ", pokemonNickname=" + pokemonNickname
			+ ", type=" + type + ", move=" + move + ", move1=" + move1 + ", pokeImageUrl=" + pokeImageUrl + "]";
}
	
	}

	

