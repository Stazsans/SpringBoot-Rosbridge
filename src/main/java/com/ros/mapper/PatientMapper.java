package com.ros.mapper;

import com.ros.domain.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ss
* @description 针对表【patient】的数据库操作Mapper
* @createDate 2023-07-02 15:59:40
* @Entity com.ros.domain.Patient
*/
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {

}




