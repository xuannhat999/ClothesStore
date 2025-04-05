package DAO;

import DTO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProduct()
    {
        List<Product> pl = new ArrayList<>();
        String sql ="select * from product";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pl.add(new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("category_id"),
                    rs.getInt("material_id"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("brand_id"),
                    rs.getInt("gender")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pl;
    }
    public Product getProductFromId(int id)
    {
        String sql ="select * from product where product_id = ?";
        Product product = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {   
               product =new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getInt("category_id"),
                rs.getInt("material_id"),
                rs.getString("description"),
                rs.getBigDecimal("price"),
                rs.getInt("brand_id"),
                rs.getInt("gender")
            );
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return product;
    }
}
