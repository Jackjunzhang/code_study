package com.biyilin.mapper;

import com.biyilin.pojo.Phonecall;
import com.biyilin.pojo.PhonecallExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhonecallMapper {
    long countByExample(PhonecallExample example);

    int deleteByExample(PhonecallExample example);

    int deleteByPrimaryKey(Integer phid);

    int insert(Phonecall record);

    int insertSelective(Phonecall record);

    List<Phonecall> selectByExample(PhonecallExample example);

    Phonecall selectByPrimaryKey(Integer phid);

    int updateByExampleSelective(@Param("record") Phonecall record, @Param("example") PhonecallExample example);

    int updateByExample(@Param("record") Phonecall record, @Param("example") PhonecallExample example);

    int updateByPrimaryKeySelective(Phonecall record);

    int updateByPrimaryKey(Phonecall record);
}