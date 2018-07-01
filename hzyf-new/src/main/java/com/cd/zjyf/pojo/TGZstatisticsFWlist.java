package com.cd.zjyf.pojo;

import com.cd.zjyf.pojo.qr.TGZstatisticsFWQR;

import java.util.List;

/**
 * Auto-generated: 2018-01-22 14:34:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

/**
 * @author chen.shuodong
 *交接员被收集统计list，包括重量和数量统计
 */
public class TGZstatisticsFWlist {

    private List<TGZstatisticsFWQR> zlList;
    private List<TGZstatisticsFWQR> csList;
    
    
    
	public TGZstatisticsFWlist(List<TGZstatisticsFWQR> zlList, List<TGZstatisticsFWQR> csList) {
		super();
		this.zlList = zlList;
		this.csList = csList;
	}
	/**
	 * @return the csList
	 */
	public List<TGZstatisticsFWQR> getCsList() {
		return csList;
	}
	/**
	 * @param csList the csList to set
	 */
	public void setCsList(List<TGZstatisticsFWQR> csList) {
		this.csList = csList;
	}
	/**
	 * @return the zlList
	 */
	public List<TGZstatisticsFWQR> getZlList() {
		return zlList;
	}
	/**
	 * @param zlList the zlList to set
	 */
	public void setZlList(List<TGZstatisticsFWQR> zlList) {
		this.zlList = zlList;
	}

}