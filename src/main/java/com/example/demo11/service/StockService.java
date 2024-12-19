package com.example.demo11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo11.dto.StockDTO;
import com.example.demo11.model.Stock;
import com.example.demo11.model.StockRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

	@Autowired
    private  StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock addStock(String brand, int quantity, int stockNumber) {
        // Check if stock with the same brand and quantity exists
        Stock existingStock = stockRepository.findByBrandAndQuantity(brand, quantity).orElse(null);

        if (existingStock != null) {
            // Accumulate stock number
            existingStock.setStockNumber(existingStock.getStockNumber() + stockNumber);
            return stockRepository.save(existingStock);
        }

        // Create a new stock entry if no existing record
        Stock newStock = new Stock();
        newStock.setBrand(brand);
        newStock.setQuantity(quantity);
        newStock.setStockNumber(stockNumber);

        return stockRepository.save(newStock);
    }

    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();

        return stocks.stream()
                .map(stock -> new StockDTO(stock.getBrand(), stock.getQuantity(), stock.getStockNumber()))
                .collect(Collectors.toList());
    }
    public StockDTO getStockByBrandAndQuantity(String brand, int quantity) {
        Stock stock = stockRepository.findParticulars(brand, quantity)
                .orElseThrow(() -> new RuntimeException("Stock not found for brand: " + brand + " and quantity: " + quantity));

        return new StockDTO(stock.getBrand(), stock.getQuantity(), stock.getStockNumber());
    }
}
