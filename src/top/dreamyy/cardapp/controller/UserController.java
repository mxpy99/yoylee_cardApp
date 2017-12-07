package top.dreamyy.cardapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import top.dreamyy.cardapp.domain.User;
import top.dreamyy.cardapp.service.CardService;
import top.dreamyy.cardapp.util.common.CardConstants;

@Controller
public class UserController {

	/**
	 * 自动注入UserService
	 */
	@Autowired
	@Qualifier("cardService")
	private CardService cardService;

	/**
	 * 处理登录请求
	 * 
	 * @param String
	 *            loginname 登录名
	 * @param String
	 *            password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping(value = "/loginController")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session, 
			ModelAndView mv) {
		// 调用业务逻辑组件判断用户是否可以登录
		User user = cardService.login(loginname, password);
		if (user != null) {
			// 将用户保存到HttpSession当中
			session.setAttribute(CardConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			mv.setViewName("forward:/main");
		} else {
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("forward:/loginForm");
		}
		return mv;

	}


	/**
	 * 处理添加请求
	 * 
	 * @param String
	 *            flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param User
	 *            user 要添加用户的对象
	 * @param ModelAndView
	 *            mv
	 */
	@RequestMapping(value = "/registerUser")
	public ModelAndView addUser(@ModelAttribute User user, ModelAndView mv) {
		// 执行添加操作
		cardService.insert(user);
		mv.addObject("message", "注册成功!请登录");
		// 设置客户端跳转到查询请求
		mv.setViewName("forward:/loginForm");
		// 返回
		return mv;
	}

}
