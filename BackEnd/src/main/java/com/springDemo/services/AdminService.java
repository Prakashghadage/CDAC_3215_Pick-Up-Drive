package com.springDemo.services;

import com.springDemo.RequestDtos.LoginDto;
import com.springDemo.RespDtos.AdminRespDto;

public interface AdminService {

	AdminRespDto authenticate(LoginDto loginInfo);
}
