package com.dcj.jxc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcj.dto.SaleDto;
import com.dcj.jxc.model.SaleOrder;

@Service("saleService")
public class SaleService implements ISaleService {

	@Override
	public void saveSale(SaleDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SaleOrder> listByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

}
