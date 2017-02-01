package controller;

import javax.swing.JOptionPane;

import domain.*;
import enums.Butt;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start() {
		AdminService service = new AdminServiceImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT, Butt.REGISTER, Butt.FIND_BY_ID, Butt.FIND_BY_NAME, Butt.LIST, Butt.UPDATE, Butt.DELETE };
		Butt[] jobs = {Butt.EXIT, Butt.DOC, Butt.NUR};
		Butt[] change = {Butt.EXIT, Butt.NAME, Butt.GEN, Butt.SSN, Butt.ADDR, Butt.PHONE, Butt.EMAIL};
		Butt jobselect = null, changeinfo = null;
		String temp = "";
		while(true) {
			Butt select = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "SELECT ADMIN MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
			switch (select) {
			case REGISTER:
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 ID를 등록?",	JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: member = new DoctorBean(); break;
					case NUR: member = new NurseBean(); break;
					case EXIT: break;
					default: break;
				}
				String[] str = input("이름/성별/주민번호/주소/전화번호/이메일").split("/");
				member.setName(str[0]);
				member.setGen(str[1]);
				member.setSsn(str[2]);
				member.setAddr(str[3]);
				member.setPhone(str[4]);
				member.setEmail(str[5]);
				show(member.toString() + "\n입력 성공");
				break;
			case FIND_BY_ID:
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 ID?", JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: member = new DoctorBean(); break;
					case NUR: member = new NurseBean(); break;
					case EXIT: break;
					default: break;
				}
				temp = input("아이디를 입력하세요");
				member.setUid(temp);
				show(service.findById(member).toString());
				break;
			case FIND_BY_NAME: 
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 이름?", JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: member = new DoctorBean(); break;
					case NUR: member = new NurseBean(); break;
					case EXIT: break;
					default: break;
				}
				temp = input("찾으실 이름을 입력하세요");
				member.setUid(temp);
				MemberBean[] findByName = service.findByName(member);
				temp = "";
				for (MemberBean m : findByName) {
					temp += m.toString() + "\n";
				}
				show("검색된 리스트는 다음과 같습니다.\n" +temp);
				break;
			case LIST:
				temp = "";
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 리스트?", JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: 
						DoctorBean[] doctorList = service.doctorList();
						for (DoctorBean d : doctorList) {
							temp += d.toString() + "\n";
						}
						show("의사 리스트\n" + temp);
						break;
					case NUR: 
						NurseBean[] nurseList = service.nurseList();
						for (NurseBean n : nurseList) {
							temp += n.toString() + "\n";
						}
						show("간호사 리스트\n" + temp);
						break;
					case EXIT: break;
					default: break;
				}
				break;
			case UPDATE:
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 정보를 변경할까요?", JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: member = new DoctorBean(); break;
					case NUR: member = new NurseBean(); break;
					case EXIT: break;
					default: break;
				}
				changeinfo = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "변경할 정보?", JOptionPane.QUESTION_MESSAGE, null, change, change[0]);
				switch(changeinfo) {
					case NAME: member.setName(input("어떤 이름으로?")); break;
					case ADDR: member.setAddr(input("어떤 주소로?")); break;
					case PHONE: member.setPhone(input("어떤 전화번호로?")); break;
					case EMAIL: member.setEmail(input("어떤 이메일주소로?")); break;
					case EXIT: break;
					default: break;
				}
				service.change(member);
				break;
			case DELETE:
				jobselect = (Butt)JOptionPane.showInputDialog(null, "ADMIN PAGE", "누구의 정보를 제거할까요?", JOptionPane.QUESTION_MESSAGE, null, jobs, jobs[0]);
				switch(jobselect) {
					case DOC: member = new DoctorBean(); break;
					case NUR: member = new NurseBean(); break;
					case EXIT: break;
					default: break;
				}
				member.setUid(input("삭제할 멤버의 아이디를 입력하세요."));
				if(JOptionPane.showConfirmDialog(null, "정말 삭제할까요?") == 0) {
					service.remove(member);
				}
				break;
			case EXIT:
				int quit = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
				if(quit == 0) {
					return;
				} else {
					break;
				}
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
