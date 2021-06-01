package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;
import bank.vo.Account;

public class JoinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//id, password 가지고 와서 DB에 저장
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Account account = new Account(id,pwd); //id,password를 넣어주는 생성자 만들기
		//money는 default 0
		Service s = Service.getInstance();
		s.join(account);
		
		HttpUtil.forward(request, response, "/index.jsp");
		
	}

}
