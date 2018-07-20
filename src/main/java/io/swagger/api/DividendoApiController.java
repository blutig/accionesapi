package io.swagger.api;

import io.swagger.model.Cliente;
import io.swagger.model.Dividendo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.configuration.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class DividendoApiController implements DividendoApi {

	private static final Logger log = LoggerFactory.getLogger(DividendoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public DividendoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> adicionarDividendo(@ApiParam(value = "id del dividendo a buscar",required=true) @PathVariable("idDividendo") Long idDividendo,@ApiParam(value = "Información del dividendo"  )  @Valid @RequestBody Dividendo dividendo) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Dividendo> buscarDividendo(@ApiParam(value = "id del dividendo a buscar",required=true) @PathVariable("idDividendo") Long idDividendo) {
		String accept = request.getHeader("Accept");
		Dividendo dividendo = Utilities.getDividendo(1);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");

		return new ResponseEntity<Dividendo>(dividendo, httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Void> eliminarDividendo(@ApiParam(value = "ID del dividendo a eliminar",required=true) @PathVariable("idDividendo") Long idDividendo) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
