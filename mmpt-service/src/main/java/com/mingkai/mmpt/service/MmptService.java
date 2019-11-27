package com.mingkai.mmpt.service;


import com.mingkai.mmpt.dao.MmptMapper;
import com.mingkai.mmpt.dao.MmptResultMapper;
import com.mingkai.mmpt.dto.MmptDto;
import com.mingkai.mmpt.dto.MmptQueryDto;
import com.mingkai.mmpt.dto.MmptResultDto;
import com.mingkai.mmpt.enums.MmptQueryType;
import com.mingkai.mmpt.model.Mmpt;
import com.mingkai.mmpt.model.MmptExample;
import com.mingkai.mmpt.model.MmptResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: mingkai
 * @Date: 2019/6/13
 */
@Service
public class MmptService {

    @Autowired
    private MmptMapper mmptMapper;

    @Autowired
    private MmptResultMapper mmptResultMapper;

    @Autowired
    private MmptResultService mmptResultService;

    @Transactional
    public void saveMmpt(MmptDto saveMmptDto) {
        Mmpt mmpt = new Mmpt();
        BeanUtils.copyProperties(saveMmptDto,mmpt);
        mmpt.setCreateTime(new Date());
        mmptMapper.insertSelective(mmpt);


        List<MmptResultDto> mmptResultDtos = saveMmptDto.getMmptResultDtoList();
        mmptResultDtos.forEach(mmptResultDto -> {
            MmptResult mmptResult = new MmptResult();
            BeanUtils.copyProperties(mmptResultDto,mmptResult);
            mmptResult.setMmptId(mmpt.getId());
            mmptResult.setCreateTime(new Date());
            mmptResultMapper.insertSelective(mmptResult);
        });

    }

    public MmptDto queryByMmptDto(MmptQueryDto mmptQueryDto) {
        MmptDto mmptDto = new MmptDto();
        MmptExample e = new MmptExample();
        MmptExample.Criteria c = e.createCriteria();
        if (null != mmptQueryDto.getMmptId()){
            c.andIdEqualTo(mmptQueryDto.getMmptId());
        }
        if (null != mmptQueryDto.getType()){
            c.andTypeEqualTo(mmptQueryDto.getType());
        }
        if (null != mmptQueryDto.getOrderBy()){
            if (mmptQueryDto.getOrderBy().equals(MmptQueryType.NEW.getValue())){
                e.setOrderByClause("create_time desc limit 0,8");
            }
            if (mmptQueryDto.getOrderBy().equals(MmptQueryType.CHOICE.getValue())){
                e.setOrderByClause("buy_num desc limit 8,16");
            }
            if (mmptQueryDto.getOrderBy().equals(MmptQueryType.CLICK_NUM.getValue())){
                e.setOrderByClause("click_num desc limit 0,8");
            }
            if (mmptQueryDto.getOrderBy().equals(MmptQueryType.BUYED_NUM.getValue())){
                e.setOrderByClause("buy_num desc limit 0,8");
            }
        }
        List<Mmpt> mmpts = mmptMapper.selectByExample(e);
        if (!mmpts.isEmpty()){
            Mmpt mmpt = mmpts.get(0);
            BeanUtils.copyProperties(mmpt,mmptDto);
        }
        List<MmptResult> mmptResults = mmptResultService.selectMmptResultsByMmptId(mmptQueryDto.getMmptId());

        List<MmptResultDto> mmptResultDtos = new ArrayList<>();
        if (!mmptResults.isEmpty()){
            mmptResults.forEach(mmptResult -> {
                MmptResultDto mmptResultDto = new MmptResultDto();
                BeanUtils.copyProperties(mmptResult,mmptResultDto);
                mmptResultDtos.add(mmptResultDto);
            });
        }
        mmptDto.setMmptResultDtoList(mmptResultDtos);
        return mmptDto;



    }

    public void update(MmptDto mmptDto) {

        Mmpt oldMmpt = mmptMapper.selectByPrimaryKey(mmptDto.getId());
        if (null != oldMmpt){
            if (null != mmptDto.getTitle()){
                oldMmpt.setTitle(mmptDto.getTitle());
            }
            if (null != mmptDto.getIntroduce()){
                oldMmpt.setIntroduce(mmptDto.getIntroduce());
            }
            if (null != mmptDto.getImage()){
                oldMmpt.setImage(mmptDto.getImage());
            }
            if (null != mmptDto.getClickNum()){
                oldMmpt.setClickNum(mmptDto.getClickNum());
            }
            if (null != mmptDto.getBuyNum()){
                oldMmpt.setBuyNum(mmptDto.getBuyNum());
            }
            if (null != mmptDto.getType()){
                oldMmpt.setType(mmptDto.getType());
            }
            if (null != mmptDto.getPrice()){
                oldMmpt.setPrice(mmptDto.getPrice());
            }
            if (null != mmptDto.getMmptQuestions()){
                oldMmpt.setMmptQuestions(mmptDto.getMmptQuestions());
            }
            mmptMapper.updateByPrimaryKeySelective(oldMmpt);
        }
        List<MmptResultDto> mmptResultDtos = mmptDto.getMmptResultDtoList();
        if (!mmptResultDtos.isEmpty()){
            mmptResultDtos.forEach(mmptResultDto -> {
                MmptResult mmptResult = mmptResultService.selectMmptResultsById(mmptResultDto.getId());
                if (null != mmptResultDto.getMmptScore()){
                    mmptResult.setMmptScore(mmptResultDto.getMmptScore());
                }
                if (null != mmptResultDto.getMmptDescribe()){
                    mmptResult.setMmptDescribe(mmptResultDto.getMmptDescribe());
                }
                mmptResultMapper.updateByPrimaryKeySelective(mmptResult);
            });
        }


    }
}
