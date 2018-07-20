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
import io.swagger.configuration.Utilities;
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
		Accion accion = Utilities.getAccion(idAccion);

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
		List<Dividendo> listDividendos = new LinkedList<Dividendo>();
		listDividendos.add(Utilities.getDividendo(1));
		listDividendos.add(Utilities.getDividendo(2));
		listDividendos.add(Utilities.getDividendo(3));
		return listDividendos;
	}

	@Override
	public List<Titulo> listarTitulosAccion(@ApiParam(value = "id de la acción para listar los títulos",required=true) @PathVariable("idAccion") Long idAccion) {
		List<Titulo> listTitulos = new LinkedList<Titulo>();
		listTitulos.add(Utilities.getTitulo("titulo1"));
		listTitulos.add(Utilities.getTitulo("titulo2"));
		listTitulos.add(Utilities.getTitulo("titulo3"));
		return listTitulos;
	}
}
