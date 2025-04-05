package DTO;

public class Brand {
    private int brandId;
    private String brandName;
    public Brand()
    {}
    public Brand(int brandid,String brandname)
    {
        this.brandId = brandid;
        this.brandName = brandname;
    }
    public Brand(Brand d)
    {
        this.brandId=d.brandId;
        this.brandName=d.brandName;
    }
    public int getBrandId()
    {
        return brandId;
    }
    public String getBrandName()
    {
        return brandName;
    }
    @Override
    public String toString()
    {
        return getBrandName();
    }
}
