package com.mingkai.mmpt.service;



import com.mingkai.mmpt.dao.MmptResultMapper;
import com.mingkai.mmpt.model.MmptResult;
import com.mingkai.mmpt.model.MmptResultExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class MmptResultService {

    @Autowired
    private MmptResultMapper mmptResultMapper;


    public List<MmptResult> selectMmptResultsByMmptId(Long mmptId) {
        MmptResultExample e = new MmptResultExample();
        MmptResultExample.Criteria c = e.createCriteria();
        c.andMmptIdEqualTo(mmptId);
        return mmptResultMapper.selectByExample(e);
    }


    public MmptResult selectMmptResultsById(Long id) {
        return mmptResultMapper.selectByPrimaryKey(id);
    }

    public MmptResult queryMmptResult(Long mmptId, Integer score) {
        MmptResultExample e = new MmptResultExample();
        MmptResultExample.Criteria c = e.createCriteria();
        c.andMmptIdEqualTo(mmptId);
        c.andMmptScoreLessThanOrEqualTo(score);
        e.setOrderByClause("mmpt_score desc limit 1");
        List<MmptResult> mmptResults = mmptResultMapper.selectByExampleWithBLOBs(e);
        if (!mmptResults.isEmpty()){
            return mmptResults.get(0);
        }else {
            return null;
        }

    }
}
