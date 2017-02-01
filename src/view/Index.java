package view;

import javax.swing.JOptionPane;

import controller.AdminController;
import controller.PatientController;
import enums.Butt;

public class Index {
	public static void main(String[] args) {
		Butt[] buttons = {Butt.EXIT, Butt.ADMIN, Butt.PAT};
		Butt select = (Butt)JOptionPane.showInputDialog(
				null, // frame
				"PATIENT PAGE", // framtitle
				"SELECT PATIENT MENU", // order
				JOptionPane.QUESTION_MESSAGE, // type
				null, // icon
				buttons, // Array of choices
				buttons[1] // default
			);
		switch(select) {
		case EXIT: return;
		case ADMIN:
			new AdminController().start();
			break;
		case PAT:
			new PatientController().start();
			break;
		default:
			break;
		}
	}
}
