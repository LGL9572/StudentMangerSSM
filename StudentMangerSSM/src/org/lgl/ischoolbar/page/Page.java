package org.lgl.ischoolbar.page;

import org.springframework.stereotype.Component;

/**
 * .分页类封装
 * @author Lenovo
 *
 */
@Component
public class Page {
	private int page;//当前页
	private int rows;//每页显示数量
	private int offset;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getOffset() {
		this.offset = (page-1)*rows;
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = (page-1)*rows;
	}
	

}
