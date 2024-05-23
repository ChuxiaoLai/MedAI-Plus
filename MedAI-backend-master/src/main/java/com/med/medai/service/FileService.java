package com.med.medai.service;

import org.springframework.web.multipart.MultipartFile;

/**
*
 */
public interface FileService {
    /**
     * 上传头像到OSS
     *
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
