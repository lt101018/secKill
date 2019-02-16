package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserDO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    UserDO selectByTelephone(String telephone);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}