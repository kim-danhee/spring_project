package pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class pay_controller {
	
	//1페이지 당 데이터 2개식
	@GetMapping("/pay/coupon_list.do")
	public String coupon_list(Model m) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pageno = 2;
		try {
			con = new dbinfo().info();
			String sql = "select * from coupon order by cidx desc limit ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, pageno);
			rs = ps.executeQuery();
			List<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
			//System.out.println(con);	
			while(rs.next()) {
				ArrayList<String> al = new ArrayList<String>();
				al.add(rs.getString(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				al.add(rs.getString(4));
				al.add(rs.getString(5));
				all.add(al);
			}
			m.addAllAttributes(all);
		}
		catch(Exception e) {
			System.out.println("실패");
		}
		finally {
			rs.close();
			ps.close();
		}
		
		return "/coupon_list";
	}
	
	
	@PostMapping("/pay/pay3.do")
	public String pay3(@ModelAttribute("payinfo") pay_dao dao, HttpServletResponse res, HttpServletRequest req) throws Exception {
		req.setAttribute("goodcode", dao.getGoodcode());	//상품코드
		req.setAttribute("goodname", dao.getGoodname());	//상품명
		req.setAttribute("goodea", dao.getGoodea());	//상품수량
		req.setAttribute("goodprice", dao.getGoodprice());	//상품금액
		req.setAttribute("price", dao.getPrice());	//결제금액
		req.setAttribute("buyername", dao.getBuyername());	//결제자이름
		req.setAttribute("buyertel", dao.getBuyertel());	//결제자연락처
		req.setAttribute("buyeremail", dao.getBuyeremail());	//결제자이메일
		req.setAttribute("rec_post", dao.getRec_post());	//결제자 우편번호
		req.setAttribute("rec_way", dao.getRec_way());	//도로명
		req.setAttribute("rec_addr", dao.getRec_addr());	//상세주소
		req.setAttribute("gopaymethod", dao.getGopaymethod());	//결제방식
		
		
		return "pay3";
	}
	
	
	
	
	@PostMapping("/pay/pay2.do")
	public String pay2(@ModelAttribute("product") pay_dao dao, Model m) throws Exception {
		List<String> as = new ArrayList<String>();
		as.add(dao.getProduct_code());
		as.add(dao.getProduct_name());
		as.add(dao.getProduct_money());
		as.add(dao.getProduct_ea());
		as.add(dao.getPrice());
		
		/* List 외 아래 코드도 적용가능
		
		1)
		Collection<String> cl = new ArrayList<String>();
		cl.add(dao.getProduct_code());
		
		2)
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("pdm", dao.getProduct_code());
		m.addAllAttributes(mp);
		
		*/
		
		//addAllAttributes : key가 없음, 단 배열명 + 자료형을 기반으로 JSP에 출력
		m.addAllAttributes(Arrays.asList(as));	//JSP에서 출력을 하기위해서 get(),[]로 출력이 가능함.
		return "pay2";	//WEB-INF/views
		}
	}

