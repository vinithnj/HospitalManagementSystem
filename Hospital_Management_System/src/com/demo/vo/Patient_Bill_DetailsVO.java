package com.demo.vo;

import java.sql.Date;

public class Patient_Bill_DetailsVO {
private int bill_id;
private Date date;
@Override
public String toString() {
	return "Patient_Bill_DetailsVO [bill_id=" + bill_id + ", date=" + date + ", patient_id=" + patient_id
			+ ", room_number=" + room_number + ", scan_id=" + scan_id + ", bill_amount=" + bill_amount
			+ ", getBill_id()=" + getBill_id() + ", getDate()=" + getDate() + ", getPatient_id()=" + getPatient_id()
			+ ", getRoom_number()=" + getRoom_number() + ", getScan_id()=" + getScan_id() + ", getBill_amount()="
			+ getBill_amount() + "]";
}
public int getBill_id() {
	return bill_id;
}
public void setBill_id(int bill_id) {
	this.bill_id = bill_id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public int getRoom_number() {
	return room_number;
}
public void setRoom_number(int room_number) {
	this.room_number = room_number;
}
public int getScan_id() {
	return scan_id;
}
public void setScan_id(int scan_id) {
	this.scan_id = scan_id;
}
public float getBill_amount() {
	return bill_amount;
}
public void setBill_amount(float bill_amount) {
	this.bill_amount = bill_amount;
}
private int patient_id;
private int room_number;
private int scan_id;
private float bill_amount;
}
