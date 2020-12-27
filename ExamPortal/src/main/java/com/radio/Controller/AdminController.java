package com.radio.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.radio.Controller.Reposetory.QuestionRepo;
import com.radio.Controller.Reposetory.TestRepo;
import com.radio.Etity.Question;
import com.radio.Etity.Test;

@Controller
public class AdminController 
{
	@Autowired
	TestRepo trepo;
	
	@Autowired
	QuestionRepo qrepo;
	
	Test t;
	
	@RequestMapping("admindashboard")
	public String admindashboard(Model m)
	{
		List<Test> tlist = trepo.findAll();
		m.addAttribute("tlist", tlist);
		return "admindashboard.jsp";
	}
	
	@RequestMapping("questionmgmt{id}")
	public String questionmgmt(@PathVariable int id , Model m)
	{
		t=trepo.getOne(id);
		List<Question> qlisttest = new ArrayList<Question>(t.getQuestions());
		List<Question> qlistdb = qrepo.findAll();
		
		m.addAttribute("testname", t.gettName());
		m.addAttribute("qlisttest", qlisttest);
		m.addAttribute("qlistdb", qlistdb);
		
		return "questionmgmt.jsp";
	}
	
	@RequestMapping("addquestion{id}")
	public String addquestion(@PathVariable int id)
	{
		trepo.abcd(t.getId(), id);
		return "forward:/questionmgmt"+t.getId();
	}
	
	@RequestMapping("removequestion{id}")
	public String removequestion(@PathVariable int id)
	{
		trepo.abcdremovequestion(t.getId(), id);
		return "forward:/questionmgmt"+t.getId();
	}
	
	@RequestMapping("/{name}")
	public String addtest(@PathVariable String name)
	{
		Test t = new Test();
		t.settName(name);
		trepo.save(t);
		return "redirect:/admindashboard";
	}
}
