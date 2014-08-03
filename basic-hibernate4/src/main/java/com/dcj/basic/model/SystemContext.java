package com.dcj.basic.model;

public class SystemContext {
	/**
	 * 分页大小
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	/**
	 * 分页的起始页
	 */
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	/**
	 * 列表的排序字段
	 */
	private static ThreadLocal<String> sort = new ThreadLocal<String>();
	/**
	 * 列表的排序方式
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	
	public static ThreadLocal<Integer> getPageSize() {
		return pageSize;
	}
	public static void setPageSize(ThreadLocal<Integer> pageSize) {
		SystemContext.pageSize = pageSize;
	}
	public static ThreadLocal<Integer> getPageOffset() {
		return pageOffset;
	}
	public static void setPageOffset(ThreadLocal<Integer> pageOffset) {
		SystemContext.pageOffset = pageOffset;
	}
	public static ThreadLocal<String> getSort() {
		return sort;
	}
	public static void setSort(ThreadLocal<String> sort) {
		SystemContext.sort = sort;
	}
	public static ThreadLocal<String> getOrder() {
		return order;
	}
	public static void setOrder(ThreadLocal<String> order) {
		SystemContext.order = order;
	}
	
	public static void removePageSize() {
		pageSize.remove();
	}
	
	public static void removePageOffset() {
		pageOffset.remove();
	}
	
	public static void removeSort() {
		sort.remove();
	}
	
	public static void removeOrder() {
		order.remove();
	}
}
