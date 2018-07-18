package io.swagger.api;

import io.swagger.model.Accion;
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Accion>(objectMapper.readValue("{  \"valorEmision\" : 15000.0,  \"idAccion\" : 12345,  \"moneda\" : \"COP\",  \"fechaEmision\" : \"2018-07-17T08:31:33.001Z\",  \"nombre\" : \"Porcína Gagoquivavel\",  \"emisor\" : {    \"apellido\" : \"Quintero\",    \"idEmisor\" : \"e1\",    \"nombre\" : \"Lina\"  }}", Accion.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Accion>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Accion>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> eliminarAccion(@ApiParam(value = "ID de la acción a eliminar",required=true) @PathVariable("idAccion") Integer idAccion) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
