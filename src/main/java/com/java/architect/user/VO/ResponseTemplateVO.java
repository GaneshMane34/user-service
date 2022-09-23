package com.java.architect.user.VO;

import com.java.architect.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private UserEntity user;
    private Department department;
}
