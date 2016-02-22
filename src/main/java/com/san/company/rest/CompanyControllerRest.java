package com.san.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.san.company.pojo.Company;
import com.san.company.pojo.CompanyResponse;
import com.san.company.service.CompanyDetailsService;

@Controller
public class CompanyControllerRest {

	@Autowired
	CompanyDetailsService companyService;
	
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public @ResponseBody CompanyResponse addNewCompany(@RequestBody Company company) {
		
		companyService.addNewCompany(company);
		return new CompanyResponse();
	}

	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	public @ResponseBody CompanyResponse getAllCompanies() {
		
		CompanyResponse response = new CompanyResponse();
		response.setData(companyService.getAllCompanies());
		return response;
	}

	@RequestMapping(value = "/getCompanyDetails/{companyId}", method = RequestMethod.GET)
	public @ResponseBody CompanyResponse getCompanyDetails(@PathVariable String companyId) {

		CompanyResponse response = new CompanyResponse();
		response.setData(companyService.getCompanyDetails(companyId));
		return response;
	}

	@RequestMapping(value = "/updateCompany/{companyId}", method = RequestMethod.POST)
	public @ResponseBody CompanyResponse updateCompany(@PathVariable String companyId, @RequestBody Company company) {
		companyService.updateCompany(companyId, company);
		return new CompanyResponse();
	}

	@RequestMapping(value = "/addBeneficialOwners/{companyId}", method = RequestMethod.POST)
	public @ResponseBody CompanyResponse addBeneficialOwners(@PathVariable String companyId, @RequestBody Company company) {
		companyService.updateCompany(companyId, company);
		return new CompanyResponse();
	}
}
