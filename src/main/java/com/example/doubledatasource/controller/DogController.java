package com.example.doubledatasource.controller;

import com.example.doubledatasource.entity.one.Dog;
import com.example.doubledatasource.mapper.one.DogMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoliansheng
 * @ClassName DogController
 * @Description
 * @Date 2019/10/15 15:59
 * @Version 1.0
 */
@RequestMapping("/test/dog/")
@RestController
@Api("狗")
public class DogController {

    @Autowired
    DogMapper dogMapper;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation("保存")
    public String save(@RequestBody Dog dog){
        dogMapper.insert(dog);
        return dog.getId().toString();
    }
}
