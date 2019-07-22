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
    public boolean addUser(String name, String password) {
//        添加数据检查，异常抛出
        if(name==null || password==null)
        {
            return false;
        }else{
            try{
                Integer i = dataMapper.addUser(name, password);
                if(i!=0){
                    dataMapper.increaseUserNum();
                }
            }catch(Exception e){
                return false;
            }
            return true;
        }
    }

    @Override
    public boolean deleteUserbyname(String name) {
        if(name==null){
            return false;
        }else{
            if ((dataMapper.deleteUserbyname(name) != 0)) {
                dataMapper.decreaseUserNum();
            }
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
    public JSONArray findpart(int pn, int ps){
        List<UserEntity> t = dataMapper.findpart("name",(pn-1)*ps, ps);
        JSONArray a = JSONArray.parseArray(JSON.toJSONString(t));
        return a;
    }

    @Override
    public Integer getTotal(){
        return dataMapper.getUserNum();
    }


}
