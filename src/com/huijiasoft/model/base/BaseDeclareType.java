package com.huijiasoft.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDeclareType<M extends BaseDeclareType<M>> extends Model<M> implements IBean {

	public void setDecId(java.lang.Integer decId) {
		set("dec_id", decId);
	}

	public java.lang.Integer getDecId() {
		return get("dec_id");
	}

	public void setDecname(java.lang.String decname) {
		set("decname", decname);
	}

	public java.lang.String getDecname() {
		return get("decname");
	}

}
