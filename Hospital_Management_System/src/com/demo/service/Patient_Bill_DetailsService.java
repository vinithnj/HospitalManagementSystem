package com.demo.service;

import com.demo.bo.Patient_Bill_DetailsBO;
import com.demo.bo.Patient_InfoBO;
import com.demo.exception.Patient_Bill_DetailsManagementException;
import com.demo.exception.Patient_Bill_DetailsNotFoundException;
import com.demo.exception.Patient_InfoManagementException;
import com.demo.exception.Patient_InfoNotFoundException;
import com.demo.response.Patient_Bill_DetailsResponseObject;
import com.demo.response.Patient_InfoResponseObject;
import com.demo.vo.Patient_Bill_DetailsVO;
import com.demo.vo.Patient_InfoVO;

public class Patient_Bill_DetailsService {
	Patient_Bill_DetailsBO bo = new Patient_Bill_DetailsBO();
	Patient_Bill_DetailsResponseObject obj = new Patient_Bill_DetailsResponseObject();

	public Patient_Bill_DetailsResponseObject addPatient_Bill_Details(Patient_Bill_DetailsVO vo) throws Patient_Bill_DetailsManagementException {
		boolean flag;
		try {
			flag = bo.addPatient_Bill_Details(vo);
			if (flag)
				obj.setSuccessMessage("Patient Added Successfully");
			else
				obj.setFailureMessage("Error When Adding Patient Details, Reach out Administrator");

		} catch (Patient_Bill_DetailsManagementException e) {
			obj.setFailureMessage("Error When Adding The Patient Details" + e.getMessage());
		}

		return obj;

	}

	public Patient_Bill_DetailsResponseObject updatePatient_Bill_Details(Patient_Bill_DetailsVO vo) throws Patient_Bill_DetailsManagementException {
		boolean flag;
		try {
			flag = bo.updatePatient_Bill_Details(vo);
			if (flag)
				obj.setSuccessMessage("Patient Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating Patient Details, Reach out Administrator");

		} catch (Patient_Bill_DetailsManagementException e) {
			obj.setFailureMessage("Error When Updating The Patient Details" + e.getMessage());
		}

		return obj;
	}
	public Patient_Bill_DetailsResponseObject fetchBillDetailsByPatientId(int patient_id) throws Patient_Bill_DetailsNotFoundException 
	{

		try {
			Patient_Bill_DetailsVO vo;
			vo = bo.fetchBillDetailsByPatientId(patient_id);
			obj.setPatientBillDetailsVo(vo);
		} catch (Patient_Bill_DetailsNotFoundException e) {
			obj.setFailureMessage("Error when Fetching" + e.getMessage());
		}

		return obj;

	}
	public Patient_Bill_DetailsResponseObject fetchBillDetailsByBillId(int bill_id) throws Patient_Bill_DetailsNotFoundException 
	{

		try {
			Patient_Bill_DetailsVO vo;
			vo = bo.fetchBillDetailsByBillId(bill_id);
			obj.setPatientBillDetailsVo(vo);
		} catch (Patient_Bill_DetailsNotFoundException e) {
			obj.setFailureMessage("Error when Fetching" + e.getMessage());
		}

		return obj;

	}

}
