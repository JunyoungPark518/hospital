package service;

import domain.PatientBean;

public interface HospitalService {
	public String getBmi(PatientBean pat);
	public String evalGender(String ssn);
}
