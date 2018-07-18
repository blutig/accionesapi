package io.swagger.api;

import io.swagger.model.Accion;
import io.swagger.model.Dividendo;
import io.swagger.model.Emisor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
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
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class AccionesApiController implements AccionesApi {

	private static final Logger log = LoggerFactory.getLogger(AccionesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AccionesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarAccion(@ApiParam(value = "id de la acción a agregar",required=true) @PathVariable("idAccion") String idAccion,@ApiParam(value = "Acción a agregar"  )  @Valid @RequestBody Accion accion) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Accion> buscarAccion(@ApiParam(value = "id de la acción a buscar",required=true) @PathVariable("idAccion") Long idAccion) {
		Emisor emisor = new Emisor();
		
		Accion accion = new Accion();
		accion.setIdAccion(idAccion);
		accion.setNombre("Acción " + idAccion);
		accion.setEmisor(emisor);
		accion.setFechaEmision(OffsetDateTime.now());
		accion.setMoneda("COP");
		accion.setValorEmision(new BigDecimal("15400"));
		
		accion.add(linkTo(AccionesApi.class).slash(accion.getIdAccion()).withSelfRel());
		

		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		
		return new ResponseEntity<Accion>(accion, httpHeaders, HttpStatus.OK);
		
	}

	public ResponseEntity<Void> eliminarAccion(@ApiParam(value = "ID de la acción a eliminar",required=true) @PathVariable("idAccion") Integer idAccion) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
