package com.fidelity.stockservice.models;

import org.springframework.stereotype.Component;

@Component
public class Stock {
    private String market;
    private String symbol;
    private double lastPrice;
    private double priceChange;
    private double currentVolume;

    public Stock(String market, String symbol, double lastPrice, double priceChange, double currentVolume) {
        super();
        this.market = market;
        this.symbol = symbol;
        this.lastPrice = lastPrice;
        this.priceChange = priceChange;
        this.currentVolume = currentVolume;
    }

    public Stock() {
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    @Override
    public String toString() {
        return "Stock [market=" + market + ", symbol=" + symbol + ", lastPrice=" + lastPrice + ", priceChange="
                + priceChange + ", currentVolume=" + currentVolume + "]";
    }

}
