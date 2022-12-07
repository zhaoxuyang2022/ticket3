package cn.itcast.zxy.ticket3.service;

import cn.itcast.zxy.ticket3.domain.Train;

import java.util.List;
import java.util.Map;

public interface TrainService {
    public List<Train> findAll();
    public void buy(String[] uids);
    public List<Train> complexFind(Map<String, String[]> map);
}
