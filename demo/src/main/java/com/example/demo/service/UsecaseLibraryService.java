package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.test.usecaselibrary.UsecaseLibrary;

public interface UsecaseLibraryService {
    public UsecaseLibrary addUsecaseLibrary(UsecaseLibrary oneLib);
    public List<UsecaseLibrary> allUsecaseLibrary(int id);
    public UsecaseLibrary oneUsecaseLibrary(int id);
}
