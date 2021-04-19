package lk.earth.example5;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Gender {
    @Id
    private Integer id;
    private String name;

    @JsonIgnore
    @OneToMany
    private List<Employee> employeeList;

    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public List<Employee> getEmployeeList(){return employeeList;}
    public void setEmployeeList(List<Employee> employeeList){this.employeeList=employeeList;}

    //constructor
    public Gender(Integer id){
        this.id=id;
    }

    public Gender(){}
}
