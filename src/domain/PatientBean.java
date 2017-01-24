package domain;

public class PatientBean extends MemberBean {
	private String job;
	private int nurId, docId;
	private double height, weight;
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getNurId() {
		return nurId;
	}
	
	public void setNurId(int nurId) {
		this.nurId = nurId;
	}
	
	public int getDocId() {
		return docId;
	}
	
	public void setDocId(int docId) {
		this.docId = docId;
	}
	
	@Override
	public String toString() {
		return String.format(
				"환자ID: %s\n"
				+ "간호사ID: %s\n"
				+ "의사ID: %s\n"
				+ "환자성명: %s\n"
				+ "환자성별: %s\n"
				+ "주민번호(800101-1): %s\n"
				+ "주소: %s\n"
				+ "전화번호: %s\n"
				+ "이메일: %s\n"
				+ "직업: %s\n", 
				super.uid, nurId, docId, super.name, super.gen, super.ssn, super.addr, super.phone, super.email, job);
	}
}
