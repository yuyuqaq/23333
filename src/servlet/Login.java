package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ��¼servlet
 * @author zhangsenlin
 * 2018-06-27
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	/**
	 * ���շ���
	 */
	public Login() {
		super();
	}

	/**
	 * Get���������
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 *����������ȡjson�ַ�����ת�����ַ���
		 */
		BufferedReader bufr =
				new BufferedReader(
						new InputStreamReader(request.getInputStream(),"UTF-8"));
		StringBuilder sBuilder = new StringBuilder("");
		String temp = "";
		while((temp = bufr.readLine()) != null){
			sBuilder.append(temp);
		}
		bufr.close();
		String[] informations = sBuilder.toString().split(",");
		HttpSession session = request.getSession();
		Boolean success = false;
		if (informations[0].equals("1318699937") && informations[1].equals("123456")){
			session.setAttribute("id",informations[0]);
			success = true;
		}
		PrintWriter writer = response.getWriter();
		writer.write(success+"");

	}

	/**
	 * Post��������ݣ�����doGet��������
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
