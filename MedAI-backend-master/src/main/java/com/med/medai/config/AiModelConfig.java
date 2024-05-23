package com.med.medai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lcx
 */
@Data
@Component
@ConfigurationProperties(prefix = "ai.model")
public class AiModelConfig {
    /**
     * 模型id
     */
    private Long modelId;
}
