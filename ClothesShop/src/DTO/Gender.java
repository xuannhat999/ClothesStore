package DTO;

public class Gender {
    private int gender_id;
    private String gender_name;
    public Gender(){}
    public Gender(int id,String name)
    {
        this.gender_id=id;
        this.gender_name=name;

    }
    public Gender(Gender d)
    {
        this.gender_id=d.gender_id;
        this.gender_name=d.gender_name;
    }
    public int getGenderId()
    {
        return gender_id;
    }
    public String getGenderName()
    {
        return gender_name;
    }
    @Override 
    public String toString()
    {
        return getGenderName();
    }
}
