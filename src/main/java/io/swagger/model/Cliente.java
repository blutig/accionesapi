package io.swagger.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Cliente
 */
@Validated

public class Cliente   {
  public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

public Cliente(String idCliente, String nombres, String apellidos, String direccion, String email,
			String telefono) {
		super();
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}

@JsonProperty("idCliente")
  private String idCliente = null;

  @JsonProperty("nombres")
  private String nombres = null;

  @JsonProperty("apellidos")
  private String apellidos = null;

  @JsonProperty("direccion")
  private String direccion = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("telefono")
  private String telefono = null;

  public Cliente idCliente(String idCliente) {
	this.idCliente = idCliente;
	return this;
  }

  /**
   * Get idCliente
   * @return idCliente
  **/
  @ApiModelProperty(example = "12345", required = true, value = "")
  @NotNull


  public String getIdCliente() {
	return idCliente;
  }

  public void setIdCliente(String idCliente) {
	this.idCliente = idCliente;
  }

  public Cliente nombres(String nombres) {
	this.nombres = nombres;
	return this;
  }

  /**
   * Get nombres
   * @return nombres
  **/
  @ApiModelProperty(example = "Rafael", required = true, value = "")
  @NotNull


  public String getNombres() {
	return nombres;
  }

  public void setNombres(String nombres) {
	this.nombres = nombres;
  }

  public Cliente apellidos(String apellidos) {
	this.apellidos = apellidos;
	return this;
  }

  /**
   * Get apellidos
   * @return apellidos
  **/
  @ApiModelProperty(example = "Vargas", required = true, value = "")
  @NotNull


  public String getApellidos() {
	return apellidos;
  }

  public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
  }

  public Cliente direccion(String direccion) {
	this.direccion = direccion;
	return this;
  }

  /**
   * Get direccion
   * @return direccion
  **/
  @ApiModelProperty(example = "Clle 1", required = true, value = "")
  @NotNull


  public String getDireccion() {
	return direccion;
  }

  public void setDireccion(String direccion) {
	this.direccion = direccion;
  }

  public Cliente email(String email) {
	this.email = email;
	return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "cliente1@gmail.com", required = true, value = "")
  @NotNull


  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public Cliente telefono(String telefono) {
	this.telefono = telefono;
	return this;
  }

  /**
   * Get telefono
   * @return telefono
  **/
  @ApiModelProperty(example = "123456789", required = true, value = "")
  @NotNull


  public String getTelefono() {
	return telefono;
  }

  public void setTelefono(String telefono) {
	this.telefono = telefono;
  }


  @Override
  public boolean equals(java.lang.Object o) {
	if (this == o) {
	  return true;
	}
	if (o == null || getClass() != o.getClass()) {
	  return false;
	}
	Cliente cliente = (Cliente) o;
	return Objects.equals(this.idCliente, cliente.idCliente) &&
		Objects.equals(this.nombres, cliente.nombres) &&
		Objects.equals(this.apellidos, cliente.apellidos) &&
		Objects.equals(this.direccion, cliente.direccion) &&
		Objects.equals(this.email, cliente.email) &&
		Objects.equals(this.telefono, cliente.telefono);
  }

  @Override
  public int hashCode() {
	return Objects.hash(idCliente, nombres, apellidos, direccion, email, telefono);
  }

  @Override
  public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("class Cliente {\n");
	
	sb.append("	idCliente: ").append(toIndentedString(idCliente)).append("\n");
	sb.append("	nombres: ").append(toIndentedString(nombres)).append("\n");
	sb.append("	apellidos: ").append(toIndentedString(apellidos)).append("\n");
	sb.append("	direccion: ").append(toIndentedString(direccion)).append("\n");
	sb.append("	email: ").append(toIndentedString(email)).append("\n");
	sb.append("	telefono: ").append(toIndentedString(telefono)).append("\n");
	sb.append("}");
	return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
	if (o == null) {
	  return "null";
	}
	return o.toString().replace("\n", "\n	");
  }
}

