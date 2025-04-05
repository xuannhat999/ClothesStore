package BUS;

import DAO.BrandDAO;
import DAO.CategoryDAO;
import DAO.GenderDAO;
import DAO.MaterialDAO;
import DAO.ProductDAO;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.Product;
import java.util.List;

public class ProductBUS {
    ProductDAO productdao = new ProductDAO();
    CategoryDAO categorydao = new CategoryDAO();
    BrandDAO brandao = new BrandDAO();
    MaterialDAO materialdao = new MaterialDAO();
    GenderDAO genderdao = new GenderDAO();
    public ProductBUS() {
    }
    public List<Product> getAllProduct()
    {
        return productdao.getAllProduct();
    }
    public List<Category> getAllCategory()
    {
        return categorydao.getAllCategory();
    }
    public List<Material> getAllMaterial()
    {
        return materialdao.getAllMaterial();
    }
    public List<Brand> getAllBrand()
    {
        return brandao.getAllBrand();
    }
    public List<Gender> getAllGender()
    {
        return genderdao.getAllGender();
    }
    public Product getProductFromId(int id)
    {
        return productdao.getProductFromId(id);
    }
    public Category getCategoryFromId(int id)
    {
        return categorydao.getCategoryFromId(id);
    }
    public Material getMaterialFromId(int id)
    {
        return materialdao.getMaterialFromId(id);
    }
    public Brand getBrandFromId(int id)
    {
        return brandao.getBrandFromId(id);
    }
    public Gender getGenderFromId(int id)
    {
        return genderdao.getGenderFromId(id);
    }

}
