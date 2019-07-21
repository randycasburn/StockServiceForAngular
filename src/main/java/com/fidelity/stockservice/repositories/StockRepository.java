package com.fidelity.stockservice.repositories;

import com.fidelity.stockservice.models.Stock;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StockRepository {
    
    private List<Stock> stocks = Arrays.asList(
		new Stock ("NASDAQ", "CSCO", 42.50, 0.72, 23_644_771),
		new Stock ("NASDAQ", "MSFT", 104.91, -0.52, 19_964_592),
		new Stock ("NASDAQ", "NFLX", 400.48, 4.68, 17_637_090),
		new Stock ("NASDAQ", "SBUX", 50.94, -0.68, 15_615_770),
		new Stock ("NASDAQ", "TSLA", 307.2, -11.67, 4_415_646),
		new Stock ("NASDAQ", "ABP", 0, 0, 0),
		new Stock ("NASDAQ", "CZR", 11.70, 0.2, 7_078_606),
		new Stock ("NYSE", "BAC", 29.78, 1.23, 127_917_114),
		new Stock ("NYSE", "F", 10.85, -0.13, 42_952_228),
		new Stock ("NYSE", "GE", 13.85, 0.12, 72_900_000),
		new Stock ("NYSE", "JPM", 109.89, 0, 16_400_000)
    );
    
    public List getStocks(String filter, int count) {
        Comparator<Stock> comparator;
        int limit = (count != 0)? count : stocks.size();
        switch(filter){
            case("volume") :
                comparator = Comparator.comparing(Stock::getCurrentVolume);
                break;
            case("priceChange") :
                comparator = Comparator.comparing(Stock::getPriceChange);
                break;
            default:
                comparator = Comparator.comparingDouble(Stock::getLastPrice);
        }

        return getStocksFiltered(comparator, limit);
    }

    private List<Stock> getStocksFiltered(Comparator<? super Stock> comparator, int limit) {
        return stocks.stream()
                .sorted(comparator.reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
