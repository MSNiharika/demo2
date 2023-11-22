package com.example.demo.controller;

import com.example.demo.model.DemoModel;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demoController")
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping(value = "/getDemoMethod")
    public ResponseEntity<List<DemoModel>> getDemoMethod() {
        try {
            List demoList = demoService.getDemoMethod();
            return new ResponseEntity(demoList, HttpStatus.OK);
        } catch (Exception var2) {
            return new ResponseEntity((MultiValueMap) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping({"/postDemoMethod"})
    public ResponseEntity<DemoModel> postDemoMethod(@RequestBody DemoModel product) {
        try {
            DemoModel demoResp = demoService.createProduct(product);
            return new ResponseEntity(demoResp, HttpStatus.CREATED);
        } catch (Exception var3) {
            return new ResponseEntity((MultiValueMap) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping({"/putDemoMethod/{id}"})
    public ResponseEntity<DemoModel> putDemoMethod(@PathVariable("id") long id, @RequestBody DemoModel demoData) {
        try {
            Optional<DemoModel> data = demoService.findById(id);

            if (data.isPresent()) {
                DemoModel demoModel = data.get();
                demoModel.setName(demoData.getName());
                return new ResponseEntity<>(demoService.createProduct(demoModel), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity((MultiValueMap) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

