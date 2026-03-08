package com.bn.school.services;

import com.bn.school.models.EstudanteModel;
import com.bn.school.repositores.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll(){
        return estudanteRepository.findAll();
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        return estudanteRepository.save(estudanteModel);
    }

    public void deletarEstudante (Long id){
        estudanteRepository.deleteById(id);
    }

    /* public Optional<EstudanteModel> buscarPorId(Long id){
        return estudanteRepository.findById(id);
    } */

    public EstudanteModel buscarPorId(Long id){
        return estudanteRepository.findById(id).get();
    }

    public EstudanteModel atualizarEstudante(Long id, EstudanteModel estudanteModel){
       EstudanteModel newestudanteModel = estudanteRepository.findById(id).get();
      // newestudanteModel.setNome(estudanteModel.getNome());
        return estudanteRepository.save(estudanteModel);
    }



}
