package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.Patient;
import com.ros.service.PatientService;
import com.ros.mapper.PatientMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【patient】的数据库操作Service实现
* @createDate 2023-06-30 13:19:42
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

}




