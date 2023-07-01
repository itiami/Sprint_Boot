package wali.co.nboot.controllers.Product;

import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




public class Product {

    private int id;
    private String prodName;
    private String prodType;
    private String prodOrigin;
    private int prodFfabYr;

    public Product() {
    }


    public Product(int id, String prodName, String prodType, String prodOrigin, int prodFfabYr) {
        this.id = id;
        this.prodName = prodName;
        this.prodType = prodType;
        this.prodOrigin = prodOrigin;
        this.prodFfabYr = prodFfabYr;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdOrigin() {
        return prodOrigin;
    }

    public void setProdOrigin(String prodOrigin) {
        this.prodOrigin = prodOrigin;
    }

    public int getProdFfabYr() {
        return prodFfabYr;
    }

    public void setProdFfabYr(int prodFfabYr) {
        this.prodFfabYr = prodFfabYr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", prodType='" + prodType + '\'' +
                ", prodOrigin='" + prodOrigin + '\'' +
                ", prodFfabYr=" + prodFfabYr +
                '}';
    }
}
