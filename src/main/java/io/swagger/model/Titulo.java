package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Titulo
 */
@Validated

public class Titulo extends ResourceSupport {
  @JsonProperty("idTitulo")
  private String idTitulo = null;

  @JsonProperty("accion")
  private Accion accion = null;

  @JsonProperty("cliente")
  private Cliente cliente = null;

  @JsonProperty("nominal")
  private Long nominal = null;

  @JsonProperty("valorCompra")
  private Long valorCompra = null;

  @JsonProperty("fechaCompra")
  private String fechaCompra = null;

  @JsonProperty("estado")
  private String estado = null;

  public Titulo idTitulo(String idTitulo) {
	this.idTitulo = idTitulo;
	return this;
  }

  /**
   * Get idTitulo
   * @return idTitulo
  **/
  @ApiModelProperty(example = "t1", required = true, value = "")
  @NotNull


  public String getIdTitulo() {
	return idTitulo;
  }

  public void setIdTitulo(String idTitulo) {
	this.idTitulo = idTitulo;
  }

  public Titulo accion(Accion accion) {
	this.accion = accion;
	return this;
  }

  /**
   * Get accion
   * @return accion
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Accion getAccion() {
	return accion;
  }

  public void setAccion(Accion accion) {
	this.accion = accion;
  }

  public Titulo cliente(Cliente cliente) {
	this.cliente = cliente;
	return this;
  }

  /**
   * Get cliente
   * @return cliente
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Cliente getCliente() {
	return cliente;
  }

  public void setCliente(Cliente cliente) {
	this.cliente = cliente;
  }

  public Titulo nominal(Long nominal) {
	this.nominal = nominal;
	return this;
  }

  /**
   * Get nominal
   * @return nominal
  **/
  @ApiModelProperty(example = "1000", required = true, value = "")
  @NotNull


  public Long getNominal() {
	return nominal;
  }

  public void setNominal(Long nominal) {
	this.nominal = nominal;
  }

  public Titulo valorCompra(Long valorCompra) {
	this.valorCompra = valorCompra;
	return this;
  }

  /**
   * Get valorCompra
   * @return valorCompra
  **/
  @ApiModelProperty(example = "2000", required = true, value = "")
  @NotNull


  public Long getValorCompra() {
	return valorCompra;
  }

  public void setValorCompra(Long valorCompra) {
	this.valorCompra = valorCompra;
  }

  public Titulo fechaCompra(String fechaCompra) {
	this.fechaCompra = fechaCompra;
	return this;
  }

  /**
   * Get fechaCompra
   * @return fechaCompra
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")
  @NotNull


  public String getFechaCompra() {
	return fechaCompra;
  }

  public void setFechaCompra(String fechaCompra) {
	this.fechaCompra = fechaCompra;
  }

  public Titulo estado(String estado) {
	this.estado = estado;
	return this;
  }

  /**
   * Get estado
   * @return estado
  **/
  @ApiModelProperty(example = "Activo", required = true, value = "")
  @NotNull


  public String getEstado() {
	return estado;
  }

  public void setEstado(String estado) {
	this.estado = estado;
  }


  @Override
  public boolean equals(java.lang.Object o) {
	if (this == o) {
	  return true;
	}
	if (o == null || getClass() != o.getClass()) {
	  return false;
	}
	Titulo titulo = (Titulo) o;
	return Objects.equals(this.idTitulo, titulo.idTitulo) &&
		Objects.equals(this.accion, titulo.accion) &&
		Objects.equals(this.cliente, titulo.cliente) &&
		Objects.equals(this.nominal, titulo.nominal) &&
		Objects.equals(this.valorCompra, titulo.valorCompra) &&
		Objects.equals(this.fechaCompra, titulo.fechaCompra) &&
		Objects.equals(this.estado, titulo.estado);
  }

  @Override
  public int hashCode() {
	return Objects.hash(idTitulo, accion, cliente, nominal, valorCompra, fechaCompra, estado);
  }

  @Override
  public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("class Titulo {\n");
	
	sb.append("	idTitulo: ").append(toIndentedString(idTitulo)).append("\n");
	sb.append("	accion: ").append(toIndentedString(accion)).append("\n");
	sb.append("	cliente: ").append(toIndentedString(cliente)).append("\n");
	sb.append("	nominal: ").append(toIndentedString(nominal)).append("\n");
	sb.append("	valorCompra: ").append(toIndentedString(valorCompra)).append("\n");
	sb.append("	fechaCompra: ").append(toIndentedString(fechaCompra)).append("\n");
	sb.append("	estado: ").append(toIndentedString(estado)).append("\n");
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

