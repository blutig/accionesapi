package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Accion
 */
@Validated

public class Accion  extends ResourceSupport {
  @JsonProperty("idAccion")
  private Long idAccion = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("emisor")
  private Emisor emisor = null;

  @JsonProperty("fechaEmision")
  private OffsetDateTime fechaEmision = null;

  @JsonProperty("moneda")
  private String moneda = null;

  @JsonProperty("valorEmision")
  private BigDecimal valorEmision = null;

  public Accion idAccion(Long idAccion) {
	this.idAccion = idAccion;
	return this;
  }

  /**
   * Get idAccion
   * @return idAccion
  **/
  @ApiModelProperty(example = "12345", required = true, value = "")
  @NotNull


  public Long getIdAccion() {
	return idAccion;
  }

  public void setIdAccion(Long idAccion) {
	this.idAccion = idAccion;
  }

  public Accion nombre(String nombre) {
	this.nombre = nombre;
	return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(example = "Porcína Gagoquivavel", required = true, value = "")
  @NotNull


  public String getNombre() {
	return nombre;
  }

  public void setNombre(String nombre) {
	this.nombre = nombre;
  }

  public Accion emisor(Emisor emisor) {
	this.emisor = emisor;
	return this;
  }

  /**
   * Get emisor
   * @return emisor
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Emisor getEmisor() {
	return emisor;
  }

  public void setEmisor(Emisor emisor) {
	this.emisor = emisor;
  }

  public Accion fechaEmision(OffsetDateTime fechaEmision) {
	this.fechaEmision = fechaEmision;
	return this;
  }

  /**
   * Get fechaEmision
   * @return fechaEmision
  **/
  @ApiModelProperty(example = "2018-07-17T08:31:33.001Z", required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getFechaEmision() {
	return fechaEmision;
  }

  public void setFechaEmision(OffsetDateTime fechaEmision) {
	this.fechaEmision = fechaEmision;
  }

  public Accion moneda(String moneda) {
	this.moneda = moneda;
	return this;
  }

  /**
   * Get moneda
   * @return moneda
  **/
  @ApiModelProperty(example = "COP", required = true, value = "")
  @NotNull


  public String getMoneda() {
	return moneda;
  }

  public void setMoneda(String moneda) {
	this.moneda = moneda;
  }

  public Accion valorEmision(BigDecimal valorEmision) {
	this.valorEmision = valorEmision;
	return this;
  }

  /**
   * Get valorEmision
   * @return valorEmision
  **/
  @ApiModelProperty(example = "15000.0", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getValorEmision() {
	return valorEmision;
  }

  public void setValorEmision(BigDecimal valorEmision) {
	this.valorEmision = valorEmision;
  }


  @Override
  public boolean equals(java.lang.Object o) {
	if (this == o) {
	  return true;
	}
	if (o == null || getClass() != o.getClass()) {
	  return false;
	}
	Accion accion = (Accion) o;
	return Objects.equals(this.idAccion, accion.idAccion) &&
		Objects.equals(this.nombre, accion.nombre) &&
		Objects.equals(this.emisor, accion.emisor) &&
		Objects.equals(this.fechaEmision, accion.fechaEmision) &&
		Objects.equals(this.moneda, accion.moneda) &&
		Objects.equals(this.valorEmision, accion.valorEmision);
  }

  @Override
  public int hashCode() {
	return Objects.hash(idAccion, nombre, emisor, fechaEmision, moneda, valorEmision);
  }

  @Override
  public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("class Accion {\n");
	
	sb.append("	idAccion: ").append(toIndentedString(idAccion)).append("\n");
	sb.append("	nombre: ").append(toIndentedString(nombre)).append("\n");
	sb.append("	emisor: ").append(toIndentedString(emisor)).append("\n");
	sb.append("	fechaEmision: ").append(toIndentedString(fechaEmision)).append("\n");
	sb.append("	moneda: ").append(toIndentedString(moneda)).append("\n");
	sb.append("	valorEmision: ").append(toIndentedString(valorEmision)).append("\n");
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

