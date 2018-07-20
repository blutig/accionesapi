/**
 * 
 */
package io.swagger.configuration;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.threeten.bp.OffsetDateTime;

import io.swagger.api.AccionesApi;
import io.swagger.api.ClienteApi;
import io.swagger.api.DividendoApi;
import io.swagger.api.EmisorApi;
import io.swagger.api.TituloApi;
import io.swagger.model.Accion;
import io.swagger.model.Cliente;
import io.swagger.model.Dividendo;
import io.swagger.model.Emisor;
import io.swagger.model.Titulo;

/**
 * 
 *
 */
public class Utilities {
	public static Cliente getCliente(String idCliente) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		cliente.setNombres("Pepito" + idCliente);
		cliente.setApellidos("Perez" + idCliente);
		cliente.setEmail("pepito"  + idCliente + "@gmail.com");
		cliente.setTelefono("300123456");
		cliente.setDireccion("Clle 1 # 2 - 3");
		cliente.add(linkTo(ClienteApi.class).slash(cliente.getIdCliente()).withSelfRel());
		cliente.add(linkTo(ControllerLinkBuilder.methodOn(ClienteApi.class).listarTitulosCliente(idCliente))
				.withRel("titulos"));
		return cliente;
	}
	
	public static Accion getAccion(Long idAccion) {		
		Accion accion = new Accion();
		accion.setIdAccion(idAccion);
		accion.setNombre("Acción " + idAccion);
		Emisor emisor = getEmisor("N5784125");
		accion.setEmisor(emisor);
		accion.setFechaEmision(OffsetDateTime.now());
		accion.setMoneda("COP");
		accion.setValorEmision(new BigDecimal("15400"));
		
		accion.add(linkTo(AccionesApi.class).slash(accion.getIdAccion()).withSelfRel());
		
		accion.add(linkTo(ControllerLinkBuilder.methodOn(AccionesApi.class).listarDividendosAccion(idAccion))
				.withRel("dividendos"));

		accion.add(linkTo(ControllerLinkBuilder.methodOn(AccionesApi.class).listarTitulosAccion(idAccion))
				.withRel("titulo"));

		return accion;
	}
	
	public static Emisor getEmisor(String idEmisor) {
		Emisor emisor = new Emisor();
		emisor.setIdEmisor(idEmisor);
		emisor.setNombre("Carlos");
		emisor.setApellido("Pelaez");
		emisor.add(linkTo(EmisorApi.class).slash(emisor.getIdEmisor()).withSelfRel());
		return emisor;
	}
	
	public static Titulo getTitulo(String idTitulo) {
		Titulo titulo = new Titulo();
		titulo.setEstado("Activo");
		titulo.setFechaCompra((new Date()).toString());
		titulo.setIdTitulo(idTitulo);
		titulo.setNominal((long) 12345);
		titulo.setValorCompra((long) 1547800);
		
		Cliente cliente = getCliente("ID1");
		titulo.setCliente(cliente);
		Accion accion = getAccion((long) 12345);
		titulo.setAccion(accion);
		titulo.add(linkTo(TituloApi.class).slash(titulo.getIdTitulo()).withSelfRel());
		return titulo;
	}
	
	public static Dividendo getDividendo(int idDividendo) {
		Dividendo dividendo = new Dividendo();
		dividendo.setIdDividendo(idDividendo);
		dividendo.setAccion(getAccion((long) 12345));
		dividendo.setFechaPago((new Date()).toString());
		dividendo.setMonto(547800);
		dividendo.add(linkTo(DividendoApi.class).slash(dividendo.getIdDividendo()).withSelfRel());
		return dividendo;
	}
	
}
