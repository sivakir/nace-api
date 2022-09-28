package com.app.nace.controller;

import com.app.nace.exception.DataMissingException;
import com.app.nace.domain.Nace;
import com.app.nace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nace")
public class NaceController {

    @Autowired
    private NaceService naceService;

    @GetMapping("/{id}")
    public Nace getById(@PathVariable Long id) throws DataMissingException {
        if(null == id || id <= 0){
            throw new DataMissingException();
        }
        return naceService.getNaceById(id);
    }
    @PostMapping
    public ResponseEntity<Nace> save(@Valid @RequestBody Nace nace){
        return new ResponseEntity<>(naceService.saveNace(nace), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Nace>> getAll() {
        List<Nace> naces = naceService.findAll();
        return naces.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(naces, HttpStatus.OK);
    }
    @PutMapping
    public Nace update(@Valid @RequestBody Nace nace) {
        return naceService.saveNace(nace);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Nace nace) {
        naceService.delete(nace);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        naceService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
