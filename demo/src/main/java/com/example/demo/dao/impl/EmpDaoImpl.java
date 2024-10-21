package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDao;
import com.example.demo.pojo.Emp;
import com.example.demo.utils.xmlParserUtils;

@Component
public class EmpDaoImpl implements EmpDao{

    @Override
    public List<Emp> listEmp() {
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList=xmlParserUtils.parse(file, Emp.class);
        return empList;
    }
    
}
