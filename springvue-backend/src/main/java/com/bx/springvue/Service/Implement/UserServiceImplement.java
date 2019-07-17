package com.bx.springvue.Service.Implement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bx.springvue.Entity.UserEntity;
import com.bx.springvue.Mapper.DataMapper;
import com.bx.springvue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImplement implements UserService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public JSONArray findAll() {
        List<UserEntity> t = dataMapper.findAll();
        JSONArray a = JSONArray.parseArray(JSON.toJSONString(t));
        return a;
    }

    @Override
    public boolean addUser(String name, String password) {
//        添加数据检查，异常抛出
        if(name==null || password==null)
        {
            return false;
        }else{
            dataMapper.addUser(name, password);
            return true;
        }
    }

    @Override
    public boolean deleteUserbyname(String name) {
        if(name==null){
            return false;
        }else{
            dataMapper.deleteUserbyname(name);
            return true;
        }
    }

    @Override
    public String getUserpswbyname(String name) {
        try {
            dataMapper.getUserpswbyname(name);
        }catch (Exception e){
            return "";
        }
        return dataMapper.getUserpswbyname(name);
    }

    @Override
    public void updateToken(String name, String token) {
        dataMapper.updateToken(name, token);
    }


}
