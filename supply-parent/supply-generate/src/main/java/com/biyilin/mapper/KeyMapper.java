package com.biyilin.mapper;

import com.biyilin.pojo.Key;
import com.biyilin.pojo.KeyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeyMapper {
    long countByExample(KeyExample example);

    int deleteByExample(KeyExample example);

    int deleteByPrimaryKey(Integer kid);

    int insert(Key record);

    int insertSelective(Key record);

    List<Key> selectByExample(KeyExample example);

    Key selectByPrimaryKey(Integer kid);

    int updateByExampleSelective(@Param("record") Key record, @Param("example") KeyExample example);

    int updateByExample(@Param("record") Key record, @Param("example") KeyExample example);

    int updateByPrimaryKeySelective(Key record);

    int updateByPrimaryKey(Key record);
}