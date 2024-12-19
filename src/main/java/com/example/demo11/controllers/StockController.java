package com.example.demo11.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo11.dto.StockDTO;
import com.example.demo11.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
    private  StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStock(
            @RequestParam String brand,
            @RequestParam int quantity,
            @RequestParam int stockNumber) {

        stockService.addStock(brand, quantity, stockNumber);
        return ResponseEntity.ok("Stock added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }
    @GetMapping("/getbybrand")
    public ResponseEntity<StockDTO> getStockByBrandAndQuantity(
            @RequestParam String brand,
            @RequestParam int quantity) {

        StockDTO stockDTO = stockService.getStockByBrandAndQuantity(brand, quantity);
        return ResponseEntity.ok(stockDTO);
    }
}
