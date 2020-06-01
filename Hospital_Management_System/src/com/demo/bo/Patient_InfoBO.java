package com.demo.bo;

import java.util.HashMap;
import java.util.Map;

import com.demo.dao.Patient_InfoDAO;
import com.demo.exception.Patient_InfoManagementException;
import com.demo.exception.Patient_InfoNotFoundException;
import com.demo.vo.Patient_InfoVO;

public class Patient_InfoBO {
	Patient_InfoDAO dao=new Patient_InfoDAO();
	public boolean addPatient(Patient_InfoVO vo) throws Patient_InfoManagementException 
	{
		boolean flag;
		flag=dao.addPatientdetails(vo);
		return flag;		
	}
	public boolean updatePatientDetails(Patient_InfoVO vo) throws Patient_InfoManagementException 
	{
		boolean flag;
		flag=dao.updatePatientDetails(vo);
		return flag;
		
	}
	public Patient_InfoVO fetchPatientById(int patient_id) throws Patient_InfoNotFoundException 
	{
		Patient_InfoVO vo=new Patient_InfoVO();
		vo=dao.fetchPatientById(patient_id);
		return vo;
	}
	public Map<Integer,Patient_InfoVO> fetchPatientByName(String patient_name) throws Patient_InfoNotFoundException 
	{
		Map<Integer,Patient_InfoVO>map=new HashMap<Integer,Patient_InfoVO>();
		map=dao.fetchPatientByName(patient_name);
		return map;
	}

}

