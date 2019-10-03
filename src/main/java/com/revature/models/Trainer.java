package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Trainer implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainerId")

	private Integer trainerId;
	private String firstName;
	private String lastName;
    @NotBlank
	private String userName;
	@Size(min=4, max=8)
	private String password;
	private String starterPokemon;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="Poke_List",
			joinColumns={@JoinColumn(name="trainerId")},
			inverseJoinColumns={@JoinColumn(name="pokemonId")})
	private List<Pokemon> pokelist = new ArrayList<>();

	public Trainer() {
		super();
	}
	//FOR LOGIN
		public Trainer(String userName, String password) {
			super();
			this.trainerId= 0;
			this.userName = userName;
			this.password= password;
		}
		public Trainer (String userName) {
			super();
			this.userName = userName;
		}
	public Trainer(Integer trainerId, String firstName, String lastName, String userName, String password,
			String starterPokemon, List<Pokemon> pokelist) {
		super();
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.starterPokemon = starterPokemon;
		this.pokelist = pokelist;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStarterPokemon() {
		return starterPokemon;
	}

	public void setStarterPokemon(String starterPokemon) {
		this.starterPokemon = starterPokemon;
	}

	public List<Pokemon> getPokelist() {
		return pokelist;
	}

	public void setPokelist(List<Pokemon> pokelist) {
		this.pokelist = pokelist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pokelist == null) ? 0 : pokelist.hashCode());
		result = prime * result + ((starterPokemon == null) ? 0 : starterPokemon.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pokelist == null) {
			if (other.pokelist != null)
				return false;
		} else if (!pokelist.equals(other.pokelist))
			return false;
		if (starterPokemon == null) {
			if (other.starterPokemon != null)
				return false;
		} else if (!starterPokemon.equals(other.starterPokemon))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", starterPokemon=" + starterPokemon + ", pokelist=" + pokelist
				+ "]";
	}

	





	
}