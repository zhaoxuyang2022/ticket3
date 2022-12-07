package cn.itcast.zxy.ticket3.web;

import cn.itcast.zxy.ticket3.domain.User;
import cn.itcast.zxy.ticket3.service.UserService;
import cn.itcast.zxy.ticket3.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        if(loginUser != null){
            request.setAttribute("register_msg","用户已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            service.register(user);
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
