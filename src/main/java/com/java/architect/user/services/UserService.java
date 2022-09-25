package com.java.architect.user.services;

import com.java.architect.user.VO.Department;
import com.java.architect.user.VO.ResponseTemplateVO;
import com.java.architect.user.entity.UserEntity;
import com.java.architect.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        log.info("-- In service of User Save --");
        return  userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("-- In service of User get --");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        UserEntity user = userRepository.findByUserId(userId);
        log.info("-- In service of User Details --"+ user.getDepartmentId());
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
