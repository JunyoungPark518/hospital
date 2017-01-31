package service;

import domain.DoctorBean;
import domain.MemberBean;
import domain.NurseBean;

public interface AdminService {
	/*
	 * CREATE: INSERT
	 */
	public void register(MemberBean member);
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(MemberBean member);
	public MemberBean[] findByName(MemberBean member);
	public DoctorBean[] doctorList();
	public NurseBean[] nurseList();
	public int count();
	/*
	 * UPDATE: UPDATE
	 */
	public void change(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(MemberBean member);
	/*
	 * UTIL(Validation)
	 */
	public boolean exist(MemberBean member);
	public int countByName(MemberBean member);
}
