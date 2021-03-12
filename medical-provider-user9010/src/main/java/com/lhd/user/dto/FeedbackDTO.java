package com.lhd.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alan
 * @date 2021/3/1
 */
@Data
@NoArgsConstructor
public class FeedbackDTO {
    private Long userId;

    private String content;

    private String contact;

    private String picture;
}
