package vp.com.mysecondmvpdemo.bean;

/**
 * Created by Administrator on 2017/3/28.
 */

public class ChinaPro {

    /**
     * id : 1
     * name : 北京
     */

    private int id;
    private String name;

    public ChinaPro() {
    }

    public ChinaPro(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
