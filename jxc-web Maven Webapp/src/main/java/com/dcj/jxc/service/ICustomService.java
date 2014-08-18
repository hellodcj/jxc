package com.dcj.jxc.service;

import java.util.List;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Custom;

public interface ICustomService {

	List<Custom> listCustom();

	Pager<Custom> queryCustomList(int pageSize, int pageNo);

	Custom loadCustom(int customId);

	void saveCustom(Custom custom);

	void updateCustom(Custom custom);

}
