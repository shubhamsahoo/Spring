package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {
	 private Locale  locales[];
	 
	 public LocaleServiceImpl() {
		locales=Locale.getAvailableLocales();
	}
	

	@Override
	public List<String> getAllLanguages() {
	   List<String> langList=null;
	   langList=new ArrayList();
	     for(Locale loc:locales) {
	    	 langList.add(loc.getDisplayLanguage());
	     }
		return langList;
	}

	@Override
	public List<String> getAllCountries() {
		  List<String> countryList=null;
		   countryList=new ArrayList();
		     for(Locale loc:locales) {
		    	countryList.add(loc.getDisplayCountry());
		     }
			return countryList;
	}

}
