package com.example.demo.service;

import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;
    public List<DemoModel> getDemoMethod(){
        List<DemoModel> demoList = new ArrayList<>();
        demoList.add(new DemoModel(1,"Niharika"));
        demoList.add(new DemoModel(2,"NiharikaM"));
        demoRepository.findAll().forEach(demoList::add);
        return demoList;
    }

    public DemoModel createProduct(DemoModel demoModel) {
        return demoRepository.save(demoModel);
    }

    public Optional<DemoModel> findById(long id) {
        return demoRepository.findById(id);
    }
}
