package admin;

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

	@Resource(name = "shopping")
	private admin_module am;
	
	
	@PostMapping("/admin/product_writeok.do")
	public String product_writeok(@ModelAttribute("product") admin_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		
		this.pw = res.getWriter();
		int result = am.product_write(dao);
		if(result > 0) {
			this.pw.print("<script> alert('상품이 성공적으로 등록되었습니다.'); location.href='./product_list.jsp'; </script>");
		}
		else {
			this.pw.print("<script> alert('등록에 실패하였습니다.'); history.go(-1); </script>");
		}
		
		return null;
	}

	
	@GetMapping("/admin/product_write.do")
	public String product_write(Model m) {
		List<admin_dao> list = null;
		
		try {
		list = am.catelist();
		m.addAttribute("list", list);
		
		}
		catch(Exception e) {
		System.out.println(e);
		}
		return "product_write";
	}
	
	
	@GetMapping("/admin/cate_list.do")
	public String cate_list(Model m) throws Exception{		
		List<admin_dao> list = null;
		
		try {
		list = am.catelist();
		m.addAttribute("list", list);
		//System.out.println(list.get(0));
		}
		catch(Exception e) {
		}
		return "cate_list";
	}
	
	
	@PostMapping("/admin/cate_writeok.do")
	public String cate_writeok(@ModelAttribute("cate") admin_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		this.pw = res.getWriter();
		int result = am.cate_write(dao);
		if(result > 0) {
			this.pw.print("<script> alert('카테고리가 등록되었습니다.'); history.go(-1); </script>");
		}
		else {
			this.pw.print("<script> alert('등록에 실패하였습니다.'); history.go(-1); </script>");
		}
		
		return null;
	}
	
	@GetMapping("/admin/admin_sitecheck.do")
	public String sitecheck(Model m, String semail) {
		admin_site_dao dao = null;

		try {
			dao = am.siteinfo(semail);
			m.addAttribute("info",dao);

		} catch (Exception e) {
			System.out.println(e);
		}
		return "admin_sitecheck";
	}

	@GetMapping("/admin/admin_siteinfo_ok.do")
	public String siteinfo(@ModelAttribute("admin") admin_site_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		this.pw = res.getWriter();
		try {
			int result = am.admin_siteinfo(dao);
			if (result > 0) {
				this.pw.print("<script>" + "alert('성공적으로 저장되었습니다.');" + "</script>");
			} else {
				this.pw.print("<script>" + "alert('저장에 실패하였습니다.');" + "</script>");
			}
		} catch (Exception e) {
			System.out.println(e);
			this.pw.print("오류발생");
		} finally {
			pw.close();
		}
		return null;
	}

	@GetMapping("/admin/admin_list.do")
	private String admin_list(Model m, HttpServletResponse res) throws Exception {
		// this.pw = res.getWriter();
		List<admin_dao> list = null;
		// admin_dao dao = null;
		try {
			list = am.adminlist();
			m.addAttribute("list", list);
		} catch (Exception e) {

		}

		return "admin_list";
	}

	@PostMapping("/admin/add_masterok.do")
	private String add_masterok(@ModelAttribute("admin") admin_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");

		this.pw = res.getWriter();
		try {
			int callback = am.add_master(dao);
			if (callback > 0) {
				this.pw.print(
						"<script>alert('성공적으로 등록되었습니다. (※ 가입완료 후 전산 담당자가 확인 후 로그인 할 수 있습니다.)'); location.href='./admin_list.do'; </script>");
				// System.out.println(dao);
			} else {
				this.pw.print("<script>alert('등록에 실패하였습니다.'); history.go(-1); </script>");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(dao);
			this.pw.print("db오류발생");
		} finally {
			pw.close();
		}
		return null;
	}

	@GetMapping("/admin/idcheck.do")
	public String idcheck(@RequestParam(defaultValue = "", required = false) String mid, HttpServletResponse res) {
		res.setContentType("text/html; charset=utf-8");

		try {
			if (!mid.equals("")) {
				String checks = am.ajax_select(mid);
				this.pw = res.getWriter();
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
	private String admin_main() {

		return null;
	}

}
