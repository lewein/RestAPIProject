class Product {
    private String name;
    private String category;
    private double price;

    Product(String n, String c, double p) {
        setName(n);
        setCategory(c);
        setPrice(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
