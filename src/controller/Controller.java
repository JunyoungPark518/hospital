package controller;

import javax.swing.JOptionPane;

import domain.*;
import serviceImpl.HospitalServiceImpl;
import constants.Hospital;

public class Controller {
	
	public void start() {
		HospitalServiceImpl bmi = new HospitalServiceImpl();
		DoctorBean doc = null;
		NurseBean nur = null;
		PatientBean pat = null;
		while(true) {
			switch (inputInt(Hospital.EXE_OPTION)) {
			case 1: // 의사 등록
				String docInfo = input(Hospital.DOC_SPEC);
				String[] docInfoArr = docInfo.split(",");
				doc = new DoctorBean();
				doc.setUid(Integer.parseInt((docInfoArr[0])));
				doc.setMajorTreat(docInfoArr[1]);
				doc.setName(docInfoArr[2]);
				doc.setSsn(docInfoArr[3]);
				doc.setPhone(docInfoArr[4]);
				doc.setEmail(docInfoArr[5]);
				doc.setPosition(docInfoArr[6]);
				show(doc.toString());
				break;
			case 2: // 간호사 등록
				String nurInfo = input(Hospital.NUR_SPEC);
				String[] nurInfoArr = nurInfo.split(",");
				nur = new NurseBean();
				nur.setUid(Integer.parseInt(nurInfoArr[0]));
				nur.setMajorJob(nurInfoArr[1]);
				nur.setName(nurInfoArr[2]);
				nur.setGen(bmi.evalGender(nurInfoArr[3]));
				nur.setPhone(nurInfoArr[4]);
				nur.setEmail(nurInfoArr[5]);
				nur.setPosition(nurInfoArr[6]);
				show(nur.toString());
				break;
			case 3: // 환자 등록
				String patInfo = input(Hospital.PAT_SPEC);
				String[] patInfoArr = patInfo.split(",");
				pat = new PatientBean();
				// 아이디, 이름
				pat.setUid(Integer.parseInt(patInfoArr[0]));
				// 의사 및 간호사를 입력하지 않았다면 NullPointerException이 출력. 
				pat.setNurId(nur.getUid());
				pat.setDocId(doc.getUid());
				pat.setName(patInfoArr[1]);
				pat.setGen(bmi.evalGender(patInfoArr[2]));
				pat.setSsn(patInfoArr[2]);
				pat.setAddr(patInfoArr[3]);
				pat.setPhone(patInfoArr[4]);
				pat.setEmail(patInfoArr[5]);
				pat.setJob(patInfoArr[6]);
				show(pat.toString());
				break;
			case 4: // BMI 체크
				// 키, 몸무게
				int id = 0;
				while(true) {
					id = inputInt("환자 아이디 입력");
					if(id == pat.getUid()) {
						pat.setHeight(inputDouble("몸무게?") / 100);
						pat.setWeight(inputDouble("키?"));
						show(String.format("%s은 '%s'입니다.\n", pat.getName(), bmi.getBmi(pat)));
						break;
					} else {
						show("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 0:
				show("프로그램을 종료합니다.");
				return;
			default:
				show("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	private String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	private void show(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	private int inputInt(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	private double inputDouble(String str) {
		return Double.parseDouble(JOptionPane.showInputDialog(str));
	}
}
