package org.launchcode.marketplacemetrics.models;

import java.math.BigDecimal;

public class CashFlow {

    private BigDecimal cashFlow;
    private BigDecimal totalBought;
    private BigDecimal totalSold;

    public CashFlow(BigDecimal cashFlow, BigDecimal totalBought, BigDecimal totalSold) {
        this.cashFlow = cashFlow;
        this.totalBought = totalBought;
        this.totalSold = totalSold;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(BigDecimal cashFlow) {
        this.cashFlow = cashFlow;
    }

    public BigDecimal getTotalBought() {
        return totalBought;
    }

    public void setTotalBought(BigDecimal totalBought) {
        this.totalBought = totalBought;
    }

    public BigDecimal getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(BigDecimal totalSold) {
        this.totalSold = totalSold;
    }
}
