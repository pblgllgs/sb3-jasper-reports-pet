package com.pblgllgs.sb3jasperreports.service.impl;
/*
 *
 * @author pblgl
 * Created on 04-02-2024
 *
 */

import com.pblgllgs.sb3jasperreports.model.Pet;
import com.pblgllgs.sb3jasperreports.repository.PetRepository;
import com.pblgllgs.sb3jasperreports.service.PetService;
import com.pblgllgs.sb3jasperreports.util.PetReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetReportGenerator petReportGenerator;

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return petReportGenerator.exportToPdf(petRepository.findAll());
    }

    @Override
    public byte[] exportXls() throws JRException, FileNotFoundException {
        return petReportGenerator.exportToXls(petRepository.findAll());
    }
}
