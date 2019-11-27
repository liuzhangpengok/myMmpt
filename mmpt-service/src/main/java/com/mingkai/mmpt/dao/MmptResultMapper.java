package com.mingkai.mmpt.dao;

import com.mingkai.mmpt.model.MmptResult;
import com.mingkai.mmpt.model.MmptResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MmptResultMapper {
    long countByExample(MmptResultExample example);

    int deleteByExample(MmptResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MmptResult record);

    int insertSelective(MmptResult record);

    List<MmptResult> selectByExampleWithBLOBs(MmptResultExample example);

    List<MmptResult> selectByExample(MmptResultExample example);

    MmptResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MmptResult record, @Param("example") MmptResultExample example);

    int updateByExampleWithBLOBs(@Param("record") MmptResult record, @Param("example") MmptResultExample example);

    int updateByExample(@Param("record") MmptResult record, @Param("example") MmptResultExample example);

    int updateByPrimaryKeySelective(MmptResult record);

    int updateByPrimaryKeyWithBLOBs(MmptResult record);

    int updateByPrimaryKey(MmptResult record);
}