package com.bn.school.controllers;

import com.bn.school.models.EstudanteModel;
import com.bn.school.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estudantes") //Caminho

public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    /* @GetMapping
    public List<EstudanteModel> findAll(){
        return estudanteService.findAll();
    }*/

    //Codigo de Erro dar 201, não 200
    @GetMapping
    public ResponseEntity<List<EstudanteModel>>findAll(){
       List<EstudanteModel> requeste = estudanteService.findAll();
       return ResponseEntity.ok().body(requeste);
    }

    /*@PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }*/

    //Codigo de Erro dar 201, não 200
    @PostMapping
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel requeste = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(estudanteModel.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

   /* @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
    }*/

    //Codigo de Erro dar 204, não 200
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public EstudanteModel buscarPorId(@PathVariable Long id){
        return estudanteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizarEstudante(@PathVariable Long id, EstudanteModel estudanteModel){
        return estudanteService.atualizarEstudante(id, estudanteModel);
    }

}
