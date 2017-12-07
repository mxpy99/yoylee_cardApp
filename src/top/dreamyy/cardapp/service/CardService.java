package top.dreamyy.cardapp.service;

import java.util.List;

import top.dreamyy.cardapp.domain.Card;
import top.dreamyy.cardapp.domain.User;

public interface CardService {
	
	
	/**********对用户进行操作接口***************/
	/**
	 * 对用户进行登陆操作
	 * @param name 用户名
	 * @param password 用户密码
	 * @return
	 */
	User login(String loginname,String password);
	
	/**
	 * 对用户进行插入操作
	 * @param user 插入的用户
	 */
	void insert(User user);
	
	/**
	 * 查询所有的名片
	 * @return 返回名片的集合
	 */
	List<Card> getAllCard();
	/**
	 * 查询所有的名片
	 * @return 返回名片的集合
	 */
	List<Card> getAllCard1();
	
	
	/**
	 * 模糊查询
	 * @param name
	 * @param gender
	 * @param phone
	 * @param company
	 * @param address
	 * @param email
	 * @return
	 */
	List<Card> selectCard(String name ,String gender,String phone,String company,String address,String email);
	
	
	/**
	 * 删除名片
	 * @param name
	 */
	void deleteCard(String name);
	
	/**
	 * 删除回收站名片
	 * @param name
	 */
	void deleteRecycleCard(String name);
	
	/**
	 * 添加名片
	 * @param name
	 * @param gender
	 * @param phone
	 * @param company
	 * @param address
	 * @param email
	 */
	void addCard(String name ,String gender,String phone,String company,String address,String email);
	
	/**
	 * 更新名片
	 * @param name
	 * @param gender
	 * @param phone
	 * @param company
	 * @param address
	 * @param email
	 * @param yuanname
	 */
	void updateCard(String name, String gender, String phone, String company, String address, String email,
			String yuanname);
	
	/**
	 * 将名片放入回收站
	 * @param name
	 */
	void toRecycle(String name);
	
	/**
	 * 将回收站的名片复原
	 * @param name
	 */
	void toCard(String name);
}
