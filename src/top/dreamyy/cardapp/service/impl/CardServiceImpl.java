package top.dreamyy.cardapp.service.impl;

import top.dreamyy.cardapp.domain.Card;
import top.dreamyy.cardapp.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.rmi.Cardable;

import top.dreamyy.cardapp.dao.CardDao;
import top.dreamyy.cardapp.dao.UserDao;
import top.dreamyy.cardapp.service.CardService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("cardService")
public class CardServiceImpl implements CardService {
	
	//自动给所需对象赋值
	@Autowired
	private UserDao userDao;
	@Autowired
	private CardDao cardDao;
	
	
	
	@Override
	public User login(String loginname, String password) {
		return  userDao.selectByLoginnameAndPassword(loginname, password);
	
	}

	@Override
	public void insert(User user) {
		userDao.save(user);
	}

	@Override
	public List<Card> getAllCard() {
		return cardDao.getAllCard();
	}
	@Override
	public List<Card> getAllCard1() {
		return cardDao.getAllCard1();
	}
	@Override
	public List<Card> selectCard(String name, String gender, String phone, String company, String address,
			String email) {
		
		return cardDao.selectCard(name, gender, phone, company, address, email);
	}

	 

	@Override
	public void addCard(String name, String gender, String phone, String company, String address, String email) {
		cardDao.addCard(name, gender, phone, company, address, email);
	}

	@Override
	public void updateCard(String name, String gender, String phone, String company, String address, String email,
			String yuanname) {
		cardDao.updateCard(name, gender, phone, company, address, email, yuanname);
	}

	@Override
	public void deleteCard(String name) {
		System.out.println(name);
		cardDao.deleteCard(name);
	}
	
	@Override
	public void deleteRecycleCard(String name) {
		cardDao.deleteRecycleCard(name);
	}

	@Override
	public void toRecycle(String name) {
		System.out.println("进来了!!!! "+name);
		Card card = cardDao.getCard(name);
		System.out.println("!!!!!!!!!toRecycle"+name+"  "+card.toString());
		cardDao.addRecycleCard(card.getName(), card.getGender(), card.getPhone(), card.getCompany(), card.getAddress(), card.getEmail());
		cardDao.deleteCard(name);
	}

	@Override
	public void toCard(String name) {
		Card card = cardDao.getRecycleCard(name);
		cardDao.addCard(card.getName(), card.getGender(), card.getPhone(), card.getCompany(), card.getAddress(), card.getEmail());
		cardDao.deleteRecycleCard(name);
	}

	 

}
