package br.com.demo.api.controller;

import br.com.demo.api.controller.exception.IntegerInvalidException;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/parse-int")
@RestController
public class ApiController {

    @GetMapping("/{value}")
    public ResponseEntity<?> handlerException(@PathVariable("value") String value) {

        if(NumberUtils.isParsable(value)) {
            Integer.parseInt(value);
        } else {
            throw new IntegerInvalidException("Não pode parsear o valor " + value + " não é númerico.");
        }
        return ResponseEntity.ok().build();
    }
}
