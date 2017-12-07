package top.dreamyy.cardapp.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import top.dreamyy.cardapp.domain.Card;
import top.dreamyy.cardapp.service.CardService;

@Controller
public class CardController {
	/**
	 * 自动注入UserService
	 */
	@Autowired
	@Qualifier("cardService")
	private CardService cardService;

	
	@RequestMapping("/allCardController")
	public ModelAndView getAll(ModelAndView mv){
			List<Card> cards = new ArrayList<>();
			cards = cardService.getAllCard();
			mv.addObject("card", cards);
			System.out.println("card:"+cards);
			mv.setViewName("forward:/main");
			return mv;
	}
	@RequestMapping("/allCardController1")
	public ModelAndView getAll1(ModelAndView mv){
		List<Card> cards = new ArrayList<>();
		cards = cardService.getAllCard();
		mv.addObject("card", cards);
		System.out.println("card:"+cards);
		mv.setViewName("/delete");
		return mv;
	}
	@RequestMapping("/allCardController2")
	public ModelAndView getAll2(ModelAndView mv){
		List<Card> cards = new ArrayList<>();
		cards = cardService.getAllCard1();
		mv.addObject("card", cards);
		System.out.println("card:"+cards);
		mv.setViewName("/recycle");
		return mv;
	}
	@RequestMapping("/allCardController3")
	public ModelAndView getAll3(ModelAndView mv){
		List<Card> cards = new ArrayList<>();
		cards = cardService.getAllCard();
		mv.addObject("card", cards);
		System.out.println("card:"+cards);
		mv.setViewName("/update");
		return mv;
	}
	
	
	@RequestMapping("/selectCardController")
	public ModelAndView select(
			@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("phone") String phone,
			@RequestParam("company") String company,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			ModelAndView mv
			){
		System.out.println("asdf");
		List<Card> cards = new ArrayList<>();
		cards = cardService.selectCard(name, gender, phone, company, address, email);
		mv.addObject("card", cards);
		System.out.println("sekectcard:"+cards);
		mv.setViewName("forward:/select");
		return mv;
	}
	
	
	
	@RequestMapping("/addCardController")
	public ModelAndView add(
			@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("phone") String phone,
			@RequestParam("company") String company,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			ModelAndView mv
			){
		cardService.addCard(name, gender, phone, company, address, email);
		mv.setViewName("forward:/main");
		return mv;
	}
	
	@RequestMapping("/updateCardController")
	public ModelAndView update(ModelAndView mv,
			@RequestParam("name") String name){
		mv.addObject("yuanname", name);
		mv.setViewName("forward:/update_next");
		return mv;
	}
	@RequestMapping("/updateCardController1")
	public ModelAndView update1(ModelAndView mv,
			@RequestParam("name") String name,
			@RequestParam("gender") String gender,
			@RequestParam("phone") String phone,
			@RequestParam("company") String company,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			@RequestParam("yuanname") String yuanname){
		cardService.updateCard(name, gender, phone, company, address, email,yuanname);
		mv.setViewName("forward:/main");
		return mv;
	}
	
	
	 
	@RequestMapping("/deleteCardController")
	public ModelAndView delete(ModelAndView mv,
			@RequestParam("name") String name){
		System.out.println("!!!!"+name);
		cardService.deleteCard(name);
		mv.setViewName("forward:/main");
		return mv;
	}
	
	@RequestMapping("/shanchuCardController")
	public ModelAndView deleteRecycle(ModelAndView mv,
			@RequestParam("name") String name){
		System.out.println("!!!!"+name);
		cardService.deleteRecycleCard(name);
		mv.setViewName("forward:/main");
		return mv;
	}
	
	@RequestMapping("/recycleCardController")
	public ModelAndView toRecycle(ModelAndView mv,
			@RequestParam("name") String name){
		System.out.println("recycleCardController! "+name);
		cardService.toRecycle(name);
		mv.setViewName("forward:/recycle");
		return mv;
	}
	@RequestMapping("/huanyuanCardController")
	public ModelAndView toCard(ModelAndView mv,
			@RequestParam("name") String name){
		System.out.println("huanyuanCardController! "+name);
		cardService.toCard(name);
		mv.setViewName("forward:/main");
		return mv;
	}
}
