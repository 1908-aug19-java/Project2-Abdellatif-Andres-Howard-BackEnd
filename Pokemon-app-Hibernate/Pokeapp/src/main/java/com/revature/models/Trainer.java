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

import javassist.SerialVersionUID;

@Component
@Entity
@Table(name="trainers")
public class Trainer implements Serializable {
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	private int trainerId;
	
	
	private String name;
	private String lastname;
	
//	@Column(name ="email", unique=true)
	private String email;
	
	private String starterPokemon;
	private String nickName;
	
//	@Column(name="username", unique=true)
	private String username;
	private String password;
	private List<Pokemon> pokemons = new ArrayList<>();
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(int trainerId, String name, String lastname, String email, String starterPokemon, String nickName,
			String username, String password, List<Pokemon> pokemons) {
		this.trainerId = trainerId;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.starterPokemon = starterPokemon;
		this.nickName = nickName;
		this.username = username;
		this.password = password;
		this.pokemons = pokemons;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", lastname=" + lastname + ", email=" + email
				+ ", starterPokemon=" + starterPokemon + ", nickName=" + nickName + ", username=" + username
				+ ", password=" + password + ", pokemons=" + pokemons + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pokemons == null) ? 0 : pokemons.hashCode());
		result = prime * result + ((starterPokemon == null) ? 0 : starterPokemon.hashCode());
		result = prime * result + trainerId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Trainer other = (Trainer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pokemons == null) {
			if (other.pokemons != null)
				return false;
		} else if (!pokemons.equals(other.pokemons))
			return false;
		if (starterPokemon == null) {
			if (other.starterPokemon != null)
				return false;
		} else if (!starterPokemon.equals(other.starterPokemon))
			return false;
		if (trainerId != other.trainerId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStarterPokemon() {
		return starterPokemon;
	}

	public void setStarterPokemon(String starterPokemon) {
		this.starterPokemon = starterPokemon;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
/*	@ManyToMany(orphanRemo val = true cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "trainer_id", nullable = false)
//	@Getter //do i need these getter and setter if i have them on bottom>
//@Setter
	private List<JoinTable> firstChild = new ArrayList<JoinTable>();
	//is inserting inferred type arguements ok?
	*/
	
	}

	