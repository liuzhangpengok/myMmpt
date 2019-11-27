package com.mingkai.mmpt.dao;

import com.mingkai.mmpt.model.Mmpt;
import com.mingkai.mmpt.model.MmptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MmptMapper {
    long countByExample(MmptExample example);

    int deleteByExample(MmptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mmpt record);

    int insertSelective(Mmpt record);

    List<Mmpt> selectByExampleWithBLOBs(MmptExample example);

    List<Mmpt> selectByExample(MmptExample example);

    Mmpt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mmpt record, @Param("example") MmptExample example);

    int updateByExampleWithBLOBs(@Param("record") Mmpt record, @Param("example") MmptExample example);

    int updateByExample(@Param("record") Mmpt record, @Param("example") MmptExample example);

    int updateByPrimaryKeySelective(Mmpt record);

    int updateByPrimaryKeyWithBLOBs(Mmpt record);

    int updateByPrimaryKey(Mmpt record);
}