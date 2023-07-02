package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.Drug;
import com.ros.service.DrugService;
import com.ros.mapper.DrugMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【drug】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug>
    implements DrugService{

}




