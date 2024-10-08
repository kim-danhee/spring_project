package kr.co.dothome;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


//md5 : 회원가입, 로그인, 패스워드 변경, 1:1 문의, 자유게시판, 상품구매,
@Controller
public class Web_Controller extends md5_pass {
	
	PrintWriter pw = null;
	
	//DAO (@ModelAttribute)
	//DAO가 없이 사용 시 자료형 객체 or @Requestparam을 이용해서 사용
	
	@Resource(name="userselect")
	private user_select us;
	
	@PostMapping("/idsearch.do")
	public String idsearch(String[] uname, String uemail, HttpServletResponse res) throws Exception{		//아이디 찾기
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		try {
		if(uname == null || uemail == null) {
			this.pw.print("<script> alert('올바른 접근방식이 아닙니다.'); history.go(-1); </script>");
		}else {
			ArrayList<Object> onedata = us.search_id(uname[0], uemail);
		}
		}catch(Exception e) {
			System.out.println(e);
			this.pw.print("<script> alert('Database문제로 인하여 해당 정보가 확인되지 않았습니다.'); history.go(-1); </script>");
		}finally {
			
		}
		return null;
	}
	
	
	@PostMapping("/passmodify.do")
	public String passmodify() {	//패스워드 변경
		
		return null;
	}
	
	
	/*
	@Resource(name="md5pass")
	private md5_pass md;
	*/
	
	@GetMapping("/passwd.do")
	public String passwd() {
		String pwd ="a1234";
		String result = this.md5_making(pwd);
		System.out.println(result);
		
		return null;
	}
	
	
	@GetMapping("/restapi.do")
	//@SessionAttribute : session이 이미 등록되 있는 상황일 경우 해당 정보를 가져올 수 있음
	public String restapi(@SessionAttribute(name="mid", required = false) String mid)throws Exception {
		if(mid==null) {
			System.out.println("로그인 해야만 결제내역을 확인 하실 수 있습니다.");
		}else {
			System.out.println("결제내역은 다음과 같습니다.");
		}
		return null;
	}
	//HttpSession : interface를 활용하여, 세션을 빠르게 구현하는 방식 스타일
	@PostMapping("/loginok.do")
	public String loginok(@RequestParam(value = "",required = false) String mid, 
			HttpSession session) {
		if(mid != null || mid != "") {
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800);
		}
		return null;
	}
	
	/*
	@PostMapping("/loginok.do")
	public String loginok(String mid, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800);
		System.out.println(mid);
		return null;
	}
	*/
	
	
	//@RequestBody : JOSN.stringfy
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, 
			HttpServletResponse res) throws Exception {
		
		System.out.println(all_data); //{"all_data":[]}
		JSONObject jo = new JSONObject(all_data);//{}인식 시킨후 key값으로 배열을 체크
		//[a,b,c]   
		JSONArray ja = (JSONArray)jo.get("all_data");
		System.out.println(ja.get(0));	//데이터를 출력
		
		//Front가 dataType="json" => JSON으로 생성하여 결과값을 회신
		JSONObject result = new JSONObject();
		result.put("result", "ok");
		this.pw = res.getWriter(); 
		this.pw.print(result);
		return null;
	}
	
	
	
	
	
	//@RequestBody : GET/POST(X) JSON기반일 경우
	//@ResponseBody : 미디어타입, 파라미터타입 단, 인자값에는 미선언
	//ajax통신 CORS 방식
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	//@RequestParam : 배열을 이용하여 대표키로 전달 또는 대표키 없이 보조키로 전달 될 경우 사용할 수 있음
	@GetMapping(value="/ajaxok.do")
	public String ajaxok(@RequestParam(value="all_data") List<String> alldata, 
			HttpServletResponse res) throws Exception {
		System.out.println(alldata);
		System.out.println(alldata.get(0));
		this.pw = res.getWriter();
		JSONObject jo = new JSONObject();
		jo.put("result", "ok");
		this.pw.print(jo);
		
		this.pw.close();
		return null;
	}
	
}