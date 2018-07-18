package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Accion;
import io.swagger.model.Cliente;
import io.swagger.model.Dividendo;
import io.swagger.model.Emisor;
import io.swagger.model.Titulo;

@Controller
public class AccionesApiController implements AccionesApi {

	private static final Logger log = LoggerFactory.getLogger(AccionesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	/**
	 * 
	 * @param idAccion
	 * @return
	 */
	private Accion getAccion(Long idAccion) {
		Emisor emisor = new Emisor();
		emisor.setIdEmisor("N5784125");
		emisor.setNombre("Carlos");
		emisor.setApellido("Pelaez");
		
		emisor.add(linkTo(EmisorApi.class).slash(emisor.getIdEmisor()).withSelfRel());
		
		Accion accion = new Accion();
		accion.setIdAccion(idAccion);
		accion.setNombre("Acción " + idAccion);
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
	
	@org.springframework.beans.factory.annotation.Autowired
	public AccionesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarAccion(@ApiParam(value = "id de la acción a agregar",required=true) @PathVariable("idAccion") Long idAccion,@ApiParam(value = "Acción a agregar") @Valid @RequestBody Accion accion) {
		String accept = request.getHeader("Accept");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Accion> buscarAccion(@ApiParam(value = "id de la acción a buscar",required=true) @PathVariable("idAccion") Long idAccion) {
		Accion accion = getAccion(idAccion);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");

		return new ResponseEntity<Accion>(accion, httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Void> eliminarAccion(@ApiParam(value = "ID de la acción a eliminar",required=true) @PathVariable("idAccion") Long idAccion) {
		String accept = request.getHeader("Accept");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	@Override
	public List<Dividendo> listarDividendosAccion(@ApiParam(value = "id de la acción para listar los dividendos",required=true) @PathVariable("idAccion") Long idAccion) {
		Accion accion = getAccion(idAccion);

		List<Dividendo> listDividendos = new LinkedList<Dividendo>();
		Dividendo dividendo1 = new Dividendo();
		dividendo1.setIdDividendo(1);
		dividendo1.setAccion(accion);
		dividendo1.setFechaPago((new Date()).toString());
		dividendo1.setMonto(547800);

		Dividendo dividendo2 = new Dividendo();
		dividendo2.setIdDividendo(2);
		dividendo2.setAccion(accion);
		dividendo2.setFechaPago((new Date()).toString());
		dividendo2.setMonto(97800);

		Dividendo dividendo3 = new Dividendo();
		dividendo3.setIdDividendo(3);
		dividendo3.setAccion(accion);
		dividendo3.setFechaPago((new Date()).toString());
		dividendo3.setMonto(1547800);

		listDividendos.add(dividendo1);
		listDividendos.add(dividendo2);
		listDividendos.add(dividendo3);

		for (Dividendo dividendo : listDividendos) {
			dividendo.add(linkTo(DividendoApi.class).slash(dividendo.getIdDividendo()).withSelfRel());
		}
		return listDividendos;
	}

	@Override
	public List<Titulo> listarTitulosAccion(@ApiParam(value = "id de la acción para listar los títulos",required=true) @PathVariable("idAccion") Long idAccion) {
		Accion accion = getAccion(idAccion);
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente("CC87654");
		cliente.setNombres("Eugenio");
		cliente.setApellidos("Quintero");
		cliente.setDireccion("Calle 54 # 34 - 1");
		cliente.setEmail("equintero@micorreo.com");
		cliente.setTelefono("2222222");

		List<Titulo> listTitulos = new LinkedList<Titulo>();
		Titulo titulo1 = new Titulo();
		titulo1.setIdTitulo("1");
		titulo1.setAccion(accion);
		titulo1.setCliente(cliente);
		titulo1.setNominal(15471240L);
		titulo1.setValorCompra(471240L);
		titulo1.setFechaCompra((new Date()).toString());
		titulo1.setEstado("Activo");

		Titulo titulo2 = new Titulo();
		titulo2.setIdTitulo("2");
		titulo2.setAccion(accion);
		titulo2.setCliente(cliente);
		titulo2.setNominal(15471240L);
		titulo2.setValorCompra(471240L);
		titulo2.setFechaCompra((new Date()).toString());
		titulo2.setEstado("Activo");

		listTitulos.add(titulo1);
		listTitulos.add(titulo2);

		for (Titulo titulo : listTitulos) {
			titulo.add(linkTo(TituloApi.class).slash(titulo.getIdTitulo()).withSelfRel());
		}
		return listTitulos;
	}
}
