package com.radio.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.radio.Controller.Reposetory.ResultRepo;
import com.radio.Controller.Reposetory.ReviewRepo;
import com.radio.Controller.Reposetory.StudentRepo;
import com.radio.Controller.Reposetory.TestRepo;
import com.radio.Etity.Question;
import com.radio.Etity.Result;
import com.radio.Etity.Review;
import com.radio.Etity.Student;
import com.radio.Etity.Test;

@Controller
public class AppController 
{
	@Autowired
	HttpSession hs;
	
	@Autowired
	StudentRepo srepo;
	
	@Autowired
	TestRepo trepo;
	
	@Autowired
	ResultRepo rrepo;
	
	Test test;
	
	List<Question> qlist;
	List<Question> qlistdb;
	
	
	@RequestMapping("/")
	public String login(Model m)
	{
		Student s = new Student();
		m.addAttribute("student", s);
		return "Login.jsp";
	}
	
	@RequestMapping("login")
	public String verify(Student user)
	{
		try 
		{
			Student ds = srepo.findByUsername(user.getUsername());
			if (ds.getPassword().compareTo(user.getPassword())==0)
			{
				hs.setAttribute("id", ds.getId());
				hs.setAttribute("role", ds.getRole());
				
				if (ds.getRole()==2)
				{
					return "redirect:/admindashboard";
				}
				else
				{
					return "redirect:/dashboard";
				}
			}
			else
			{
				return "redirect:/";
			}
		}
		catch (Exception e) 
		{
			return "redirect:/";
		}
	}

	
	@RequestMapping("logout")
	public String logout(Student user)
	{
		hs.removeAttribute("id");
		return "redirect:/";
	}
	
	@RequestMapping("dashboard")
	public String dashboard(Model m)
	{
		List<TestResultCombo> trlist = new ArrayList<TestResultCombo>();
		List<Test> tlist = trepo.findAll();
		List<Result> rlist = rrepo.findByStudentId((int)hs.getAttribute("id"));
		
		for (int i = 0; i < tlist.size(); i++) 
		{
			TestResultCombo trc = new TestResultCombo();
			trc.testid = tlist.get(i).getId();
			trc.name = tlist.get(i).gettName();
			trc.attempted = false;
			
			for (int j = 0; j < rlist.size(); j++) 
			{
				if (rlist.get(j).getTest().getId()==trc.testid) 
				{
					trc.attempted=true;
					trc.marks=rlist.get(j).getMarks();
					break;
				}
			}
			trlist.add(trc);
		}
		
		m.addAttribute("trlist", trlist);
		m.addAttribute("rlist", rlist);
		m.addAttribute("tlist", tlist);
		return "StudentDashboard.jsp";
	}
	
	@RequestMapping("attempt{id}")
	public String attempt(@PathVariable int id, Model m)
	{
		test = trepo.getOne(id);
		qlist = new ArrayList<Question>(test.getQuestions());
		
		for (Question question : qlist) 
		{
			question.setAnswer(0);
		}
		oldqin=1;
		return "forward:/0testloop1";
	}
	
	int oldqin=1;
	@RequestMapping("{ans}testloop{que}")
	public String testloop(@PathVariable int ans, @PathVariable int que, Model m)
	{
		qlist.get(oldqin-1).setAnswer(ans);
		if (que==10000) 
		{
			return "redirect:/submit";
		}
		m.addAttribute("sendQue", qlist.get(que-1));
		m.addAttribute("qSize", qlist.size());
		oldqin = que;
		return "QuestionPage.jsp";
	}
	
	@Autowired
	ReviewRepo rerepo;
	@RequestMapping("submit")
	public String submitquestion(Model m)
	{
		int marks = 0;
		Test td = trepo.getOne(test.getId());
		qlistdb = new ArrayList<Question>(td.getQuestions());
		
		for (int ui = 0; ui < qlist.size() ; ui++) 
		{
			for (int di = 0; di < qlistdb.size(); di++) 
			{
				if (qlist.get(ui).getId()==qlistdb.get(di).getId() && qlist.get(ui).getAnswer()==qlistdb.get(di).getAnswer())
				{
					marks++;
				}
			}
		}
		
		m.addAttribute("marks", marks);
		Result r = new Result();
		r.setTest(test);
		r.setStudent(srepo.getOne((int)hs.getAttribute("id")));
		r.setMarks(marks);
		rrepo.save(r);
		
		//code for Review
		
		for (int i = 0; i < qlist.size(); i++) 
		{
			Review rev = new Review();
			rev.setTest(test);
			rev.setStudent(srepo.getOne((int)hs.getAttribute("id")));
			rev.setQuestion(qlistdb.get(i));
			for (int j = 0; j < qlist.size(); j++) 
			{
				if (qlist.get(i).getId()==qlistdb.get(j).getId())
				{
					rev.setUserChoice(qlist.get(j).getAnswer());
				}
			}
			rerepo.save(rev);
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("review{tid}")
	public String review(@PathVariable int tid ,Model m)
	{
		int sid = (int)hs.getAttribute("id");
		List<Review> revlist = rerepo.findByStudentIdAndTestId(sid, tid);
		m.addAttribute("revlist", revlist);
		return "Review.jsp";
	}
}











