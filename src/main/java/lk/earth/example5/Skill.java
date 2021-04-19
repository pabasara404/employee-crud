package lk.earth.example5;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Skill {

    @Id
    private Integer id;
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    //Constructors
    public Skill(){}
    public Skill(Integer id){this.id=id;}

    //getters & setters
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    //relationship getters & setters
    public Employee getEmployee(){return  employee;}

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
