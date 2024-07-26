package kr.co.dothome;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
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

import com.mysql.cj.xdevapi.JsonArray;

@Controller
public class Web_Controller {
	
	PrintWriter pw = null;
	
	
	
	@GetMapping("/restapi.do")
	//@SessionAttribute : session이 이미 등록되어있는 상황일 경우 해당 정보를 가져올 수 있음
	public String restapi(@SessionAttribute(name="mid", required = false) String mid) throws Exception {
		if(mid==null) {
			System.out.println("로그인 후 이용가능합니다.");
		}else {
			System.out.println("결제내역은 다음과 같습니다.");
		}
		return null;
	}
	
	@PostMapping("/loginok.do")
	public String loginok(@RequestParam(value="", required=false) String mid, HttpSession session){
		if(mid != null || mid!="") {
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800);
		}
		return null;
	}
	
	/*
	@PostMapping("/loginok.do")
	public String loginok(String mid, HttpServletRequest req){
		HttpSession session = req.getSession();
		session.setAttribute("mid", mid);
		session.setMaxInactiveInterval(1800);
		System.out.println(mid);
		return null;
	}
	*/
	
	@CrossOrigin(origins ="*", allowedHeaders = "*")
	@PostMapping("/ajaxok3.do")
	public String ajaxok3(@RequestBody String arr, HttpServletResponse res) throws Exception{
		//System.out.println(arr);
		JSONArray ja = new JSONArray();
		
		
		
		return null;
	}
	
	
	
	
	@CrossOrigin(origins ="*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, HttpServletResponse res) throws Exception{
		System.out.println(all_data);
		JSONObject jo = new JSONObject(all_data);
		JsonArray ja = (JsonArray)jo.get("all_data");
		System.out.println(ja.get(0));
		
		//Front가 dataType="json" => JSON으로 생성하여 결과값을 회신
		JSONObject result = new JSONObject();
		result.put("result", "ok");
		this.pw = res.getWriter();
		this.pw.print(result);
		
		return null;
	}
}
