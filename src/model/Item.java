package model;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String imageUrl;
    private String productName;
    private String description;
    private int price;
    private int productType;
    private int stock;
    private int newItem;
    private int featuredProducts;
    private LocalDateTime addedDate;
    private LocalDateTime updateDate;

    // コンストラクタ
    public Item(int id, String productName, int price, int stock, String description, String imageUrl, int productType, int newItem, int featuredProducts, LocalDateTime addedDate, LocalDateTime updateDate) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productType = productType;
        this.stock = stock;
        this.newItem = newItem;
        this.featuredProducts = featuredProducts;
        this.addedDate = addedDate;
        this.updateDate = updateDate;
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNewItem() {
        return newItem;
    }

    public void setNewItem(int newItem) {
        this.newItem = newItem;
    }

    public int getFeaturedProducts() {
        return featuredProducts;
    }

    public void setFeaturedProducts(int featuredProducts) {
        this.featuredProducts = featuredProducts;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
