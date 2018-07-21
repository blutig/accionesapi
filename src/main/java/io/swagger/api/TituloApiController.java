package io.swagger.api;

import java.math.BigDecimal;
import java.util.Date;

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
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Accion;
import io.swagger.model.Cliente;
import io.swagger.model.Titulo;

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
		
		Accion accion = new Accion();
		Long idAccion = 1000000L;
		accion.setIdAccion(idAccion);
		accion.setNombre("Acción " + idAccion);
		accion.setFechaEmision(OffsetDateTime.now());
		accion.setMoneda("COP");
		accion.setValorEmision(new BigDecimal("15400"));
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente("CC87654");
		cliente.setNombres("Eugenio");
		cliente.setApellidos("Quintero");
		cliente.setDireccion("Calle 54 # 34 - 1");
		cliente.setEmail("equintero@micorreo.com");
		cliente.setTelefono("2222222");

		Titulo titulo = new Titulo();
		titulo.setIdTitulo("1");
		titulo.setAccion(accion);
		titulo.setCliente(cliente);
		titulo.setNominal(15471240L);
		titulo.setValorCompra(471240L);
		titulo.setFechaCompra((new Date()).toString());
		

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("MiHeader", "valor x");

        return new ResponseEntity<Titulo>(titulo,responseHeaders,HttpStatus.OK);
	}

	public ResponseEntity<Void> eliminarTitulo(@ApiParam(value = "id del título a eliminar",required=true) @PathVariable("idTitulo") String idTitulo) {
		
		String accept = request.getHeader("Accept");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(2000);
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Accept", accept);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
		
	}

}