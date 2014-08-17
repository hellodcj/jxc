package com.dcj.jxc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.dto.PurchaseDto;
import com.dcj.jxc.dao.IMaterialDao;
import com.dcj.jxc.dao.IPurchaseOderItemDao;
import com.dcj.jxc.dao.IPurchaseOrderDao;
import com.dcj.jxc.dao.IVendorDao;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.PurchaseOrder;
import com.dcj.jxc.model.PurchaseOrderItem;
import com.dcj.jxc.model.Vendor;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService{
	private IPurchaseOrderDao purchaseOrderDao ;
	private IPurchaseOderItemDao purchaseOrderItemDao;
	private IVendorDao vendorDao ;
	private IMaterialDao materialDao;
	
	@Inject
	public void setMaterialDao(IMaterialDao materialDao) {
		this.materialDao = materialDao;
	}

	@Inject
	public void setVendorDao(IVendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	@Inject
	public void setPurchaseOrderDao(IPurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Inject	
	public void setPurchaseOrderItemDao(IPurchaseOderItemDao purchaseOrderItemDao) {
		this.purchaseOrderItemDao = purchaseOrderItemDao;
	}


	@Override
	public void savePurchase(PurchaseDto dto) {
		//1.添加进货单表头信息
		PurchaseOrder po = new PurchaseOrder();
		Vendor vendor = vendorDao.load(dto.getVendor_id());
		
		//设置时间
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dto.getOrderDate());
			po.setOrdertime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		po.setVendor(vendor);
		
		purchaseOrderDao.add(po);
		//2.添加详情信息
		for (int i =0;i<dto.getM_id().length;i++){
			Integer m_id = dto.getM_id()[i];
			Material m = materialDao.load(m_id);
			PurchaseOrderItem poi = new PurchaseOrderItem();
			poi.setMaterial(m);
			poi.setNumber(dto.getNum()[i]);
			poi.setPuerchaseOrder(po);
			poi.setPrice(dto.getPrice()[i]);
			purchaseOrderItemDao.add(poi);
			
			//3.更新物料的库存数量
			m.setStorageNum(m.getStorageNum()+dto.getNum()[i]);
			materialDao.update(m);
		}
		
	}

	@Override
	public List<PurchaseOrder> listByMonth(String month) {
		// TODO Auto-generated method stub
		
		//先做一个实验
		month = "2014-07";
		String start = "2014-07";
		String end = "2014-08";
		String hql = "from PurchaseOrder po where DATE_FORMAT(po.ordertime,'%Y-%m') = ? order by po.ordertime desc ";
		String hql2 = "from PurchaseOrder po where DATE_FORMAT(po.ordertime,'%Y-%m') between ? and ? order by po.ordertime desc";
		List<PurchaseOrder> lp =purchaseOrderDao.list(hql2,new Object[]{start,end});
	//System.out.println(lp.get(1).getItems());
		return lp;
	}

}
