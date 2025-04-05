package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
    protected int roleid;
    protected JPanel pnlcon1,pnlcon4,pnlcon5;
    protected RoundedPanel pnlimage,pnlcon2,pnlcon3;
    protected RoundedButton btnsave,btnadd,btnremove;
    public MainPanel(int roleid)
    {
        this.roleid = roleid;
        init();
    }
    private void init()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5  , 5, 5, 5);
        // PANEL 1
        pnlcon1 = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth=3;
        add(pnlcon1,gbc);

        // PANEL Image
        pnlimage = new RoundedPanel(20);
        pnlimage.setBackground(Theme.light1);
        pnlimage.setBorder(new EmptyBorder(10,10,10,10));
        pnlimage.setBorderWidth(1);
        pnlimage.setBorderColor(Theme.brown);
        pnlimage.setPanelSize(320, 320);
        gbc.gridy=1;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        add(pnlimage,gbc);

        // PANEL 2
        pnlcon2 = new RoundedPanel(20);
        pnlcon2.setLayout(new GridBagLayout());
        pnlcon2.setBackground(Theme.light1);
        pnlcon2.setBorder(new EmptyBorder(10,10,10,10));
        pnlcon2.setBorderWidth(1);
        pnlcon2.setBorderColor(Theme.brown);
        gbc.gridx=1;
        gbc.weightx=2;

  
        add(pnlcon2,gbc);

        // PANEL 3
        pnlcon3 = new RoundedPanel(20);
        pnlcon3.setLayout(new GridBagLayout());
        pnlcon3.setBackground(Theme.light1);
        pnlcon3.setBorder(new EmptyBorder(10,10,10,10));
        pnlcon3.setBorderWidth(1);
        pnlcon3.setBorderColor(Theme.brown);
        gbc.gridx=2;
        gbc.weightx=1;
        add(pnlcon3,gbc);

        // PANEL 4
        pnlcon4 = new JPanel(new GridBagLayout());
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=1;
        gbc.weighty=8;
        gbc.gridwidth=3;
        add(pnlcon4,gbc);
        
        // PANEL 5  
        pnlcon5 = new JPanel(new GridBagLayout());
        gbc.gridy=3;
        gbc.weighty=1;
        add(pnlcon5,gbc);
        
        btnadd = new RoundedButton("Thêm", 20);
        btnadd.setBackground(Theme.brown);
        btnadd.setButtonSize(100, 50);
        btnadd.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlcon3.add(btnadd,gbc);

        btnremove = new RoundedButton("Xóa", 20);
        btnremove.setBackground(Theme.light1);
        btnremove.setBorderWidth(1);
        btnremove.setBorderColor(Theme.brown);
        btnremove.setButtonSize(100, 50);
        gbc.gridx=1;
        pnlcon3.add(btnremove,gbc);
        /*pnlcon1.setOpaque(true);
        pnlcon2.setOpaque(true);
        pnlcon3.setOpaque(true);
        pnlcon4.setOpaque(true);
        pnlcon5.setOpaque(true);
        pnlcon1.setBackground(Color.blue);
        pnlcon2.setBackground(Color.red);
        pnlcon3.setBackground(Color.green);
        pnlcon4.setBackground(Color.yellow);
        pnlcon5.setBackground(Color.gray);*/
        
    }    
    



}
