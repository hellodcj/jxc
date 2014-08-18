package com.dcj.jxc.service;

import java.util.List;

import com.dcj.dto.SaleDto;
import com.dcj.jxc.model.SaleOrder;

public interface ISaleService {

	void saveSale(SaleDto dto);

	List<SaleOrder> listByMonth(String month);

}
