package com.example.demo11.controllers;

import com.example.demo11.dto.BroucherDto;
import com.example.demo11.model.Broucher;
import com.example.demo11.service.BroucherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broucher")
public class BroucherController {

	@Autowired
    private  BroucherService broucherService;

    public BroucherController(BroucherService broucherService) {
        this.broucherService = broucherService;
    }

    // Add or Update Liquor
    @PostMapping("/add")
    public ResponseEntity<BroucherDto> addLiquor(@RequestBody BroucherDto broucherDto) {
        Broucher liquor = broucherService.saveLiquor(broucherDto);
        BroucherDto responseDTO = new BroucherDto();
        responseDTO.setBrandName(liquor.getBrandName());
        responseDTO.setQuantity(liquor.getQuantity());
        responseDTO.setPrice(liquor.getPrice());
        responseDTO.setLiquorType(liquor.getLiquorType());
        responseDTO.setPriceType(liquor.getPriceType());
        
        return ResponseEntity.ok(responseDTO);
    }

    // Get All Liquors
    @GetMapping("/all")
    public ResponseEntity <List<BroucherDto>> getAllLiquors() {
        List<BroucherDto> liquors = broucherService.getAllLiquors();
        return ResponseEntity.ok(liquors);
    }

    // Get Liquor by Brand
    @GetMapping("/by-brand")
    public ResponseEntity<List<BroucherDto>> getLiquorsByBrand(@RequestParam String brandName) {
        List<BroucherDto> liquors = broucherService.getLiquorByBrand(brandName);
        return ResponseEntity.ok(liquors);
    }

    @PutMapping("/update")
    public ResponseEntity<BroucherDto> updateLiquor(
            @RequestParam String brandName,
            @RequestParam int quantity,
            @RequestParam String liquorType,
            @RequestBody BroucherDto updatedLiquorDTO) {

        Broucher updatedLiquor = broucherService.updateLiquor(brandName, quantity, liquorType, updatedLiquorDTO);

        BroucherDto responseDTO = new BroucherDto();
        responseDTO.setBrandName(updatedLiquor.getBrandName());
        responseDTO.setQuantity(updatedLiquor.getQuantity());
        responseDTO.setPrice(updatedLiquor.getPrice());
        responseDTO.setLiquorType(updatedLiquor.getLiquorType());

        return ResponseEntity.ok(responseDTO);
    }

    // Delete Liquor by Serial Number
    @DeleteMapping("/delete/{serialNo}")
    public ResponseEntity<String> deleteLiquor(@PathVariable Long serialNo) {
    	broucherService.deleteLiquor(serialNo);
        return ResponseEntity.ok("Liquor deleted successfully");
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLiquor(
            @RequestParam String brandName,
            @RequestParam int quantity,
            @RequestParam String priceType) {

        String message = broucherService.deleteLiquor(brandName, quantity, priceType);

        return ResponseEntity.ok(message);
    }
}
