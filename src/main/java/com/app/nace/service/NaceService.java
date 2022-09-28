package com.app.nace.service;

import com.app.nace.domain.Nace;
import com.app.nace.repository.NaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaceService {

    //@Autowired
    private NaceRepository naceRepository;

    public NaceService(NaceRepository naceRepository) {
      this.naceRepository = naceRepository;
    }

    public Nace getNaceById(Long id) {
        return naceRepository.findById(id).isPresent() ? naceRepository.findById(id).get() : new Nace();
    }

    public Nace saveNace(Nace nace){
        return naceRepository.save(nace);
    }

    public List<Nace> findAll(){
        return naceRepository.findAll();
    }

    public void delete(Nace nace){
        naceRepository.delete(nace);
    }

    public void deleteById(Long id){
        naceRepository.deleteById(id);
    }
}
