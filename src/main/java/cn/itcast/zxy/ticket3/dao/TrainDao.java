package cn.itcast.zxy.ticket3.dao;

import cn.itcast.zxy.ticket3.domain.Train;

import java.util.List;
import java.util.Map;

public interface TrainDao {
    public List<Train> findAll();
    public void buy(int uid);
    public List<Train> complexFind(Map<String, String[]> map);
}
