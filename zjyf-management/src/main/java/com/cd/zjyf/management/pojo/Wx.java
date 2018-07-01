package com.cd.zjyf.management.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by li.mingyang on 2018/5/22.
 */
@Entity
@Table(name="TBL_WX")
public class Wx {
	
	//公司的APP_ID 和 SECRET
    public static final String APP_ID = "wx97e320860584be61";
    public static final String SECRET = "e743d04b43cbf4d53819458f207e7b83";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String openId;

    private String userId;
    
    public Wx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wx(String openId, String userId) {
		super();
		this.openId = openId;
		this.userId = userId;
	}

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
