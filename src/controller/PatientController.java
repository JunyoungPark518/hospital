package controller;

import javax.swing.JOptionPane;

import domain.*;
import enums.Butt;
import service.PatientService;
import serviceImpl.PatientServiceImpl;

public class PatientController {
	public void start() {
		PatientService service = new PatientServiceImpl();
		PatientBean pat = null;
		Butt[] buttons = {Butt.EXIT, Butt.REGISTER, Butt.BMI, Butt.UPDATE, Butt.DELETE };
		Butt[] change = {Butt.EXIT, Butt.NAME, Butt.GEN, Butt.SSN, Butt.ADDR, Butt.PHONE, Butt.EMAIL};
		Butt select = (Butt)JOptionPane.showInputDialog(null, "PATIENT PAGE", "SELECT PATIENT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
		Butt changeinfo = null;
		while(true) {
			switch (select) {
			case REGISTER:
				String[] str = input("아이디/이름/성별/주민번호/주소/전화번호/이메일").split("/");
				pat = new PatientBean();
				pat.setUid(str[0]);
				pat.setName(str[1]);
				pat.setGen(str[2]);
				pat.setSsn(str[3]);
				pat.setAddr(str[4]);
				pat.setPhone(str[5]);
				pat.setEmail(str[6]);
				service.register(pat);
				break;
			case BMI:
				String[] bmi = input("몸무게(kg)/키(cm)").split("/");
				pat = new PatientBean();
				pat.setWeight(bmi[0]);
				pat.setHeight(bmi[1]);
				show("회원님은 " + service.getBmi(pat) + "입니다.");
				break;
			case UPDATE: 
				pat = new PatientBean();
				pat.setUid(input("아이디를 입력하세요"));
				if(service.findById(pat)!=null) {
					changeinfo = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "변경할 정보는?", JOptionPane.QUESTION_MESSAGE, null, change, change[0]);
					switch(changeinfo) {
					case NAME: pat.setName(input("어떤 이름으로?")); break;
					case ADDR: pat.setAddr(input("어떤 주소로?")); break;
					case PHONE: pat.setPhone(input("어떤 전화번호로?")); break;
					case EMAIL: pat.setEmail(input("어떤 이메일주소로?")); break;
					case EXIT: return;
					default: break;
					}
				} else {
					show("검색한 아이디가 존재하지 않습니다.");
				}
				break;
			case DELETE: 
				pat = new PatientBean();
				pat.setUid(input("아이디를 입력하세요"));
				if(service.findById(pat)!=null) {
					if(JOptionPane.showConfirmDialog(null, "정말 삭제할까요?") == 0) {
						service.remove(pat);
					}
				} else {
					show("검색한 아이디가 존재하지 않습니다.");
				}
				break;
			case EXIT:
				show("프로그램을 종료합니다.");
				return;
			default:
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
	
}
