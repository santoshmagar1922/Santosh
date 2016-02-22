package com.san.company.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.san.company.pojo.Company;
import com.san.company.pojo.CompanyResponse;
import com.san.company.service.CompanyDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerRestTest {
	
	@Mock
	private CompanyDetailsService companyService;
	
	@InjectMocks
	private CompanyControllerRest classUnderTest = new CompanyControllerRest();

	
	@Test
	public void shouldAddNewCompany() {
		
		Company comp = buildCompany("222", "San2 comp");
		
		CompanyResponse response = classUnderTest.addNewCompany(comp);
		
		Assert.assertNotNull(response);
		Mockito.verify(companyService).addNewCompany(comp);
	}
	
	@Test
	public void shouldGetAllCompanies() {
		
		List<Company> compList = getCompList();
		
		Mockito.when(companyService.getAllCompanies()).thenReturn(compList);
		
		CompanyResponse response = classUnderTest.getAllCompanies();
		
		Assert.assertNotNull(response);
		Assert.assertSame(((List<Company>)response.getData()), compList);
		Mockito.verify(companyService).getAllCompanies();
	}
	
	@Test
	public void shouldGetCompanyDetails() {
		String compId  = "111";
		Company comp = buildCompany("111", "San1 comp");
		Mockito.when(companyService.getCompanyDetails(compId)).thenReturn(comp);
		
		CompanyResponse response = classUnderTest.getCompanyDetails(compId);
		
		Assert.assertNotNull(response);
		Assert.assertSame(((Company)response.getData()), comp);
		Mockito.verify(companyService).getCompanyDetails(compId);
	}
	

	
	private List<Company> getCompList() {
		Company comp1 = buildCompany("111", "San1 comp");
		Company comp2 = buildCompany("222", "San2 comp");
		Company comp3 = buildCompany("333", "San3 comp");
		
		List<Company> compList = new ArrayList<Company>();
		compList.add(comp1);
		compList.add(comp2);
		compList.add(comp3);	
		
		return compList;
	}

	private Company buildCompany(String id, String name) {
		Company comp = new Company();
		comp.setCompanyId(id);
		comp.setCompanyName(name);
		return comp;
	}
}
