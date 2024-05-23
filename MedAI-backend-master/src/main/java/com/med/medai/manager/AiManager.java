package com.med.medai.manager;

import com.med.medai.common.ErrorCode;
import com.med.medai.config.AiModelConfig;
import com.med.medai.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AiManager {

    @Resource
    private YuCongMingClient congMingClient;

    @Resource
    private AiModelConfig aiModelConfig;

    /**
     * AI 对话
     *
     * @param message 消息
     * @return
     */
    public String doChat(String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        // 鱼聪明平台模型ID
        devChatRequest.setModelId(aiModelConfig.getModelId());
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = congMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }

    public String doAiChat(Long modelId, String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = congMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }
}
