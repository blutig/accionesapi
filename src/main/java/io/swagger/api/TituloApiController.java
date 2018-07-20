package io.swagger.api;

import io.swagger.model.Accion;
import io.swagger.model.Cliente;
import io.swagger.model.Emisor;
import io.swagger.model.Titulo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.threeten.bp.OffsetDateTime;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class TituloApiController implements TituloApi {

	private static final Logger log = LoggerFactory.getLogger(TituloApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TituloApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarTitulo(@ApiParam(value = "id del título a agregar",required=true) @PathVariable("idTitulo") String idTitulo,@ApiParam(value = "título a agregar"  )  @Valid @RequestBody Titulo titulo) {
		String accept = request.getHeader("Accept");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Titulo> buscarTitulo(@ApiParam(value = "id del título a buscar",required=true) @PathVariable("idTitulo") String idTitulo) {
		Titulo titulo = getTitulo(idTitulo);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		return new ResponseEntity<Titulo>(titulo, httpHeaders, HttpStatus.OK);
	}

	private Titulo getTitulo(String idTitulo) {
		Titulo titulo = new Titulo();
		titulo.setEstado("Activo");
		titulo.setFechaCompra((new Date()).toString());
		titulo.setIdTitulo(idTitulo);
		titulo.setNominal((long) 12345);
		titulo.setValorCompra((long) 1547800);
		
		Cliente cliente = new Cliente("ID1", "Pepito1", "Perez1", "Clle 1 # 2 - 2", "pepito1@gmailcom", "123456789");
		cliente.add(linkTo(ClienteApi.class).slash(cliente.getIdCliente()).withSelfRel());
		titulo.setCliente(cliente);
		Accion accion = getAccion((long) 12345);
		titulo.setAccion(accion);
		return titulo;
	}
	
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

	public ResponseEntity<Void> eliminarTitulo(@ApiParam(value = "id del título a eliminar",required=true) @PathVariable("idTitulo") String idTitulo) {
		String accept = request.getHeader("Accept");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	@Override
	public List<Titulo> listarTitulos() {
		List<Titulo> listTitulos = new LinkedList<Titulo>();
		listTitulos.add(getTitulo("titulo1"));
		listTitulos.add(getTitulo("titulo2"));
		listTitulos.add(getTitulo("titulo3"));
		for (Titulo titulo : listTitulos) {
			titulo.add(linkTo(Titulo.class).slash(titulo.getIdTitulo()).withSelfRel());
		}
		return listTitulos;
	}

	@Override
	public Accion listarAcionTitulo() {
		Accion accion = new Accion();
		return accion;
	}

}

