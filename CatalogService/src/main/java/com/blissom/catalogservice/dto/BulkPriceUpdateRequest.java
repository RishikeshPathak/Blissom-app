package com.blissom.catalogservice.dto;

import lombok.Data;

@Data
public class BulkPriceUpdateRequest {
    private double percentageChange;

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }
}

