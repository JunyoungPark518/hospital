package service;

import domain.PatientBean;

public interface MemberService {
	public String getBmi(PatientBean pat);
	public String evalGender(String ssn);
}
