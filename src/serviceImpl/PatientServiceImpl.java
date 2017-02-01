package serviceImpl;

import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientBean[] patList;
	private int patcount;
	
	public PatientServiceImpl() {
		patcount = 0;
		patList = new PatientBean[patcount];
	}
	
	@Override
	public String getBmi(PatientBean pat) {
		double weight = Double.parseDouble(pat.getWeight()), height = Double.parseDouble(pat.getHeight()) / 100;
		double bmi = weight / (height * height);
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

	@Override
	public void register(PatientBean pat) {
		if(patList.length == patcount) {
			PatientBean[] temp = new PatientBean[patcount+10];
			System.arraycopy(patList, 0, temp, 0, patcount);
			patList = temp;
		}
		patList[patcount++] = pat;
	}

	@Override
	public PatientBean findById(PatientBean pat) {
		PatientBean patient = new PatientBean();
		for (int i=0; i<patcount; i++) {
			if(pat.getUid().equals(patList[i].getUid())) {
				patient = patList[i];
				break;
			}
		}
		return patient;
	}

	@Override
	public void remove(PatientBean pat) {
		for(int i=0; i<patList.length; i++) {
			if(pat.getUid().equals(patList[i].getUid())) {
				patList[i] = patList[patcount];
				patList[patcount--] = null;
				break;
			}
		}
	}

}
