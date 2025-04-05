package DTO;

public class Category {
 private int categoryId;
    private String categoryName;

    public Category(){}
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Category d) {
        this.categoryId = d.categoryId;
        this.categoryName = d.categoryName;
    }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString()
    {
        return getCategoryName();
    }
}



