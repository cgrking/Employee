package com.hybrid.util;

import java.util.Scanner;

public class PaginationTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Pagination paging = new Pagination();
		while (true) {
			System.out.println("pageNo = ");
			int pageNo = scan.nextInt();

			paging.setPageNo(pageNo);
			paging.setTotalItem(175);

			for (int i = paging.getFirstItem(); i <= paging.getLastItem(); i++) {
				System.out.println("item index = " + 1);
			}

			if (!paging.isFirstGroup())
				System.out.println("[이전]");
			else
				System.out.println("    ");

			for (int i = paging.getFirstPage(); i <= paging.getLastPage(); i++) {
				System.out.printf("[%03d] ", i);
			}

			if (!paging.isLastGroup())
				System.out.println("[다음]");
			else
				System.out.println("    ");

		}
	}

	static void test1() {
		Pagination paging = new Pagination();
		for (int i = -2; i < 12; i++) {
			paging.setPageNo(i);
			paging.setTotalItem(195);

		}

		String line = "totalPage = " + paging.getTotalPage() + ", firstGroup = " + paging.isFirstGroup()
				+ ", firstItem = " + paging.getFirstItem() + ", lastItem = " + paging.getLastItem() + ", pageNo = "
				+ paging.getPageNo() + ", firstPage = " + paging.getFirstPage() + ", lastPage = " + paging.getLastPage()
				+ ", lastGroup = " + paging.isLastGroup();
		System.out.println(line);

	}
}
