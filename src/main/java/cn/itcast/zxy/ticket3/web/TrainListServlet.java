package cn.itcast.zxy.ticket3.web;


import cn.itcast.zxy.ticket3.domain.Train;
import cn.itcast.zxy.ticket3.service.TrainService;
import cn.itcast.zxy.ticket3.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/trainListServlet")
public class TrainListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           Map<String, String[]> map = request.getParameterMap();
           TrainService trainService = new TrainServiceImpl();
           List<Train> trains = trainService.complexFind(map);
           request.setAttribute("trains",trains);
           request.getRequestDispatcher("/train_info.jsp").forward(request,response);
    }
}
