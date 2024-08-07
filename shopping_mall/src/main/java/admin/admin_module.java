package admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("shopping")
public class admin_module {

	@Resource(name = "template2")
	private SqlSessionTemplate tm;
	
	public admin_dao menucode_nm(String cname) {
		admin_dao dao = tm.selectOne("shopping_db.menucode_nm", cname);
		
		return dao;
	}
	
	
	//카테고리 리스트
	public List<admin_dao> catelist() {
		List<admin_dao> catelist = new ArrayList<admin_dao>();
		catelist = tm.selectList("shopping_db.cate_list");
		
		return catelist;
	}
	
	//카테고리 신규등록
	public int cate_write(admin_dao dao) {
		int result = tm.insert("shopping_db.cate_write",dao);
		return result;
	}
	
	
	public admin_site_dao siteinfo(String semail){
		admin_site_dao dao = tm.selectOne("shopping_db.admin_infocheck", semail);		
		return dao;
	}
	
	
	//홈페이지 가입 정보 추가
	public int admin_siteinfo(admin_site_dao dao) {
		int result = tm.insert("shopping_db.admin_siteinfo", dao);
		return result;
	}
	
	//신규 관리자 리스트
	public List<admin_dao> adminlist(){
		List<admin_dao> list = new ArrayList<admin_dao>();
		list = tm.selectList("shopping_db.admin_list");
		return list;
	}
	
	public int add_master(admin_dao dao) {
		int result = tm.insert("shopping_db.add_master", dao);

		return result;
	}
	//id별 리스트 출력
	public admin_dao ajax_id(String mid) {
		admin_dao dao = tm.selectOne("shopping_db.ajax_id",mid);
		return dao;
	}
	
	public String ajax_select(String mid) {
		String result=tm.selectOne("shopping_db.ajax_id2",mid);
		return result;
	}
}
