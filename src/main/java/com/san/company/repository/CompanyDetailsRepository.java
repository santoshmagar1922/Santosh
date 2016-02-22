package com.san.company.repository;

import java.util.ArrayList;
import java.util.List;

import com.san.company.pojo.Company;

public class CompanyDetailsRepository {

	private List<Company> companiesList =  new ArrayList<Company>();
	private static CompanyDetailsRepository instance;
	private static Object lockObj = new Object();
	
	public List<Company> getCompaniesList() {

		return companiesList;
	}

	public void setCompaniesList(List<Company> companiesList) {
		this.companiesList = companiesList;
	}
	
	private CompanyDetailsRepository() {}
	
	public static CompanyDetailsRepository getInstance() {
		if(instance == null) {
			synchronized(lockObj) {
				if(instance == null) {
					instance = new CompanyDetailsRepository();
				}
			}
		}
		return instance;
	}
}
