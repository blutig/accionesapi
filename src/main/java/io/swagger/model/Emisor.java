package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Emisor
 */
@Validated

public class Emisor   {
  @JsonProperty("idEmisor")
  private String idEmisor = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("apellido")
  private String apellido = null;

  public Emisor idEmisor(String idEmisor) {
    this.idEmisor = idEmisor;
    return this;
  }

  /**
   * Get idEmisor
   * @return idEmisor
  **/
  @ApiModelProperty(example = "e1", required = true, value = "")
  @NotNull


  public String getIdEmisor() {
    return idEmisor;
  }

  public void setIdEmisor(String idEmisor) {
    this.idEmisor = idEmisor;
  }

  public Emisor nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(example = "Lina", required = true, value = "")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Emisor apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  **/
  @ApiModelProperty(example = "Quintero", required = true, value = "")
  @NotNull


  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Emisor emisor = (Emisor) o;
    return Objects.equals(this.idEmisor, emisor.idEmisor) &&
        Objects.equals(this.nombre, emisor.nombre) &&
        Objects.equals(this.apellido, emisor.apellido);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmisor, nombre, apellido);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Emisor {\n");
    
    sb.append("    idEmisor: ").append(toIndentedString(idEmisor)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
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
    return o.toString().replace("\n", "\n    ");
  }
}

