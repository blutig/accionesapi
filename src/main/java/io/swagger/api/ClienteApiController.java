package io.swagger.api;

import io.swagger.model.Accion;
import io.swagger.model.Cliente;
import io.swagger.model.Emisor;
import io.swagger.model.Titulo;

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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ClienteApiController implements ClienteApi {

	private static final Logger log = LoggerFactory.getLogger(ClienteApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ClienteApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarCliente(@ApiParam(value = "id del tliente a agregar",required=true) @PathVariable("idCliente") String idCliente,@ApiParam(value = "cliente a agregar"  )  @Valid @RequestBody Cliente cliente) {
		String accept = request.getHeader("Accept");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Cliente> buscarCliente(@ApiParam(value = "id del cliente a buscar",required=true) @PathVariable("idCliente") String idCliente) {
		Cliente cliente = Utilities.getCliente(idCliente);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");

		return new ResponseEntity<Cliente>(cliente, httpHeaders, HttpStatus.OK);
	}

	public ResponseEntity<Void> eliminarCliente(@ApiParam(value = "id del cliente a eliminar",required=true) @PathVariable("idCliente") String idCliente) {
		String accept = request.getHeader("Accept");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
	}

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> listClientes = new LinkedList<Cliente>();
		listClientes.add(Utilities.getCliente("ID1"));
		listClientes.add(Utilities.getCliente("ID2"));
		listClientes.add(Utilities.getCliente("ID3"));
		listClientes.add(Utilities.getCliente("ID4"));
		return listClientes;
	}

	@Override
	public List<Titulo> listarTitulosCliente(String idCliente) {
		List<Titulo> listTitulos = new LinkedList<Titulo>();
		listTitulos.add(Utilities.getTitulo("Titulo1"));
		listTitulos.add(Utilities.getTitulo("Titulo2"));
		listTitulos.add(Utilities.getTitulo("Titulo3"));
		return listTitulos;
	}

}
