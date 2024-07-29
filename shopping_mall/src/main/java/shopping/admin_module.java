package shopping;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("shopping")
public class admin_module {

	@Resource(name = "template2")
	private SqlSessionTemplate tm;

	
	public List<admin_dao> adminlist(){
		List<admin_dao> list = new ArrayList<admin_dao>();
		list = tm.selectList("shopping_db.admin_list");
		return list;
	}
	
	public int add_master(admin_dao dao) {
		int result = tm.insert("shopping_db.add_master", dao);

		return result;
	}
	
	public String ajax_id(String mid) {
		String result = tm.selectOne("shopping_db.ajax_id",mid);
		return result;
	}
	
}
