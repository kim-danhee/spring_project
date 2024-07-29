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

@Controller
public class admin_Controller {
	
	PrintWriter pw = null;
	
	@Resource(name="shopping")
	private admin_module am;
	
	
	@PostMapping("/admin/admin_list.do")
	private String admin_list(Model m, String mid, HttpServletResponse res){
		List<admin_dao> list = am.adminlist();
		admin_dao dao = null;
		
		if(mid != null) {
			//dao = am.ajax_id(mid);
		}

		
		
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
			}else {
				this.pw.print("<script>alert('등록에 실패하였습니다.'); history.go(-1); </script>");
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println(dao.memail);
			this.pw.print("db오류발생");
		}finally {
			pw.close();
		}
		return null;
	}
	
	
	@GetMapping("/admin/idcheck.do")
	public String idcheck(HttpServletResponse res) {
		
		return null;
	}
	
	@PostMapping("/admin/admin_main.do")
	private String add_master() {
		
		
		return null;
	}
	
	
}
