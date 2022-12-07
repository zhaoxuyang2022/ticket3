package cn.itcast.zxy.ticket3.service.impl;

import cn.itcast.zxy.ticket3.dao.TrainDao;
import cn.itcast.zxy.ticket3.dao.impl.TrainDaoImpl;
import cn.itcast.zxy.ticket3.domain.Train;
import cn.itcast.zxy.ticket3.service.TrainService;

import java.util.List;
import java.util.Map;

public class TrainServiceImpl implements TrainService {
    TrainDao dao = new TrainDaoImpl();
    @Override
    public List<Train> findAll() {
        return dao.findAll();
    }

    @Override
    public void buy(String[] uids) {
        for (String uid : uids) {
            dao.buy(Integer.parseInt(uid));
        }
    }

    @Override
    public List<Train> complexFind(Map<String, String[]> map) {
        return dao.complexFind(map);
    }
}
