package com.med.medai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.med.medai.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
* @description 针对表【chart(图表信息表)】的数据库操作Mapper
* @Entity com.med.medai.model.entity.Chart
*/
public interface ChartMapper extends BaseMapper<Chart> {

    /**
     * @param querySql
     * @return
     */
    List<Map<String, Object>> queryChartData(String querySql);
}




