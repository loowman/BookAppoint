package com.book.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator.OfDouble;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.book.dao.BookDao;
import com.book.dao.StudentDao;
import com.book.dto.AppointExecution;
import com.book.entity.Appointment;
import com.book.entity.Book;
import com.book.entity.Student;
import com.book.enums.AppointStateEnum;
import com.book.enums.Result;
import com.book.exception.NoNumberException;
import com.book.exception.RepeatAppointException;
import com.book.service.BookService;

@Controller
@RequestMapping("/books")
public class ViewController {
   @Autowired
   @Qualifier("bookDao")
	private BookDao bookDao;
	
   @Autowired
	private BookService bookService;
	@RequestMapping("search")
	@ResponseBody
	public List<Book> testControll(@PathParam("name") String name,HttpServletRequest request,HttpServletResponse  response) throws UnsupportedEncodingException {
	
//	String user=new String(name.getBytes("ISO-8859-1"),"utf-8");
//		System.out.println(name);
//		
//		ModelAndView mv=new ModelAndView("index");
//		mv.addObject("list",bookDao.queryByName(name));
		
		  return bookDao.queryByName(name);
	}
	
	@RequestMapping("/{id}/detail")
	public String detail(@PathVariable("id") Integer id,HttpServletRequest req){
//		    ModelAndView mv=new ModelAndView("detail");
//		    Book book=bookDao.queryById(id);
//		    mv.addObject("book", book);
//		    
		     HttpSession session=req.getSession();
		     session.setAttribute("book", bookDao.queryById(id));
		     
		    return "detail";
		    
	}
	
	
	
	@RequestMapping(value="verify",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Result<AppointExecution> execute(@PathVariable("bookId") int bookId,@RequestParam("studentId") int studentId){
		Result<AppointExecution> result;
		AppointExecution execution=null;
		
		try{//手动try catch,在调用appoint方法时可能报错
			execution=bookService.appoint(bookId, studentId);
			result=new Result<AppointExecution>(true,execution); 
				return result; 
				
		} catch(NoNumberException e1) {
			execution=new AppointExecution(bookId,AppointStateEnum.NO_NUMBER);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch(RepeatAppointException e2){
			execution=new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch (Exception e){
			execution=new AppointExecution(bookId,AppointStateEnum.INNER_ERROR); 
			result=new Result<AppointExecution>(true,execution);
				return result;
		} 
	}
	
	@RequestMapping(value="/{bookId}/appoint",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map validate(int studentId,String password){   //(HttpServletRequest req,HttpServletResponse resp){
		Map resultMap=new HashMap(); 
		int i; 
		System.out.println("验证函数"); 
		i =bookService.validateStu(studentId,password);
		
		
		if(i==1){
			System.out.println("SUCCESS");
			resultMap.put("result", "SUCCESS");
			return resultMap;
		}else{ 
			resultMap.put("result", "FAILED");
			return resultMap;
		}
		
	}
	@RequestMapping(value ="/appoint")
	public String appointBooks(@RequestParam("studentId") int studentId,Model model){
		
		List<Appointment> appointList=new ArrayList<Appointment>();
		appointList=bookService.getAppointByStu(studentId);
		model.addAttribute("appointList", appointList);
		 
		return "appointBookList";
	}
	//	@RequestMapping("/test")
//	public ModelAndView test(){
//		ModelAndView mv=new ModelAndView("success");
//		mv.addObject("name",new String("name"));
//		return mv;
//	}
}
