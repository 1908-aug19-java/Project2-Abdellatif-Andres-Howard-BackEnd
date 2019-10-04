package com.revature.project2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Pokemon implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pokemon_id")
	private int pokemonId;
	@Column(name="name")
	private String name;
	@Column(name="weight")
	private long weight;
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	@Column(name="type")
	private String type;
	public Pokemon() {
		super();
	}
	@Override
	public String toString() {
		return "Pokemon [pokemonId=" + pokemonId + ", name=" + name + ", weight=" + weight + ", account=" + account
				+ ", type=" + type + "]";
	}
	public Pokemon(int pokemonId, String name, long weight, Account account, String type) {
		super();
		this.pokemonId = pokemonId;
		this.name = name;
		this.weight = weight;
		this.account = account;
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pokemonId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (int) (weight ^ (weight >>> 32));
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokemonId != other.pokemonId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	public int getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
