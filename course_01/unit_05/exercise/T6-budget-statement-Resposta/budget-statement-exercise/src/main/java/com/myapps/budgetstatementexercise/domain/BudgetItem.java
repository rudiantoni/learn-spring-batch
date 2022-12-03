package com.myapps.budgetstatementexercise.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BudgetItem {

    private static final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long expenseCategoryCode; //código da natureza da despesa
    private String expenseCategoryDescription; //descrição da natureza de despesa
    private String itemDescription; //descrição do item
    private LocalDate itemDate; //data do item
    private Float itemValue; //valor do item

    public Long getExpenseCategoryCode() {
        return expenseCategoryCode;
    }

    public void setExpenseCategoryCode(Long expenseCategoryCode) {
        this.expenseCategoryCode = expenseCategoryCode;
    }

    public String getExpenseCategoryDescription() {
        return expenseCategoryDescription;
    }

    public void setExpenseCategoryDescription(String expenseCategoryDescription) {
        this.expenseCategoryDescription = expenseCategoryDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public Float getItemValue() {
        return itemValue;
    }

    public void setItemValue(Float itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String toString() {
        return "BudgetItem{expenseCategoryCode=" + expenseCategoryCode +
            ", expenseCategoryDescription='" + expenseCategoryDescription +
            "', itemDescription='" + itemDescription +
            "', itemDate=" + (itemDate != null ? itemDate.format(formatter) : "null") +
            ", itemValue=" + itemValue +
            "}";
    }
}
