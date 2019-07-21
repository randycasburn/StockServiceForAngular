package com.fidelity.stockservice.endpoints;

import com.fidelity.stockservice.repositories.StockRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class Stocks {

    private final StockRepository repo;

    public Stocks(StockRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List getStocks(@RequestParam(defaultValue = "") String filter, @RequestParam(required = false) Integer count ) {
        int limit = count != null? count : 0;
        return repo.getStocks(filter, limit);
    }
}
