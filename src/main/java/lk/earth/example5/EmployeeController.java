package lk.earth.example5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    private  SkillDao skillDao;
    private GenderDao genderDao;

    @GetMapping
    public List<Employee> getAll(){
        return employeeDao.findAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id){
        Optional<Employee> optionalEmployee=employeeDao.findById(id);

        if (optionalEmployee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found.");
        return optionalEmployee.get();

    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody Employee employee){
        for(Skill skill:employee.getSkillList()) skill.setEmployee(employee);

        return employeeDao.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id,@RequestBody Employee employee){
        if (!employeeDao.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found.");

        employee.setId(id);
        for(Skill skill:employee.getSkillList()) skill.setEmployee(employee);
        return employeeDao.save(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        if(employeeDao.existsById(id)){
            employeeDao.deleteById(id);
        }
    }


}
