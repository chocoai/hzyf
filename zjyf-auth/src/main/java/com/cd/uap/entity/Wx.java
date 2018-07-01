package com.cd.uap.entity;

import javax.persistence.*;

/**
 * Created by li.mingyang on 2018/5/22.
 */
@Entity
@Table(name="TBL_WX")
public class Wx {

    public static final String APP_ID = "wx97e320860584be61";

    public static final String SECRET = "e743d04b43cbf4d53819458f207e7b83";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_WX")
    @SequenceGenerator(name = "gen_WX", sequenceName = "SEQ_WX")
    private Integer id;

    private String openId;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
