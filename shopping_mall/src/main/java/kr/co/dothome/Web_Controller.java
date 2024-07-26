package kr.co.dothome;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysql.cj.xdevapi.JsonArray;

@Controller
public class Web_Controller {
	
	PrintWriter pw = null;
	
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
