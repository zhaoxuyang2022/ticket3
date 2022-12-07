package cn.itcast.zxy.ticket3.domain;

public class Train {
    private int id;
    private String train_time;
    private String train_name;
    private String origin;
    private String destination;
    private int num;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrain_time() {
        return train_time;
    }

    public void setTrain_time(String train_time) {
        this.train_time = train_time;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", train_time='" + train_time + '\'' +
                ", train_name='" + train_name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", num=" + num +
                '}';
    }
}
