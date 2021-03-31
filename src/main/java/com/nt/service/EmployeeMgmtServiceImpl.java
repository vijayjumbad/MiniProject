package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;
import com.nt.repository.EmployeeRepository;
@Service("empService")
public class EmployeeMgmtServiceImpl implements iEmployeeMgmtService {
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<EmployeeDTO> fetchAllEmp() {
		List<EmployeeBO>listbo=null;
		List<EmployeeDTO>listdto=new ArrayList();
		// use dao
		listbo=(List<EmployeeBO>) empRepo.findAll();
		//copy each bo to each dto
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listdto.size()+1);
			dto.setGrosSalary(dto.getSalary()+dto.getSalary()*0.3f);
			dto.setNetSalary(dto.getGrosSalary()-dto.getGrosSalary()*0.2f);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public String saveEmp(EmployeeDTO dto) {
		int result=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use dao
		bo=empRepo.save(bo);
		return bo==null?"record not saved":"record save";
		
	}

	@Override
	public void removeEmpById(int id) {
		
			empRepo.deleteById(id);
		
	}

	@Override
	public EmployeeDTO fetchEmpById(int id) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		bo=empRepo.findById(id).get();
		dto=new EmployeeDTO();
		// convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String modifyEmpById(EmployeeDTO dto) {
		System.out.println(dto);
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		bo=empRepo.save(bo);
		return bo==null?"record not updates":"record is updates";
	}

}
