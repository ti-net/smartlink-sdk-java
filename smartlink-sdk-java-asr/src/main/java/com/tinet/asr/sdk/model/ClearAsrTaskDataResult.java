package com.tinet.asr.sdk.model;


import lombok.Data;

import java.util.List;

/**
 * 清理AsrTaskData缓存返回结果
 */
@Data
public class ClearAsrTaskDataResult{

    /**
     * 是否清理
     */
    private Boolean clearFlag;
    /**
     * taskIdSet缓存数量
     */
    private Integer taskIdSet;
    /**
     * asrTaskData缓存数量
     */
    private Integer asrTaskDataList;
    /**
     * 总共清理数量
     */
    private Integer totalClear;
    /**
     * 清理的asrTaskData缓存数据集合
     */
    private List<AsrTaskData> clearDataList;
}
