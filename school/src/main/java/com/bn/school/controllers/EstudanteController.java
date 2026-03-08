package com.bn.school.controllers;

import com.bn.school.models.EstudanteModel;
import com.bn.school.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes") //Caminho

public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public List<EstudanteModel> findAll(){
        return estudanteService.findAll();
    }

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
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
