package top.dreamyy.cardapp.dao.provider;

import org.apache.ibatis.jdbc.SQL;


import static top.dreamyy.cardapp.util.common.CardConstants.CARDTABLE;
import static top.dreamyy.cardapp.util.common.CardConstants.CARDRECYCLETABLE;

public class CardDynaSqlProvider {
	public String selectCard(final String name ,final String gender,
			final String phone,final String company,final String address,final String email){
		System.out.println(name+" "+gender);
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(CARDTABLE);
				if(name!="")
					WHERE(" name LIKE '%"+name+"%' ");
				if(gender!="")
					WHERE(" gender LIKE '%"+gender+"%' ");
				if(phone!="")
					WHERE(" phone LIKE '%"+phone+"%' ");
				if(company!="")
					WHERE(" company LIKE '%"+company+"%' ");
				if(address!="") 
					WHERE(" address LIKE '%"+address+"%' ");
				if(email!="")
					WHERE(" email LIKE '%"+email+"%' ");
			}
		}.toString();
		System.out.println(sql);
		return sql;
	}
	public String addCard(final String name ,final String gender,
			final String phone,final String company,final String address,final String email){
		
		return new SQL(){
			{
				INSERT_INTO(CARDTABLE);
				if(name!="")
					VALUES("name", "'"+name+"'");
				if(gender!="")
					VALUES("gender", "'"+gender+"'");
				if(phone!="")
					VALUES("phone",  "'"+phone+"'");
				if(company!="")
					VALUES("company",  "'"+company+"'");
				if(address!="") 
					VALUES("address",  "'"+address+"'");
				if(email!="")
					VALUES("email",  "'"+email+"'");
			}
		}.toString();
	}
	public String addRecycleCard(final String name ,final String gender,
			final String phone,final String company,final String address,final String email){
		System.out.println("添加回收站");
		return new SQL(){
			{
				INSERT_INTO(CARDRECYCLETABLE);
				if(name!="")
					VALUES("name", "'"+name+"'");
				if(gender!="")
					VALUES("gender", "'"+gender+"'");
				if(phone!="")
					VALUES("phone",  "'"+phone+"'");
				if(company!="")
					VALUES("company",  "'"+company+"'");
				if(address!="") 
					VALUES("address",  "'"+address+"'");
				if(email!="")
					VALUES("email",  "'"+email+"'");
			}
		}.toString();
	}
	
	public String updateCard(final String name ,final String gender,
			final String phone,final String company,final String address,final String email,final String yuanname){
		
		return new SQL(){
			{
				UPDATE(CARDTABLE);
				if(name!="")
					SET("name = "+"'"+name+"'");
				if(gender!="")
					SET("gender = "+"'"+gender+"'");
				if(phone!="")
					SET("phone = "+"'"+phone+"'");
				if(company!="")
					SET("company = "+"'"+company+"'");
				if(address!="") 
					SET("address = "+"'"+address+"'");
				if(email!="")
					SET("email = "+"'"+email+"'");
				WHERE("name = '"+yuanname+"'");
			}
		}.toString();
	}
}
