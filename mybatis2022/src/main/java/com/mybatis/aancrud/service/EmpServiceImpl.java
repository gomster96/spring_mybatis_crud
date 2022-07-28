package com.mybatis.aancrud.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.aancrud.beans.*;
import com.mybatis.aancrud.dao.EmpDao;
import com.mybatis.aancrud.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empDao;
	
	@Override
	public Emp getEmpById(int id) {
		return empDao.getEmpById(id);
	}

	@Override
	public List<Emp> getEmpList() {
		return empDao.getEmpList();
	}

	@Override
	public int saveEmp(Emp p) {
		return empDao.saveEmp(p);
	}

	@Override
	public int updateEmp(Emp p) {
		return empDao.updateEmp(p);
	}

	@Override
	public int deleteEmp(int id) {
		return empDao.deleteEmp(id);
	}
	
}