package com.example.doubledatasource.mapper.one;

import com.example.doubledatasource.entity.one.Dog;
import com.example.doubledatasource.entity.one.DogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DogMapper {
    int countByExample(DogExample example);

    int deleteByExample(DogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dog record);

    int insertSelective(Dog record);

    List<Dog> selectByExampleWithRowbounds(DogExample example, RowBounds rowBounds);

    List<Dog> selectByExample(DogExample example);

    Dog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByExample(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);

    Long sumByExample(DogExample example);

    void batchInsert(@Param("items") List<Dog> items);
}