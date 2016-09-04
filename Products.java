package com.example.parkjohnug.checker;

public class Products {
    private String _productname;

    //Added this empty constructor in lesson 50 in case we ever want to create the object and assign it later.
    public Products(String productName) {
        this._productname = productName;
    }
    public String get_productname() {
        return _productname;
    }
}