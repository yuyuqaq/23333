package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * 登录检测拦截器
 * @author zhangsenlin
 * 2018-06-27
 *
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    /**
     *摧毁
     */
    public void destroy() {
    }

    /**
     * 拦截
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();

        // 从session里取员工工号信息
        String id = (String) session.getAttribute("id");
        System.out.println("qingqiu"+path);

        // 登陆页面无需过滤
        if(path.indexOf("js/jQuery1.7.js") > -1
                || path.indexOf("js/jquery-1.8.2.min.js") > -1
                || path.indexOf("js/jquery1.42.min.js") > -1
                || path.indexOf("js/jquery.SuperSlide.js") > -1
                || path.indexOf("js/Validform_v5.3.2_min.js") > -1
                || path.indexOf("Login.html") > -1
                || path.indexOf("images") > -1
                || path.indexOf("css/login.css") > -1
                || path.indexOf("js/login.js") > -1
                || path.indexOf("login") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            System.out.println("tongguo"+path);
            return;
        }
        // 判断如果没有取到员工信息,就跳转到登陆页面
        if (id == null || "".equals(id)) {
            // 跳转到登陆页面
            System.out.println("jujue"+path);
            servletResponse.sendRedirect("/Login.html");
        } else {
            // 已经登陆,继续此次请求
            System.out.println("tongguo"+path);
            chain.doFilter(req, resp);
        }
    }

    /**
     * 初始化
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {

    }

}
