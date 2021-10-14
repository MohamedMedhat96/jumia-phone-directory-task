package com.example.phone.directory.model.search;

public class SearchObject {

	public SearchField searchField;
	
	public String searchValue;
	
	public SearchField getSearchField() {
		return searchField;
	}

	public void setSearchField(SearchField searchField) {
		this.searchField = searchField;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public enum SearchField{
		COUNTRY("country"),
		STATE("state");
		
		public final String label;
		
		private SearchField(String label) {
			this.label = label;
		}
	}
}
