package com.demo.response;

import com.demo.vo.Patient_Bill_DetailsVO;

public class Patient_Bill_DetailsResponseObject {
	String successMessage;
	String failureMessage;
	Patient_Bill_DetailsVO patientBillDetailsVo;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public Patient_Bill_DetailsVO getPatientBillDetailsVo() {
		return patientBillDetailsVo;
	}
	public void setPatientBillDetailsVo(Patient_Bill_DetailsVO patientBillDetailsVo) {
		this.patientBillDetailsVo = patientBillDetailsVo;
	}

}
