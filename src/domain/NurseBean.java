package domain;

public class NurseBean extends MemberBean {
	private String majorJob, position;
	
	public String getMajorJob() {
		return majorJob;
	}
	
	public void setMajorJob(String majorJob) {
		this.majorJob = majorJob;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return String.format(
				"간호사ID: %s\n"
				+ "담당진료과목: %s\n"
				+ "성명: %s\n"
				+ "성별: %s\n"
				+ "전화번호: %s\n"
				+ "이메일: %s\n"
				+ "직급: %s\n", 
				super.uid, majorJob, super.name, super.gen, super.phone, super.email, position);
	}
	
}
