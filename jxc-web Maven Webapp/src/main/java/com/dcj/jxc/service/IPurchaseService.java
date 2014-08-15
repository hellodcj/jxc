package com.dcj.jxc.service;

import java.util.List;

import com.dcj.dto.PurchaseDto;
import com.dcj.jxc.model.PurchaseOrder;

public interface IPurchaseService {

	void savePurchase(PurchaseDto dto);

	List<PurchaseOrder> listByMonth(String month);

}
