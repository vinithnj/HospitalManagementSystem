package com.demo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.dao.Patient_InfoDAO;
import com.demo.exception.Patient_InfoManagementException;
import com.demo.exception.Patient_InfoNotFoundException;
import com.demo.response.Patient_InfoResponseObject;
import com.demo.service.Patient_InfoService;
import com.demo.vo.Patient_InfoVO;

public class Patient_InfoMain {

	public static void main(String[] args) throws Patient_InfoManagementException, Patient_InfoNotFoundException {
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Patient");
		System.out.println("2. Fetch patient by patient id");
		System.out.println("3. Fetch patient by Name");
		System.out.println("4. Update patient");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			 addPatientdetails();
			break;
		case 2:
			fetchPatientById();
			break;
		case 3:
			fetchPatientName();
			break;
		case 4:
			updatePatientDetails();
			break;
		default:
			System.exit(0);
		}
	}

	private static void addPatientdetails() throws Patient_InfoManagementException {
		// TODO Auto-generated method stub
		Patient_InfoService patientService = new Patient_InfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Patient Name:");
		String patient_name = s.nextLine();

	
		System.out.println("Please Enter The Address:");
		String address = s.nextLine();
		System.out.println("Please Enter The Contact Number:");
		Long contact_number = Long.parseLong(s.nextLine());
		System.out.println("Please Enter The In_Out_Online:");
		Integer in_out_online = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The DoctorId:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		Patient_InfoVO vo = new Patient_InfoVO();

		vo.setPatient_name(patient_name);
		vo.setAddress(address);
		vo.setContact_number(contact_number);
        vo.setIn_out_online(in_out_online);
        vo.setDoctor_id(doctor_id);
		Patient_InfoResponseObject obj = null;
		obj = patientService.addPatientdetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	private static void updatePatientDetails() throws Patient_InfoManagementException {
		// TODO Auto-generated method stub
		Patient_InfoService patientService = new Patient_InfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Patient ID:");
		Integer patient_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Patient Name:");
		String patient_name = s.nextLine();	
		System.out.println("Please Enter The Address:");
		String address = s.nextLine();
		System.out.println("Please Enter The Contact Number:");
		Long contact_number = Long.parseLong(s.nextLine());
		System.out.println("Please Enter The In_Out_Online:");
		Integer in_out_online = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The DoctorId:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		Patient_InfoVO vo = new Patient_InfoVO();
		vo.setPatient_id(patient_id);
		vo.setPatient_name(patient_name);
		vo.setAddress(address);
		vo.setContact_number(contact_number);
        vo.setIn_out_online(in_out_online);
        vo.setDoctor_id(doctor_id);
		Patient_InfoResponseObject obj = null;
		obj = patientService.updatePatientDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchPatientById() throws Patient_InfoNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Patient ID:");
		Integer patient_id = Integer.parseInt(s.nextLine());

		Patient_InfoService patientService = new Patient_InfoService();
		Patient_InfoResponseObject obj = null;
		obj = patientService.fetchPatientById(patient_id);
		Patient_InfoVO vo = new Patient_InfoVO();
		vo = obj.getPatientInfoVo();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("patient_id" + '\t' + "patient_name" + '\t' + "address" + '\t' + "contact_number"+ "in_out_online" + '\t' + "doctor_id");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getPatient_id() + "\t\t" + vo.getPatient_name() + "\t\t" + vo.getAddress() + "\t\t"
					+ vo.getContact_number() + vo.getIn_out_online() + "\t\t"
					+ vo.getDoctor_id());
		} else {
			System.out.println(obj.getFailureMessage());
		}
}
	private static void fetchPatientName() throws Patient_InfoNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Patient Name:");
		String patient_name=s.nextLine();
		Patient_InfoService patientService = new Patient_InfoService();
		Patient_InfoResponseObject obj = null;
		obj = patientService.fetchPatientByName(patient_name);
		Map<Integer,Patient_InfoVO>map=new HashMap<Integer,Patient_InfoVO>();
		map = obj.getPatientInfoMap();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("patient_id" + '\t' + "patient_name" + '\t' + "address" + '\t' + "contact_number"+ "in_out_online" + '\t' + "doctor_id");
			System.out.println(
					"================================================================================================");
			for(Map.Entry<Integer,Patient_InfoVO> entry: map.entrySet())
			{
				System.out.println(entry.getValue());
			}
		} else {
			System.out.println(obj.getFailureMessage());
		}
}
}