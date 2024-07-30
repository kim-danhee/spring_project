package shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class admin_Controller {
	
	PrintWriter pw = null;
	
	@Resource(name="shopping")
	private admin_module am;
	
	
	@GetMapping("/admin/admin_list.do")
	private String admin_list(Model m, HttpServletResponse res){
		List<admin_dao> list = am.adminlist();
		
		/*this.pw.print(""
				+ "sessionStorage.setItem('mname','"+list.get(2)+"');"
				+ "sessionStorage.setItem('mid','"+list.get(3)+"');"
				+ "sessionStorage.setItem('mpw','"+list.get(4)+"');"
				+ "sessionStorage.setItem('memail','"+list.get(5)+"');"
				+ "sessionStorage.setItem('mteam','"+list.get(7)+"');"
				+ "sessionStorage.setItem('mposition','"+list.get(8)+"');"
				+ "sessionStorage.setItem('mdate','"+list.get(9)+"')");
		this.pw.close();*/
		
		m.addAttribute("list",list);
				
		return null;
	}
	
	@PostMapping("/admin/add_masterok.do")
	private String add_masterok(@ModelAttribute("admin") admin_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		
		this.pw = res.getWriter();
		try {
			int callback = am.add_master(dao);
			if(callback > 0) {
				this.pw.print("<script>alert('성공적으로 등록되었습니다. (※ 가입완료 후 전산 담당자가 확인 후 로그인 할 수 있습니다.)'); location.href='./admin_list.do'; </script>");				
				//System.out.println(dao);
			}else {
				this.pw.print("<script>alert('등록에 실패하였습니다.'); history.go(-1); </script>");
			}
		}catch(Exception e) {
			System.out.println(e);
			this.pw.print("db오류발생");
		}finally {
			pw.close();
		}
		return null;
	}
	
	
	@GetMapping("/admin/idcheck.do")
	public String idcheck(@RequestParam(defaultValue = "", required = false) String mid,HttpServletResponse res) {
		res.setContentType("text/html; charset=utf-8");
		
		try {
			if(!mid.equals("")) {
				String checks=am.ajax_id(mid);
				this.pw=res.getWriter();
				this.pw.write(checks);
			}
		} catch (Exception e) {
			this.pw.write("error");
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	
	@PostMapping("/admin/admin_main.do")
	private String add_master() {
		
		
		return null;
	}
	
	
}
