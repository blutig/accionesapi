/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Emisor;

@Api(value = "emisor", description = "the emisor API")
@RequestMapping(value = "/emisor", produces = { "application/json" })
public interface EmisorApi {

	@ApiOperation(value = "agregar un nuevo emisor", nickname = "agregarEmisor", notes = "Agregar un nuevo emisor", tags={ "administradores", })
	@ApiResponses(value = { 
		@ApiResponse(code = 201, message = "Emisor creado"),
		@ApiResponse(code = 400, message = "objeto invalido"),
		@ApiResponse(code = 409, message = "ya existe un emisor con este id") })
	@RequestMapping(value = "/{idEmisor}",
		produces = { "application/json" }, 
		consumes = { "application/json" },
		method = RequestMethod.POST)
	ResponseEntity<Void> agregarEmisor(@ApiParam(value = "id del emisor a buscar",required=true) @PathVariable("idEmisor") String idEmisor,@ApiParam(value = "torneo a agregar"  )  @Valid @RequestBody Emisor torneo);


	@ApiOperation(value = "busca emisor", nickname = "buscarEmisor", notes = "Enviando un id de emisor devuelve la informacion correspondiente a este ", response = Emisor.class, tags={ "administradores", })
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Devuelver el resultado obtenido", response = Emisor.class),
		@ApiResponse(code = 400, message = "parametro incorrecto") })
	@RequestMapping(value = "/{idEmisor}",
		produces = { "application/json" }, 
		method = RequestMethod.GET)
	ResponseEntity<Emisor> buscarEmisor(@ApiParam(value = "id del emisor a buscar",required=true) @PathVariable("idEmisor") String idEmisor);


	@ApiOperation(value = "eliminar un emisor", nickname = "eliminarEmisor", notes = "Eliminar un emisor", tags={ "administradores", })
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 400, message = "invalido id"),
		@ApiResponse(code = 404, message = "id no encontrado") })
	@RequestMapping(value = "/{idEmisor}",
		produces = { "application/json" }, 
		method = RequestMethod.DELETE)
	ResponseEntity<Void> eliminarEmisor(@ApiParam(value = "id del emisor a eliminar",required=false) @PathVariable("idEmisor") String idEmisor);
	
	@ApiOperation(value = "Listar Emisores", nickname = "listarEmisores", notes = " devuelve la lista de emisores", response = List.class, tags={ "administradores", })
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "devolver el resultado obtenido", response = List.class),
		@ApiResponse(code = 400, message = "Objeto invalido") })
	@RequestMapping(value = "",
		method = RequestMethod.GET)
	@ResponseBody  List<Emisor> listarEmisores();

}