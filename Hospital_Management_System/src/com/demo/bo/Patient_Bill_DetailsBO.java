package com.demo.bo;

import java.util.HashMap;
import java.util.Map;

import com.demo.dao.Patient_Bill_DetailsDAO;
import com.demo.dao.Patient_InfoDAO;
import com.demo.exception.Patient_Bill_DetailsManagementException;
import com.demo.exception.Patient_Bill_DetailsNotFoundException;
import com.demo.vo.Patient_Bill_DetailsVO;
import com.demo.vo.Patient_InfoVO;

public class Patient_Bill_DetailsBO {
	Patient_Bill_DetailsDAO dao=new Patient_Bill_DetailsDAO();
	public boolean addPatient_Bill_Details(Patient_Bill_DetailsVO vo) throws Patient_Bill_DetailsManagementException 
	{
		boolean flag;
		flag=dao.addPatient_Bill_Details(vo);
		return flag;		
	}
	public boolean updatePatient_Bill_Details(Patient_Bill_DetailsVO vo) throws Patient_Bill_DetailsManagementException 
	{
		boolean flag;
		flag=dao.updatePatient_Bill_Details(vo);
		return flag;
		
	}
	public Patient_Bill_DetailsVO fetchBillDetailsByPatientId(int patient_id) throws Patient_Bill_DetailsNotFoundException 
	{
		Patient_Bill_DetailsVO vo=new Patient_Bill_DetailsVO();
		vo=dao.fetchBillDetailsByPatientId(patient_id);
		return vo;
	}
	public Patient_Bill_DetailsVO fetchBillDetailsByBillId(int bill_id) throws Patient_Bill_DetailsNotFoundException 
	{
		Patient_Bill_DetailsVO vo=new Patient_Bill_DetailsVO();
		vo=dao.fetchBillDetailsByBillId(bill_id);
		return vo;
	}
}
