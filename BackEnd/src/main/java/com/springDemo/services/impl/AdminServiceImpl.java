package com.springDemo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo.Repository.AdminRepo;
import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RespDtos.AdminRespDto;
import com.springDemo.entities.Admin;
import com.springDemo.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdminRespDto authenticate(LoginDto loginInfo) {
		// TODO Auto-generated method stub
		System.out.println("admin dto" + loginInfo);
		Admin admin=adminRepo.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword()).get();
		System.out.println("am=dmin "+ admin);
		return adminToDto(admin);
		
	}
	
	private AdminRespDto adminToDto(Admin admin) {
		AdminRespDto adminRespDto=this.modelMapper.map(admin, AdminRespDto.class);
		return adminRespDto;
	}

}
