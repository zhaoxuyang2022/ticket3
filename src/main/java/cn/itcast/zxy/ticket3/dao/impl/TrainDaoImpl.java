package cn.itcast.zxy.ticket3.dao.impl;

import cn.itcast.zxy.ticket3.dao.TrainDao;
import cn.itcast.zxy.ticket3.domain.Train;
import cn.itcast.zxy.ticket3.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainDaoImpl implements TrainDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<Train> findAll() {
        String sql = "select * from tickets";
        List<Train> trains = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Train>(Train.class));
        return trains;
    }

    @Override
    public void buy(int uid) {
        String sql = "update tickets set num = num - 1 where id = ?;";
        jdbcTemplate.update(sql,uid);
    }

    @Override
    public List<Train> complexFind(Map<String, String[]> map) {
        String sql = "select * from tickets where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = map.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keys) {
            String value = map.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Train>(Train.class),params.toArray());
    }
}
