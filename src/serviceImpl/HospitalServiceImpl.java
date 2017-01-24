package serviceImpl;

import domain.PatientBean;
import service.HospitalService;

public class HospitalServiceImpl implements HospitalService {
	@Override
	public String getBmi(PatientBean pat) {
		double bmi = pat.getWeight() / (pat.getHeight() * pat.getHeight());
		String result = "";
		if(bmi>30) {
			result = "고도비만";
		} else if(bmi>25) {
			result = "비만";
		} else if(bmi>23) {
			result = "과체중";
		} else if(bmi>18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}

	@Override
	public String evalGender(String ssn) {
		String gender;
		char ch = ssn.charAt(7);
		if(ch=='1'||ch=='3') {
			gender = "남자";
		} else if(ch=='2'||ch=='4') {
			gender = "여자";
		} else if(ch=='5'||ch=='6') {
			gender = "외국인";
		} else {
			gender = "알 수 없음";
		}
		return gender;
	}

}
