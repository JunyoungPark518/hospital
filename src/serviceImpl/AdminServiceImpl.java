package serviceImpl;

import domain.DoctorBean;
import domain.MemberBean;
import domain.NurseBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	DoctorBean[] docList;
	NurseBean[] nurList;
	private int doccount;
	private int nurcount;
	public AdminServiceImpl() {
		doccount = nurcount = 0;
		docList = new DoctorBean[doccount];
		nurList = new NurseBean[nurcount];
	}
	
	@Override
	public void register(MemberBean member) {
		if(member instanceof NurseBean) {
			if(nurcount == nurList.length) {
				NurseBean[] temp = new NurseBean[nurcount+10];
				System.arraycopy(nurList, 0, temp, 0, nurcount);
				nurList = temp;
			}
			nurList[doccount] = (NurseBean) member;
			doccount++;
		} else if(member instanceof DoctorBean) {
			if(doccount == docList.length) {
				DoctorBean[] temp = new DoctorBean[doccount+10];
				System.arraycopy(docList, 0, temp, 0, doccount);
				docList = temp;
			}
			docList[nurcount] = (DoctorBean) member;
			nurcount++;
		} else {
			
		}
	}

	@Override
	public MemberBean findById(MemberBean member) {
		MemberBean newMember = new MemberBean();
		if(member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getUid().equals(nurList[i].getUid())) {
					newMember = nurList[i];
					break;
				}
			}
		} else if(member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getUid().equals(docList[i].getUid())) {
					newMember = docList[i];
					break;
				}
			}
		}
		return newMember;
	}

	@Override
	public MemberBean[] findByName(MemberBean member) {
		MemberBean[] newMember = new MemberBean[countByName(member)];
		int index = 0;
		if(member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getName().equals(nurList[i].getName())) {
					newMember[index] = nurList[i];
					index++;
				}
			}
		} else if(member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getName().equals(docList[i].getName())) {
					newMember[index] = docList[i];
					index++;
				}
			}
		}
		return newMember;
	}

	@Override
	public int countByName(MemberBean member) {
		int countByName = 0;
		if(member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getName().equals(nurList[i].getName())) {
					countByName++;
				}
			}
		} else if(member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getName().equals(docList[i].getName())) {
					countByName++;
				}
			}
		}
		return countByName;
	}
	
	@Override
	public DoctorBean[] doctorList() {
		return docList;
	}

	@Override
	public NurseBean[] nurseList() {
		return nurList;
	}


	@Override
	public int count() {
		return 0;
	}

	@Override
	public void change(MemberBean member) {
		if(member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getUid().equals(nurList[i].getUid())) {
					member = (NurseBean) member;
					NurseBean temp = (NurseBean) findById(member);
					temp.setAddr(!member.getAddr().equals("") ? member.getAddr() : temp.getAddr());
					temp.setEmail(!member.getEmail().equals("") ? member.getEmail() : temp.getEmail());
					temp.setPhone(!member.getPhone().equals("") ? member.getPhone() : temp.getPhone());
					temp.setName(!member.getName().equals("") ? member.getName() : temp.getName());
//					temp.setPosition();
//					temp.setProfileImg();
					nurList[i] = temp;
					break;
				}
			}
			
		} else if(member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getUid().equals(docList[i].getUid())) {
					DoctorBean temp = (DoctorBean) findById(member);
					temp.setAddr(!member.getAddr().equals("") ? member.getAddr() : temp.getAddr());
					temp.setEmail(!member.getEmail().equals("") ? member.getEmail() : temp.getEmail());
					temp.setPhone(!member.getPhone().equals("") ? member.getPhone() : temp.getPhone());
					temp.setName(!member.getName().equals("") ? member.getName() : temp.getName());
//					temp.setPosition();
//					temp.setProfileImg();
					docList[i] = temp;
					break;
				}
			}
		}
	}

	@Override
	public void remove(MemberBean member) {
		if (member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getUid().equals(nurList[i].getUid())) {
					nurList[i] = nurList[nurcount];
					nurList[nurcount] = null;
					break;
				}
			}
			nurcount--;
		} else if (member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getUid().equals(docList[i].getUid())) {
					docList[i] = docList[doccount];
					docList[doccount] = null;
					break;
				}
			}
			doccount--;
		}
	}

	@Override
	public boolean exist(MemberBean member) {
		boolean exist = false;
		if(member instanceof NurseBean) {
			for(int i=0; i<nurcount; i++) {
				if(member.getUid().equals(nurList[i].getUid())) {
					exist = true;
					break;
				}
			}
		} else if(member instanceof DoctorBean) {
			for(int i=0; i<doccount; i++) {
				if(member.getUid().equals(docList[i].getUid())) {
					exist = true;
					break;
				}
			}
		}
		return exist;
	}
}
