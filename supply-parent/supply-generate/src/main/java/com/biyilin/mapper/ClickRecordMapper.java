package com.biyilin.mapper;

import com.biyilin.pojo.ClickRecord;
import com.biyilin.pojo.ClickRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClickRecordMapper {
    long countByExample(ClickRecordExample example);

    int deleteByExample(ClickRecordExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(ClickRecord record);

    int insertSelective(ClickRecord record);

    List<ClickRecord> selectByExample(ClickRecordExample example);

    ClickRecord selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") ClickRecord record, @Param("example") ClickRecordExample example);

    int updateByExample(@Param("record") ClickRecord record, @Param("example") ClickRecordExample example);

    int updateByPrimaryKeySelective(ClickRecord record);

    int updateByPrimaryKey(ClickRecord record);
}