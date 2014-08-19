package com.dcj.jxc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.dto.SaleDto;
import com.dcj.jxc.dao.ICustomDao;
import com.dcj.jxc.dao.IMaterialDao;
import com.dcj.jxc.dao.ISaleOderItemDao;
import com.dcj.jxc.dao.ISaleOrderDao;
import com.dcj.jxc.model.Custom;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.PurchaseOrder;
import com.dcj.jxc.model.PurchaseOrderItem;
import com.dcj.jxc.model.SaleOrder;
import com.dcj.jxc.model.SaleOrderItem;

@Service("saleService")
public class SaleService implements ISaleService {
	private ICustomDao customDao;
	private ISaleOrderDao saleOrderDao;
	private ISaleOderItemDao saleOrderItemDao;
	private IMaterialDao materialDao;
	
	
	@Inject
	public void setSaleOrderItemDao(ISaleOderItemDao saleOrderItemDao) {
		this.saleOrderItemDao = saleOrderItemDao;
	}
	
	@Inject
	public void setMaterialDao(IMaterialDao materialDao) {
		this.materialDao = materialDao;
	}

	@Inject
	public void setSaleOrderDao(ISaleOrderDao saleOrderDao) {
		this.saleOrderDao = saleOrderDao;
	}

	@Inject
	public void setCustomDao(ICustomDao customDao) {
		this.customDao = customDao;
	}

	@Override
	public void saveSale(SaleDto dto) {
		//1.添加销售单表头信息
		SaleOrder so = new SaleOrder();
		Custom custom = customDao.load(dto.getCustom_id());
		
		//设置时间
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dto.getOrderDate());
			so.setOrdertime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		so.setCustom(custom);
		
		saleOrderDao.add(so);
		//2.添加详情信息
		for (int i =0;i<dto.getM_id().length;i++){
			Integer m_id = dto.getM_id()[i];
			Material m = materialDao.load(m_id);
			SaleOrderItem soi = new SaleOrderItem();
			soi.setMaterial(m);
			soi.setNumber(dto.getNum()[i]);
			soi.setSaleOrder(so);
			soi.setPrice(dto.getPrice()[i]);
			saleOrderItemDao.add(soi);
			
			//3.更新物料的库存数量
			m.setStorageNum(m.getStorageNum()-dto.getNum()[i]);
			materialDao.update(m);
		}
	}

	@Override
	public List<SaleOrder> listByMonth(String month) {
		String hql = "from SaleOrder po where DATE_FORMAT(po.ordertime,'%Y-%m') = ? order by po.ordertime desc";
		List<SaleOrder> lp =saleOrderDao.list(hql,month);
		return lp;
	}

	@Override
	public List<SaleOrder> loadSaleOrderByTime(String time) {
		String hql = "from SaleOrder po where DATE_FORMAT(po.ordertime,'%Y-%m-%d') = ?";
		List<SaleOrder> lp =saleOrderDao.list(hql,time);
		return lp;
	}

}
