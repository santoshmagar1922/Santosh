package com.san.company.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.san.company.pojo.Company;
import com.san.company.repository.CompanyDetailsRepository;

@Service
public class CompanyDetailsService {


	public Company getCompanyDetails(@PathVariable String companyId) {
		for (Company comp : CompanyDetailsRepository.getInstance().getCompaniesList()) {
			if(companyId.equals(comp.getCompanyId())) 
				return comp;
		}
		return new Company();
	}

	
	public Company addNewCompany(@RequestBody Company company) {
		CompanyDetailsRepository.getInstance().getCompaniesList().add(company);
		return new Company();
	}

	public List<Company> getAllCompanies() {
		return CompanyDetailsRepository.getInstance().getCompaniesList();
	}
	
	public Company updateCompany(@PathVariable String companyId, @RequestBody Company company) {
		List<Company> companyList = CompanyDetailsRepository.getInstance().getCompaniesList();
		for(int i=0; i < companyList.size(); i++ ) {
			if(companyId.equals(companyList.get(i).getCompanyId())) {
				companyList.remove(i);
				companyList.add(company);
				CompanyDetailsRepository.getInstance().setCompaniesList(companyList);
				return company;
			}
		}
		return new Company();
	}

	public Company addBeneficialOwners(@PathVariable String companyId, Company company) {
		List<Company> companyList = CompanyDetailsRepository.getInstance().getCompaniesList();
		for(int i=0; i < companyList.size(); i++ ) {
			if(companyId.equals(companyList.get(i).getCompanyId())) {
				companyList.remove(i);
				companyList.add(company);
				CompanyDetailsRepository.getInstance().setCompaniesList(companyList);
				return company;
			}
		}
		return new Company();
	}
}
