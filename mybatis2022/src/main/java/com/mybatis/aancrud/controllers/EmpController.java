package com.mybatis.aancrud.controllers;     
import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.mybatis.aancrud.beans.Emp;    
import com.mybatis.aancrud.dao.EmpDao;
import com.mybatis.aancrud.service.EmpService;

@Controller 
public class EmpController{
	@Autowired 
	EmpService service;
	
	@RequestMapping(value= "/viewemp", method = RequestMethod.GET)
	public String viewemp(Model m) {
		List<Emp> list = service.getEmpList();
		m.addAttribute(list);
		return "viewemp";
	}
	@RequestMapping(value= "/empform", method = RequestMethod.GET)
	public String empform() {
		return "empform";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Emp emp){
        service.saveEmp(emp);    
        return "redirect:/viewemp";//will redirect to viewemp request mapping    
    }
	@RequestMapping(value="editemp/{id}")  
	public String edit(@PathVariable int id, Model m) {
	
		Emp emp = service.getEmpById(id);
		m.addAttribute("emp", emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Emp emp) {
		
		service.updateEmp(emp);
		return "redirect:/viewemp";
	}
	@RequestMapping(value="/deleteemp/{id}", method= RequestMethod.GET)
	public String delete(@PathVariable int id) {
		service.deleteEmp(id);
		return "redirect:/viewemp";
	}
}
