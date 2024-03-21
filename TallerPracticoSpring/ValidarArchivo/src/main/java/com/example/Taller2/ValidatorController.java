package com.example.Taller2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ValidatorController {

    ValidatorService service = new ValidatorService();

    @PostMapping("/validate-data")
    public String almacenarRuta(@RequestBody() String rutaNueva) {
        return service.validateData(rutaNueva);
    }

}