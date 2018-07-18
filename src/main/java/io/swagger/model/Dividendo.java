package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Dividendo
 */
@Validated

public class Dividendo   {
  @JsonProperty("idDividendo")
  private Integer idDividendo = null;

  @JsonProperty("accion")
  private Accion accion = null;

  @JsonProperty("fechaPago")
  private String fechaPago = null;

  @JsonProperty("monto")
  private Integer monto = null;

  public Dividendo idDividendo(Integer idDividendo) {
	this.idDividendo = idDividendo;
	return this;
  }

  /**
   * Get idDividendo
   * @return idDividendo
  **/
  @ApiModelProperty(example = "123", required = true, value = "")
  @NotNull


  public Integer getIdDividendo() {
	return idDividendo;
  }

  public void setIdDividendo(Integer idDividendo) {
	this.idDividendo = idDividendo;
  }

  public Dividendo accion(Accion accion) {
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

  public Dividendo fechaPago(String fechaPago) {
	this.fechaPago = fechaPago;
	return this;
  }

  /**
   * Get fechaPago
   * @return fechaPago
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")
  @NotNull


  public String getFechaPago() {
	return fechaPago;
  }

  public void setFechaPago(String fechaPago) {
	this.fechaPago = fechaPago;
  }

  public Dividendo monto(Integer monto) {
	this.monto = monto;
	return this;
  }

  /**
   * Get monto
   * @return monto
  **/
  @ApiModelProperty(example = "200", required = true, value = "")
  @NotNull


  public Integer getMonto() {
	return monto;
  }

  public void setMonto(Integer monto) {
	this.monto = monto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
	if (this == o) {
	  return true;
	}
	if (o == null || getClass() != o.getClass()) {
	  return false;
	}
	Dividendo dividendo = (Dividendo) o;
	return Objects.equals(this.idDividendo, dividendo.idDividendo) &&
		Objects.equals(this.accion, dividendo.accion) &&
		Objects.equals(this.fechaPago, dividendo.fechaPago) &&
		Objects.equals(this.monto, dividendo.monto);
  }

  @Override
  public int hashCode() {
	return Objects.hash(idDividendo, accion, fechaPago, monto);
  }

  @Override
  public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("class Dividendo {\n");
	
	sb.append("	idDividendo: ").append(toIndentedString(idDividendo)).append("\n");
	sb.append("	accion: ").append(toIndentedString(accion)).append("\n");
	sb.append("	fechaPago: ").append(toIndentedString(fechaPago)).append("\n");
	sb.append("	monto: ").append(toIndentedString(monto)).append("\n");
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

