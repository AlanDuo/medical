package com.lhd.consultation.service;

import com.lhd.consultation.entities.User;

public interface ChatService {
    boolean isDoctor(Long userId);
    User getUser(Long userId);
}
