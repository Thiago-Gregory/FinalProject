package thiagoyasmin.releasedconsoles.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Thiago Araújo
 * @author Yasmin Luzia
 * @since 01/05/2020
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "Hello! Nice to see you!";
    }

}
