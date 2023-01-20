package com.inditex.tools.application.query;

public class FindByCriteriaQuery {
    private int salesUnits;
    private int ratioStock;

    public FindByCriteriaQuery(int salesUnits, int ratioStock) {
        this.salesUnits = salesUnits;
        this.ratioStock = ratioStock;
    }

    public int getSalesUnits() {
        return salesUnits;
    }

    public int getRatioStock() {
        return ratioStock;
    }

}
