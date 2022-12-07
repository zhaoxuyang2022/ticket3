package cn.itcast.zxy.ticket3.test;


import cn.itcast.zxy.ticket3.service.TrainService;
import cn.itcast.zxy.ticket3.service.impl.TrainServiceImpl;
import org.junit.Test;

public class test {
   @Test
    public void find() {
       TrainService trainService = new TrainServiceImpl();
       System.out.println(trainService.findAll());
   }
}
