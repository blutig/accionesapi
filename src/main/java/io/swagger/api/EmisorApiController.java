package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Utilities;
import io.swagger.model.Emisor;

@Controller
public class EmisorApiController implements EmisorApi {

	private static final Logger log = LoggerFactory.getLogger(EmisorApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public EmisorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarEmisor(
			@ApiParam(value = "id del emisor a buscar", required = true) @PathVariable("idEmisor") String idEmisor,
			@ApiParam(value = "torneo a agregar") @Valid @RequestBody Emisor emisor) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(1000);
		httpHeaders.set("Miheader", "valor x");

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Emisor> buscarEmisor(
			@ApiParam(value = "id del emisor a buscar", required = true) @PathVariable("idEmisor") String idEmisor) {
		Emisor emisor = Utilities.getEmisor("Emisor1");
		HttpStatus status = null;
		status = HttpStatus.OK;
		HttpHeaders responseHeaders = new HttpHeaders();
    	responseHeaders.setExpires(1000);
    	responseHeaders.set("Miheader", "valor x");
		return new ResponseEntity<Emisor>(emisor, responseHeaders, status);
	}

	public ResponseEntity<Void> eliminarEmisor(
			@ApiParam(value = "id del emisor a eliminar", required = true) @PathVariable("idEmisor") String idEmisor) {

		HttpHeaders responseHeaders = new HttpHeaders();
    	responseHeaders.setExpires(1000);
    	responseHeaders.set("Miheader", "valor x");

		return new ResponseEntity<Void>(responseHeaders, HttpStatus.OK);
	}

	public List<Emisor> listarEmisores() {

		List<Emisor> listEmisores = new LinkedList<Emisor>();

		listEmisores.add(new Emisor("e4", "Maria", "Calvo"));
		listEmisores.add(new Emisor("e5", "Antonia", "Perez"));
		listEmisores.add(new Emisor("e6", "Ana", "Caldas"));
		listEmisores.add(new Emisor("e7", "Alberto", "Castro"));

		for (Emisor emisor : listEmisores) {
			emisor.add(linkTo(EmisorApi.class).slash(emisor.getIdEmisor()).withSelfRel());
		}
		return listEmisores;
	}

}
