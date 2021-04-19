package lk.earth.example5;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {

    @Id
    private Integer id;
    private String name;
    private String nic;
    private LocalDate dob;
    private BigDecimal salary;
    private String mobile;
    private String land;
    private String address;
    private byte[] photo;

    @ManyToOne
    private Gender gender;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Skill> skillList;

    //constructors
    public Employee(){}
    public Employee(Integer id){this.id=id;}

    //getters & setters
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getNic(){return nic;}
    public void setNic(String nic){this.nic=nic;}

    public LocalDate getDob(){return dob;}
    public void setDob(LocalDate dob){this.dob=dob;}

    public BigDecimal getSalary(){return salary;}
    public void setSalary(BigDecimal salary){this.salary=salary;}

    public String getMobile(){return mobile;}
    public void setMobile(String mobile){this.mobile=mobile;}

    public String getLand(){return land;}
    public void setLand(String land){this.land=land;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public byte[] getPhoto(){return photo;}
    public void setPhoto(byte[] photo){this.photo=photo;}

    //relationship getters& Setters

    public Gender getGender(){return gender;}
    public void setGender(Gender gender){this.gender=gender;}

    public List<Skill> getSkillList(){return skillList;}
    public void setSkillList(List<Skill> skillList){this.skillList=skillList;}
}
