package com.example.phone.directory.dto.page;

public abstract class PageDTO {

	private Long totalElements;
	
	private Long totalPages;
	
	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
}
