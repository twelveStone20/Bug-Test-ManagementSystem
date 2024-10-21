package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDao;
//import com.example.demo.dao.impl.EmpDaoImpl;
import com.example.demo.pojo.Emp;
import com.example.demo.service.EmpService;

@Component
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp(){
        List<Emp> empList=empDao.listEmp();
        empList.stream().forEach(emp->{
            String gender=emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }
            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
