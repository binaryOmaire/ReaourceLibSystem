package com.huijiasoft.model;



import java.util.List;
import java.util.Map;

import com.huijiasoft.model.base.BaseUser;
import com.huijiasoft.utils.SQLUtils;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	
	public static final User usermodel = new User();
	
	
	//Jfinal提供分页
	public Page<User> paginate(int pageNumber,int pageSize){
		
		return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
	}
	
	//未使用Jfinal分页，使用h-ui-admin提供的js分页
	public List<User> getAllUser(){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname,a.area_name from ((((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) left join area a on u.area_id = a.area_id)";
		return  usermodel.find(sql);
	}
	
	
	//获取某个用户管理表
	public User findById_Relation(int id){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname from (((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) where u.id = ?";
		return usermodel.findFirst(sql,id);
	}
	
	public List<User> getUserByAreaId(int area_id){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname from (((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) where area_id = ?";
		return usermodel.find(sql,area_id);
	}
	
	//条件查询用户列表
	public List<User> getUserListByCondition(Map<String,Object> map){
		String sql = "select u.*,d.decname,m.mzname,z.zzmmname,a.area_name from ((((user u left join declare_type d on u.dec_id = d.dec_id) left join mz m on u.mz_id = m.mz_id) left join zzmm z on u.zzmm_id = z.zzmm_id) left join area a on u.area_id = a.area_id) "+SQLUtils.DynamicSQL(map);
		return usermodel.find(sql);
	}
	


	
	

}
