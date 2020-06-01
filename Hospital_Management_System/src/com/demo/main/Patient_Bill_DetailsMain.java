package com.demo.main;

import java.sql.Date;
import java.util.Scanner;

import com.demo.exception.Patient_Bill_DetailsManagementException;
import com.demo.exception.Patient_Bill_DetailsNotFoundException;
import com.demo.response.Patient_Bill_DetailsResponseObject;
import com.demo.service.Patient_Bill_DetailsService;
import com.demo.vo.Patient_Bill_DetailsVO;

public class Patient_Bill_DetailsMain {

	public static void main(String[] args) throws Patient_Bill_DetailsManagementException, Patient_Bill_DetailsNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Patient Bill Details");
		System.out.println("2. Fetch BIll Details by patient id");
		System.out.println("3. Fetch BIll Details by Bill id");
		System.out.println("4. Update Patient Bill Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			 addPatientBilldetails();
			break;
		case 2:
			fetchBillDetailsByPatientId();
			break;
		case 3:
			fetchBillDetailsByBillId();
			break;
		case 4:
			updatePatientBilldetails();
			break;
		default:
			System.exit(0);
		}
	}
	private static void addPatientBilldetails() throws Patient_Bill_DetailsManagementException {
		// TODO Auto-generated method stub
		Patient_Bill_DetailsService patient_Bill_DetailsService = new Patient_Bill_DetailsService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Date:");
		Date date=Date.valueOf(s.nextLine());
	
		System.out.println("Please Enter The Patient ID:");
		Integer patient_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Room Number:");
		Integer room_number = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Scan Id:");
		Integer scan_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Bill Amount:");
		Float bill_amount = Float.parseFloat(s.nextLine());
		Patient_Bill_DetailsVO vo = new Patient_Bill_DetailsVO();

		vo.setDate(date);
		vo.setPatient_id(patient_id);
		vo.setRoom_number(room_number);
		vo.setScan_id(scan_id);
		vo.setBill_amount(bill_amount);
		Patient_Bill_DetailsResponseObject obj = null;
		obj = patient_Bill_DetailsService.addPatient_Bill_Details(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	private static void updatePatientBilldetails() throws Patient_Bill_DetailsManagementException {
		// TODO Auto-generated method stub
		Patient_Bill_DetailsService patient_Bill_DetailsService = new Patient_Bill_DetailsService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Bill ID:");
		Integer bill_id=Integer.parseInt(s.nextLine());


		System.out.println("Please Enter The Date:");
		Date date=Date.valueOf(s.nextLine());
	
		System.out.println("Please Enter The Patient ID:");
		Integer patient_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Room Number:");
		Integer room_number = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Scan Id:");
		Integer scan_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Bill Amount:");
		Float bill_amount = Float.parseFloat(s.nextLine());
		Patient_Bill_DetailsVO vo = new Patient_Bill_DetailsVO();

		vo.setDate(date);
		vo.setPatient_id(patient_id);
		vo.setRoom_number(room_number);
		vo.setScan_id(scan_id);
		vo.setBill_amount(bill_amount);
		Patient_Bill_DetailsResponseObject obj = null;
		obj = patient_Bill_DetailsService.updatePatient_Bill_Details(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	private static void fetchBillDetailsByPatientId() throws Patient_Bill_DetailsNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Patient ID:");
		Integer patient_id = Integer.parseInt(s.nextLine());

		Patient_Bill_DetailsService patient_Bill_DetailsService = new Patient_Bill_DetailsService();
		Patient_Bill_DetailsResponseObject obj = null;
		obj = patient_Bill_DetailsService.fetchBillDetailsByPatientId(patient_id);
		Patient_Bill_DetailsVO vo = new Patient_Bill_DetailsVO();
		vo = obj.getPatientBillDetailsVo();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Bill_id" + '\t' + "Date" + '\t' + "Patient ID" + '\t' + "Room_number"+ "Scan Id" + '\t' + "Bill Amount");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getBill_id() + "\t\t" + vo.getDate() + "\t\t" + vo.getPatient_id() + "\t\t"
					+ vo.getRoom_number() + vo.getScan_id() + "\t\t"
					+ vo.getBill_amount());
		} else {
			System.out.println(obj.getFailureMessage());
		}
}
	private static void fetchBillDetailsByBillId() throws Patient_Bill_DetailsNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Bill ID:");
		Integer bill_id = Integer.parseInt(s.nextLine());

		Patient_Bill_DetailsService patient_Bill_DetailsService = new Patient_Bill_DetailsService();
		Patient_Bill_DetailsResponseObject obj = null;
		obj = patient_Bill_DetailsService.fetchBillDetailsByBillId(bill_id);
		Patient_Bill_DetailsVO vo = new Patient_Bill_DetailsVO();
		vo = obj.getPatientBillDetailsVo();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Bill_id" + '\t' + "Date" + '\t' + "Patient ID" + '\t' + "Room_number"+ "Scan Id" + '\t' + "Bill Amount");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getBill_id() + "\t\t" + vo.getDate() + "\t\t" + vo.getPatient_id() + "\t\t"
					+ vo.getRoom_number() + vo.getScan_id() + "\t\t"
					+ vo.getBill_amount());
		} else {
			System.out.println(obj.getFailureMessage());
		}
}

	

}
