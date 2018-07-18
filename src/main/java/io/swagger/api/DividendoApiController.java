package io.swagger.api;

import io.swagger.model.Dividendo;
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
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Dividendo>(objectMapper.readValue("{  \"accion\" : {    \"valorEmision\" : 15000.0,    \"idAccion\" : 12345,    \"moneda\" : \"COP\",    \"fechaEmision\" : \"2018-07-17T08:31:33.001Z\",    \"nombre\" : \"Porcína Gagoquivavel\",    \"emisor\" : {      \"apellido\" : \"Quintero\",      \"idEmisor\" : \"e1\",      \"nombre\" : \"Lina\"    }  },  \"monto\" : 200,  \"idDividendo\" : 123,  \"fechaPago\" : \"2016-08-29T09:12:33.001Z\"}", Dividendo.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Dividendo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Dividendo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> eliminarDividendo(@ApiParam(value = "ID del dividendo a eliminar",required=true) @PathVariable("idDividendo") Long idDividendo) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
