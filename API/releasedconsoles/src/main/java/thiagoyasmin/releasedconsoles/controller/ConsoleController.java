package thiagoyasmin.releasedconsoles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thiagoyasmin.releasedconsoles.model.ConsoleEntity;
import thiagoyasmin.releasedconsoles.repository.ConsoleRepository;

import java.util.List;

/**
 * @author Thiago Araújo
 * @author Yasmin Luzia
 * @since 01/05/2020
 * @version 1.0
 */

@RestController
@RequestMapping("/consoles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsoleController {

    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping
    public ResponseEntity<List<ConsoleEntity>> findAll() {
        return new ResponseEntity<List<ConsoleEntity>>(
                (List<ConsoleEntity>) this.consoleRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleEntity> findById(@PathVariable("id") long id) {
        if(this.consoleRepository.findById(id).isPresent()) {
            return new ResponseEntity<ConsoleEntity>(
                    this.consoleRepository.findById(id).get(),
                    new HttpHeaders(), HttpStatus.OK);
        }
        return new ResponseEntity<ConsoleEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ConsoleEntity> store(@RequestBody ConsoleEntity consoleEntity) {
        return new ResponseEntity<ConsoleEntity>(
                this.consoleRepository.save(consoleEntity),
                new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsoleEntity> update(@PathVariable("id") long id,
                                                @RequestBody ConsoleEntity consoleEntity) throws Exception {
        if(id == 0 || !this.consoleRepository.existsById(id)) {
            throw new Exception("ID not found or inexistence.");
        }

        return new ResponseEntity<ConsoleEntity>(
                this.consoleRepository.save(consoleEntity),
                new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ConsoleEntity> delete(@PathVariable("id") long id) {
        this.consoleRepository.deleteById(id);
        return new ResponseEntity<ConsoleEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}
