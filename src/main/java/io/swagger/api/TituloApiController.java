package io.swagger.api;

import io.swagger.model.Titulo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Titulo> buscarTitulo(@ApiParam(value = "id del título a buscar",required=true) @PathVariable("idTitulo") String idTitulo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Titulo>(objectMapper.readValue("{  \"accion\" : {    \"valorEmision\" : 15000.0,    \"idAccion\" : 12345,    \"moneda\" : \"COP\",    \"fechaEmision\" : \"2018-07-17T08:31:33.001Z\",    \"nombre\" : \"Porcína Gagoquivavel\",    \"emisor\" : {      \"apellido\" : \"Quintero\",      \"idEmisor\" : \"e1\",      \"nombre\" : \"Lina\"    }  },  \"cliente\" : {    \"apellidos\" : \"Vargas\",    \"idCliente\" : \"12345\",    \"direccion\" : \"Clle 1\",    \"telefono\" : \"123456789\",    \"email\" : \"cliente1@gmail.com\",    \"nombres\" : \"Rafael\"  },  \"fechaCompra\" : \"2016-08-29T09:12:33.001Z\",  \"estado\" : \"Activo\",  \"nominal\" : 1000,  \"valorCompra\" : 2000,  \"idTitulo\" : \"t1\"}", Titulo.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Titulo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Titulo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> eliminarTitulo(@ApiParam(value = "id del título a eliminar",required=true) @PathVariable("idTitulo") String idTitulo) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
