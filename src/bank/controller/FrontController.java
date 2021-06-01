package bank.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	//HashMap변수만 갖고 잇는 것.
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//HashMap 구성하는 작업
		//실제로 HashMap 생성
		map = new HashMap<String, Controller>();
		map.put("/join.do", new JoinController());
		map.put("/login.do", new LoginController());
		map.put("/deposit.do", new DepositController());
		map.put("/withdrawal.do", new WithdrawalController());
		map.put("/query.do", new QueryController());
		map.put("/search.do", new SearchController());
		map.put("/transfer.do", new TransferController());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HashMap에서 값을 가져오는 작업
		String uri =req.getRequestURI(); //bank.join.do
		String contextPath = req.getContextPath(); // /bank까지
		String path = uri.substring(contextPath.length()); // join.do
		
		Controller cont = map.get(path); 
		cont.execute(req, resp);
	}
}
