package com.cd.zjyf.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 整个是避免返回到前端为null时，用这个对象替代null。直接返回前端null，前端会报错的缘故
 * @author chen.shuodong
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class NullObject {
		private Boolean nullflag;

		/**
		 * @return the nullflag
		 */
		public Boolean isNullflag() {
			return nullflag;
		}

		/**
		 * @param nullflag the nullflag to set
		 */
		public void setNullflag(Boolean nullflag) {
			this.nullflag = nullflag;
		}
		
}
