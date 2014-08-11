package com.dcj.basic.model;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3686000094478187408L;
	private List<T> list;
	private int pageSize;
	private int currentPage;
	private int total;
	private int totalPage;
	
	public PageResult(int pageSize,int currentPage,int total){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.total = total;
		if(pageSize == 0)
			totalPage = 1;
		else
			totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
}
