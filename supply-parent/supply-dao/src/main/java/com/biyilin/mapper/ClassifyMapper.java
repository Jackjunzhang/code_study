package com.biyilin.mapper;

import com.biyilin.pojo.Classify;
import com.biyilin.pojo.ClassifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassifyMapper {
    long countByExample(ClassifyExample example);

    int deleteByExample(ClassifyExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}