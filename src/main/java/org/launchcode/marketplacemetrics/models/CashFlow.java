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


}
