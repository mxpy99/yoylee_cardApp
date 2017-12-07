package top.dreamyy.cardapp.dao;

import static top.dreamyy.cardapp.util.common.CardConstants.USERTABLE;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import top.dreamyy.cardapp.domain.User;

public interface UserDao {
		// 根据登录名和密码查询
		@Select("select * from "+USERTABLE+" where name = #{loginname} and password = #{password}")
		User selectByLoginnameAndPassword(
				@Param("loginname") String loginname,
				@Param("password") String password);

		// 添加用户
		@Insert("insert into  "+USERTABLE+"(name,password,mibao) values(#{name},#{password},#{mibao})")
		void save(User user);
}
