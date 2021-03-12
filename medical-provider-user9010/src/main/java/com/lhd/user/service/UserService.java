package com.lhd.user.service;

import com.lhd.user.dto.FeedbackDTO;
import com.lhd.user.entities.User;

/**
 * @author alan
 * @date 2021/2/23
 */
public interface UserService {
    User getUserById(Long userId);
    boolean addFeedback(FeedbackDTO feedbackDTO);
}
