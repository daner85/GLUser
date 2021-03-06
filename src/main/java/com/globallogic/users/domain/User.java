package com.globallogic.users.domain;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private UUID id;
	@NotNull(message = "Por favor ingresa el nombre") private  String name;
	@Email(message = "Correo con formato incorrecto")
	private final String email;
	@Pattern(
		      regexp = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z]).{8}$",
		      message = "Una may�scula, letras min�sculas, dos n�meros, largo 8")
	private final String password;
	private Token token;
	private List<Phones> phones;
	
	@JsonCreator
	public User(@NotNull(message = "Please provide a author") @JsonProperty("name") final  String name, @JsonProperty("email") final  String email,@JsonProperty("password") final  String password, @JsonProperty("phones") final List<Phones> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.token = new Token();
		this.phones = phones;
	}

	public UUID getId() {
		return id;
	}

	public Token getToken() {
		return token;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Phones> getPhones() {
		return phones;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", token=" + token
				+ ", phones=" + phones + "]";
	}

	
}
