package com.demo.response;

import java.util.Map;

import com.demo.vo.Patient_InfoVO;

public class Patient_InfoResponseObject {
	String successMessage;
	String failureMessage;
	Patient_InfoVO patientInfoVo;
	Map<Integer,Patient_InfoVO> patientInfoMap;
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
	public Patient_InfoVO getPatientInfoVo() {
		return patientInfoVo;
	}
	public void setPatientInfoVo(Patient_InfoVO patientInfoVo) {
		this.patientInfoVo = patientInfoVo;
	}
	public Map<Integer, Patient_InfoVO> getPatientInfoMap() {
		return patientInfoMap;
	}
	public void setPatientInfoMap(Map<Integer, Patient_InfoVO> patientInfoMap) {
		this.patientInfoMap = patientInfoMap;
	}
	
	

}
