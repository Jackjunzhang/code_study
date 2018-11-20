package com.biyilin.user.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.biyilin.mapper.UserMapper;
import com.biyilin.pojo.User;
import com.biyilin.pojo.UserExample;
import com.biyilin.pojo.UserExample.Criteria;
import com.biyilin.user.service.UserService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<User> findAll() {
		return userMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<User> page=   (Page<User>) userMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(User user) {
		
		user.setCreatime(new Date());//用户注册时间
		user.setUpdateTime(new Date());//修改时间
//		user.setSourceType("1");//注册来源
		user.setPassword( DigestUtils.md5Hex(user.getPassword()));//密码加密
		
		userMapper.insert(user);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(User user){
		userMapper.updateByPrimaryKey(user);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public User findOne(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			userMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		
		if(user!=null){			
						if(user.getUsername()!=null && user.getUsername().length()>0){
				criteria.andUsernameLike("%"+user.getUsername()+"%");
			}
			if(user.getPassword()!=null && user.getPassword().length()>0){
				criteria.andPasswordLike("%"+user.getPassword()+"%");
			}
			if(user.getConpany()!=null && user.getConpany().length()>0){
				criteria.andConpanyLike("%"+user.getConpany()+"%");
			}
			if(user.getEmail()!=null && user.getEmail().length()>0){
				criteria.andEmailLike("%"+user.getEmail()+"%");
			}
			if(user.getPhoneMan()!=null && user.getPhoneMan().length()>0){
				criteria.andPhoneManLike("%"+user.getPhoneMan()+"%");
			}
			if(user.getCompanyDesc()!=null && user.getCompanyDesc().length()>0){
				criteria.andCompanyDescLike("%"+user.getCompanyDesc()+"%");
			}
			if(user.getAddress()!=null && user.getAddress().length()>0){
				criteria.andAddressLike("%"+user.getAddress()+"%");
			}
			if(user.getStatus()!=null ){
				criteria.andStatusEqualTo(user.getStatus());
			}

			if(user.getQq()!=null && user.getQq().length()>0){
				criteria.andQqLike("%"+user.getQq()+"%");
			}

			if(user.getMoney()!=null && user.getMoney().length()>0){
				criteria.andMoneyLike("%"+user.getMoney()+"%");
			}
	
		}
		
		Page<User> page= (Page<User>)userMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}



	
}
