package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.demo.bo.Patient_InfoBO;
import com.demo.exception.Patient_InfoManagementException;
import com.demo.exception.Patient_InfoNotFoundException;
import com.demo.response.Patient_InfoResponseObject;
import com.demo.vo.Patient_InfoVO;

public class Patient_InfoService {
	Patient_InfoBO bo = new Patient_InfoBO();
	Patient_InfoResponseObject obj = new Patient_InfoResponseObject();

	public Patient_InfoResponseObject addPatientdetails(Patient_InfoVO vo) throws Patient_InfoManagementException {
		boolean flag;
		try {
			flag = bo.addPatient(vo);
			if (flag)
				obj.setSuccessMessage("Patient Added Successfully");
			else
				obj.setFailureMessage("Error When Adding Patient Details, Reach out Administrator");

		} catch (Patient_InfoManagementException e) {
			obj.setFailureMessage("Error When Adding The Patient Details" + e.getMessage());
		}

		return obj;

	}

	public Patient_InfoResponseObject updatePatientDetails(Patient_InfoVO vo) throws Patient_InfoManagementException {
		boolean flag;
		try {
			flag = bo.updatePatientDetails(vo);
			if (flag)
				obj.setSuccessMessage("Patient Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating Patient Details, Reach out Administrator");

		} catch (Patient_InfoManagementException e) {
			obj.setFailureMessage("Error When Updating The Patient Details" + e.getMessage());
		}

		return obj;
	}
	public Patient_InfoResponseObject fetchPatientById(int patient_id) throws Patient_InfoNotFoundException 
	{

		try {
			Patient_InfoVO vo;
			vo = bo.fetchPatientById(patient_id);
			obj.setPatientInfoVo(vo);
		} catch (Patient_InfoNotFoundException e) {
			obj.setFailureMessage("Error when Fetching" + e.getMessage());
		}

		return obj;

	}
	public Patient_InfoResponseObject fetchPatientByName(String patient_name) throws Patient_InfoNotFoundException 

	{

		try {
			Map<Integer,Patient_InfoVO>map=new HashMap<Integer,Patient_InfoVO>();
			map= bo.fetchPatientByName(patient_name);
			obj.setPatientInfoMap(map);
		} catch (Patient_InfoNotFoundException e) {
			obj.setFailureMessage("Error when Fetching" + e.getMessage());
		}

		return obj;

	}
}
