package GUI;

import BUS.ProductBUS;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.Product;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ProductPanel extends MainPanel{
    private JTextField txfproductid,txfproductname,txfdescription,txfprice;
    private JLabel lblproductid,lblproductname,lblbrand,lbldescription,lblcategory,lblmaterial,lblprice,lblgender;
    private JComboBox <Category> cbbcategory;
    private JComboBox <Material> cbbmaterial;
    private JComboBox <Brand> cbbbrand;
    private JComboBox <Gender> cbbgender;
    private JTable tblproduct;
    private DefaultTableModel mdlproduct;
    private ProductBUS productbus = new ProductBUS();
    public ProductPanel(int roleid) {
        super(roleid);
        init();
    }
    private void init()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets  = new Insets(5, 5, 5, 5);
        String columnName[] ={"Mã sản phẩm","Tên sản phẩm","Mô tả","Thương hiệu","Chất liệu","Giới tính","Danh mục","Giá"};

        // PANEL 1

        // PANEL IAMGE

        // PANEL 2 
        JLabel lblproductinfo = new JLabel("Thông tin sản phẩm");
        lblproductinfo.setFont(new Font("Roboto",Font.BOLD,20));
        lblproductinfo.setBorder(new EmptyBorder(0,0,10,0));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridwidth=2;
        pnlcon2.add(lblproductinfo,gbc);

        lblproductid = new JLabel("Mã sản phẩm");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth=1;
        pnlcon2.add(lblproductid,gbc);

        lblproductname = new JLabel("Tên sản phẩm");
        lblproductname.setBorder(Theme.emptyborder);
        gbc.gridy = 2;
        pnlcon2.add(lblproductname,gbc);

        lbldescription = new JLabel("Mô tả");
        gbc.gridy = 3;
        pnlcon2.add(lbldescription,gbc);

        lblbrand = new JLabel("Thương hiệu");
        gbc.gridy= 4;
        pnlcon2.add(lblbrand,gbc);

        lblmaterial = new JLabel("Chất liệu");
        gbc.gridy = 5;
        pnlcon2.add(lblmaterial,gbc);

        lblgender = new JLabel("Giới tính");
        gbc.gridy = 6;
        pnlcon2.add(lblgender,gbc);

        lblcategory = new JLabel("Danh mục");
        gbc.gridy = 7;
        pnlcon2.add(lblcategory,gbc);

        lblprice = new JLabel("Giá");
        gbc.gridy = 8;
        pnlcon2.add(lblprice,gbc);


        txfproductid = new JTextField();
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=3;
        pnlcon2.add(txfproductid,gbc);
    
        txfproductname = new JTextField();
        gbc.gridy=2;
        pnlcon2.add(txfproductname,gbc);

        txfdescription = new JTextField();
        gbc.gridy=3;
        pnlcon2.add(txfdescription,gbc);

        cbbbrand = new JComboBox<>();
        gbc.gridy=4;
        pnlcon2.add(cbbbrand,gbc);
        
        cbbmaterial = new JComboBox<>();
        gbc.gridy=5;
        pnlcon2.add(cbbmaterial,gbc);
        
        cbbgender = new JComboBox<>();
        gbc.gridy=6;
        pnlcon2.add(cbbgender,gbc);

        cbbcategory = new JComboBox<>();
        gbc.gridy=7;
        pnlcon2.add(cbbcategory,gbc);

        txfprice = new JTextField();
        gbc.gridy=8;
        pnlcon2.add(txfprice,gbc);

        loadJComboBox();
        showProductInfo(false);
        
        // PANEL 4

        mdlproduct = new DefaultTableModel(columnName,0);
        tblproduct = new JTable(mdlproduct);
        loadDataTable(productbus.getAllProduct());
        JScrollPane sp = new JScrollPane(tblproduct);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        pnlcon4.add(sp,gbc);

        addEvent();

    }
    public void showProductInfo(boolean show)
    {
        txfproductid.setVisible(show);
        txfproductname.setVisible(show);
        txfdescription.setVisible(show);
        txfprice.setVisible(show);
        cbbbrand.setVisible(show);
        cbbcategory.setVisible(show);
        cbbmaterial.setVisible(show);
        cbbgender.setVisible(show);
    }
    private void loadDataTable(List<Product>pdl)
    {
        mdlproduct.setRowCount(0);
        for(Product p : pdl)
        {
           mdlproduct.addRow(new Object[]{
            p.getProductId(),
            p.getProductName(),
            p.getDescription(),
            productbus.getBrandFromId(p.getBrandId()).getBrandName(),
            productbus.getMaterialFromId(p.getMaterialId()).getMaterialName(),
            productbus.getGenderFromId(p.getGender()).getGenderName(),
            productbus.getCategoryFromId(p.getCategoryId()).getCategoryName(),
            p.getPrice()
           });
        }
    }
    public void loadJComboBox()
    {
        for(Brand i : productbus.getAllBrand()){
            cbbbrand.addItem(i);
        }
        for(Category i : productbus.getAllCategory())
        {
            cbbcategory.addItem(i);
        }
        for(Material i : productbus.getAllMaterial())
        {
            cbbmaterial.addItem(i);
        }
        for(Gender i : productbus.getAllGender())
        {
            cbbgender.addItem(i);
        }
    }
    public void loadProductInfo()
    {
        int productid = Integer.parseInt(tblproduct.getValueAt(tblproduct.getSelectedRow(),0).toString());
        Product product = productbus.getProductFromId(productid);
        txfproductid.setText(Integer.toString(product.getProductId()));
        txfproductname.setText(product.getProductName());
        txfdescription.setText(product.getDescription());
        cbbbrand.setSelectedItem(productbus.getBrandFromId(product.getBrandId()));
        cbbcategory.setSelectedItem(productbus.getCategoryFromId(product.getCategoryId()));
        cbbmaterial.setSelectedItem(productbus.getMaterialFromId(product.getMaterialId()));
        cbbgender.setSelectedItem(productbus.getGenderFromId(product.getGender()));
        txfprice.setText(product.getPrice().toString());
    }
    private void addEvent()
    {
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == tblproduct)
                {
                    loadProductInfo();
                    showProductInfo(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        };
        tblproduct.addMouseListener(ml);
    }



}
