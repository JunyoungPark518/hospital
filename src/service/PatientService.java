package service;

import domain.PatientBean;

public interface PatientService {
	public String getBmi(PatientBean pat);
	public String evalGender(String ssn);
	public void register(PatientBean pat);
	public PatientBean findById(PatientBean pat);
	public void remove(PatientBean pat);
}
