package com.cd.zjyf.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.shuodong
 *地区树形结构
 */
public class AreaTree {
		private String code;//地区编码
		private String fullname;//全称
		private String name;//简称
		private List<AreaTree> children;

		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<AreaTree> getchildren() {
			return children;
		}
		public void setchildren(List<AreaTree> children) {
			this.children = children;
		}
		
		public void setItem(AreaTree areaTree) {
			List<AreaTree> children = new ArrayList<AreaTree>();
			children.add(areaTree);
			this.children = children;
		}
}	
