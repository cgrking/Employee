package com.hybrid.util;

public class Pagination {

	// read-write
	private int totalItem;
	private int pageNo;

	// read-only
	private int totalPage;
	

	private int firstItem;
	private int lastItem;
	private int firstPage;
	private int lastPage;
	// read-write

	private int itemsPerPage = 10;
	private int pagesPerGroup = 10;

	public void calculate() {
		if (pageNo < 1)
			pageNo = 1;

		// totalPage

		totalPage = totalItem / itemsPerPage;
		if (totalItem % itemsPerPage > 0)
			totalPage++;

		if (pageNo > totalPage)
			pageNo = totalPage;
		if (pageNo == 0)
			pageNo = 1;

		// firstItem

		firstItem = (pageNo - 1) * itemsPerPage + 1;
		// lastItem
		lastItem = firstItem + itemsPerPage - 1;
		if (lastItem > totalItem)
			lastItem = totalItem;

		firstPage = (pageNo - 1) / pagesPerGroup * pagesPerGroup + 1;

		// lastPage

		lastPage = firstPage + (pagesPerGroup - 1);

	}

	public int getTotalItem() {
		return totalItem;
	}
	

	public void setTotalItem(int totalItem) {
		
//		유도 변수들을 계산
		calculate();
		this.totalItem = totalItem;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public int getLastItem() {
		return lastItem;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public int getPagesPerGroup() {
		return pagesPerGroup;
	}

	public void setPagesPerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}

	public boolean isFirstGroup() {
		return (firstPage == 1) ? true : false;

	}

	public boolean isLastGroup() {
		return (lastPage == totalPage) ? true : false;
	}
}
