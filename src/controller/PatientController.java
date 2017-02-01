package controller;

import javax.swing.JOptionPane;

import domain.*;
import enums.Butt;

public class PatientController {
	public void start() {
//		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT, Butt.DOC, Butt.NUR, Butt.REGISTER, Butt.FIND_BY_ID, Butt.FIND_BY_NAME, Butt.LIST, Butt.RANK, Butt.UPDATE, Butt.DELETE };
		Butt select = (Butt)JOptionPane.showInputDialog(
				null, // frame
				"PATIENT PAGE", // framtitle
				"SELECT PATIENT MENU", // order
				JOptionPane.QUESTION_MESSAGE, // type
				null, // icon
				buttons, // Array of choices
				buttons[0] // default
			);
		while(true) {
			switch (select) {
			case REGISTER:
				String[] str = input("이름/성별/주민번호/주소/전화번호/이메일").split("/");
				member = new PatientBean();
				member.setName(str[0]);
				member.setGen(str[1]);
				member.setSsn(str[2]);
				member.setAddr(str[3]);
				member.setPhone(str[4]);
				member.setEmail(str[5]);
//				service.register(member);
				break;
			case UPDATE: // 등급 조정
				break;
			case DELETE: // 삭제
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
