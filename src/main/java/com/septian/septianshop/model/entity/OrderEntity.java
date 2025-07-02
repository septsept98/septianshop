package com.septian.septianshop.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"order\"")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "status")
    private int status;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_on")
    private LocalDateTime createOn;

    public OrderEntity() {
    }

    public OrderEntity(String productId, String productName, BigDecimal amount, String customerName, int status, LocalDateTime transactionDate, String createBy, LocalDateTime createOn) {
        this.productId = productId;
        this.productName = productName;
        this.amount = amount;
        this.customerName = customerName;
        this.status = status;
        this.transactionDate = transactionDate;
        this.createBy = createBy;
        this.createOn = createOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }
}
