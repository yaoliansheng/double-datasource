package com.example.doubledatasource.controller;

import com.example.doubledatasource.entity.one.Dog;
import com.example.doubledatasource.entity.two.Person;
import com.example.doubledatasource.entity.two.PersonExample;
import com.example.doubledatasource.mapper.one.DogMapper;
import com.example.doubledatasource.mapper.two.PersonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yaoliansheng
 * @ClassName PersonController
 * @Description
 * @Date 2019/10/15 15:59
 * @Version 1.0
 */
@RequestMapping("/test/person/")
@RestController
@Api("人")
public class PersonController {
    @Autowired
    PersonMapper personMapper;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation("保存")
    public String save(@RequestBody Person person){
        personMapper.insert(person);
        return person.getId().toString();
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ApiOperation("查询")
    public PageInfo query(@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize")Integer pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Person> peoples = personMapper.selectByExample(new PersonExample());
        PageInfo<Person> personPageInfo = new PageInfo<>(peoples);
        return personPageInfo;
    }

}
