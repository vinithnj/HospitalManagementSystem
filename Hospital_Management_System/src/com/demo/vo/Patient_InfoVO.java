package com.demo.vo;

public class Patient_InfoVO {
	private int patient_id;
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	public int getIn_out_online() {
		return in_out_online;
	}
	public void setIn_out_online(int in_out_online) {
		this.in_out_online = in_out_online;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	private String patient_name;
	@Override
	public String toString() {
		return "Patient_InfoVO [patient_id=" + patient_id + ", patient_name=" + patient_name + ", address=" + address
				+ ", contact_number=" + contact_number + ", in_out_online=" + in_out_online + ", doctor_id=" + doctor_id
				+ ", getPatient_id()=" + getPatient_id() + ", getPatient_name()=" + getPatient_name()
				+ ", getAddress()=" + getAddress() + ", getContact_number()=" + getContact_number()
				+ ", getIn_out_online()=" + getIn_out_online() + ", getDoctor_id()=" + getDoctor_id() + "]";
	}
	private String address;
	private long contact_number;
	private int in_out_online;
	private int doctor_id;
}
