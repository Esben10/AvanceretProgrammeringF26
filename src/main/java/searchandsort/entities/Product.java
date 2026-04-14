package searchandsort.entities;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // --- Comparable (used by TreeSet) ---
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }

    // --- equals (used by HashSet) ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    // --- hashCode (used by HashSet) ---
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}