package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.UsecaseLibMapper;
import com.example.demo.pojo.test.usecaselibrary.UsecaseLibrary;
import com.example.demo.service.UsecaseLibraryService;

@Component
public class UsecaseLibraryServiceImpl implements UsecaseLibraryService{

    @Autowired
    private UsecaseLibMapper usecaseLibMapper;

    @Override
    public UsecaseLibrary addUsecaseLibrary(UsecaseLibrary oneLib) {
        usecaseLibMapper.addUsecaseLibrary(oneLib);
        return oneLib;
    }

    @Override
    public List<UsecaseLibrary> allUsecaseLibrary(int id) {
        List<UsecaseLibrary> usecaseLibList=usecaseLibMapper.allUsecaseLibrary(id);
        return usecaseLibList;
    }

    @Override
    public UsecaseLibrary oneUsecaseLibrary(int id){
        UsecaseLibrary onelib=usecaseLibMapper.oneUsecaseLibrary(id);
        return onelib;
    }
    
}
