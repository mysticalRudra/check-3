package com.example.demo11.service;


import com.example.demo11.dto.BroucherDto;
import com.example.demo11.model.Broucher;
import com.example.demo11.model.BroucherRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BroucherService {

	@Autowired
    private  BroucherRepo broucherRepo;

    public BroucherService(BroucherRepo broucherRepo) {
        this.broucherRepo = broucherRepo;
    }

    // Create or Update Liquor
    @Transactional
    public Broucher saveLiquor(BroucherDto liquorDTO) {
    	Broucher liquor = new Broucher();
        liquor.setBrandName(liquorDTO.getBrandName());
        liquor.setQuantity(liquorDTO.getQuantity());
        liquor.setPrice(liquorDTO.getPrice());
        liquor.setLiquorType(liquorDTO.getLiquorType());
        liquor.setPriceType(liquorDTO.getPriceType());
        return broucherRepo.save(liquor);
    }
    
    public List<BroucherDto> getLiquorByBrand(String brandName) {
        List<Broucher> liquors = broucherRepo.findAllByBrandName(brandName);
        return liquors.stream()
                .map(liquor -> new BroucherDto(
                        liquor.getBrandName(),
                        liquor.getQuantity(),
                        liquor.getPrice(),
                        liquor.getLiquorType(),liquor.getPriceType()
                ))
                .collect(Collectors.toList());
    }

    public List<BroucherDto> getAllLiquors() {
        List<Broucher> liquors = broucherRepo.findAll();
        return liquors.stream()
                .map(liquor -> new BroucherDto(
                        liquor.getBrandName(),
                        liquor.getQuantity(),
                        liquor.getPrice(),
                        liquor.getLiquorType(),liquor.getPriceType()
                ))
                .collect(Collectors.toList());
    }
    @Transactional
    public Broucher updateLiquor(String brandName, int quantity, String liquorType, BroucherDto updatedLiquorDTO) {
    	Broucher liquor = broucherRepo.findByBrandNameAndQuantityAndLiquorType(brandName, quantity, liquorType)
                .orElseThrow(() -> new RuntimeException("Liquor not found with the given criteria"));

        // Update the fields with new values
        liquor.setPrice(updatedLiquorDTO.getPrice());
        liquor.setQuantity(updatedLiquorDTO.getQuantity());
        liquor.setPriceType(updatedLiquorDTO.getPriceType());

        return broucherRepo.save(liquor);
    }

    // Delete Liquor by serialNo
    @Transactional
    public void deleteLiquor(Long serialNo) {
        broucherRepo.deleteById(serialNo);
    }
    
    @Transactional
    public String deleteLiquor(String brandName, int quantity, String priceType) {
        int rowsDeleted = broucherRepo.deleteByBrandNameAndQuantityAndLiquorType(brandName, quantity, priceType);

        if (rowsDeleted == 0) {
            throw new RuntimeException("No Liquor found with the given criteria");
        }

        return "Liquor deleted successfully";
    }
}
