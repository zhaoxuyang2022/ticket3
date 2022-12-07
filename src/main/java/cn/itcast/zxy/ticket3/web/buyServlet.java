package cn.itcast.zxy.ticket3.web;

import cn.itcast.zxy.ticket3.service.TrainService;
import cn.itcast.zxy.ticket3.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyServlet")
public class buyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");
        TrainService trainService = new TrainServiceImpl();
        trainService.buy(uids);
        response.sendRedirect(request.getContextPath()+" /trainListServlet");
    }
}
