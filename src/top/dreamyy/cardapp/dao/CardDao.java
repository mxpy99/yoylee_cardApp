package top.dreamyy.cardapp.dao;

import static top.dreamyy.cardapp.util.common.CardConstants.CARDRECYCLETABLE;
import static top.dreamyy.cardapp.util.common.CardConstants.CARDTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import top.dreamyy.cardapp.dao.provider.CardDynaSqlProvider;
import top.dreamyy.cardapp.domain.Card;

public interface CardDao {
	
	//查询所有的名片
	@Select("select name,gender,phone,company,address,email from "+CARDTABLE+" ")
	List<Card> getAllCard();
	//查询所有的名片
	@Select("select name,gender,phone,company,address,email from "+CARDRECYCLETABLE+" ")
	List<Card> getAllCard1();
	
	//动态模糊查询名片
	@SelectProvider(type=CardDynaSqlProvider.class,method="selectCard")
	List<Card> selectCard(String name ,String gender,String phone,String company,String address,String email);
	
	//根据姓名查询名片
	@Select("select * from "+CARDTABLE+" where name = #{name} ")
	Card getCard(String name);
	
	//根据姓名查询回收站名片
	@Select("select * from "+CARDRECYCLETABLE+" where name = #{name} ")
	Card getRecycleCard(String name);
	
	//删除名片
	@Delete("delete from "+CARDTABLE+" where name = #{name}")
	void deleteCard(String name);
	
	//删除回收站名片
	@Delete("delete from "+CARDRECYCLETABLE+" where name = #{name}")
	void deleteRecycleCard(String name);
	
	//添加名片
	@InsertProvider(type=CardDynaSqlProvider.class,method="addCard")
	void addCard(String name ,String gender,String phone,String company,String address,String email);
	
	//向回收站添加名片
	@InsertProvider(type=CardDynaSqlProvider.class,method="addRecycleCard")
	void addRecycleCard(String name ,String gender,String phone,String company,String address,String email);
	
	//更新名片
	@UpdateProvider(type=CardDynaSqlProvider.class,method="updateCard")
	void updateCard(String name ,String gender,String phone,String company,String address,String email,String yuanname);
}	
