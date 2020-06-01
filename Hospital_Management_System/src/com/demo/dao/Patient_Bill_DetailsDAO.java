package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.Patient_Bill_DetailsManagementException;
import com.demo.exception.Patient_Bill_DetailsNotFoundException;
import com.demo.vo.Patient_Bill_DetailsVO;
import com.demo.vo.Patient_InfoVO;

public class Patient_Bill_DetailsDAO {
	
		public boolean addPatient_Bill_Details(Patient_Bill_DetailsVO vo)throws Patient_Bill_DetailsManagementException
		{
			boolean flag = false;
			String userName="root";
			String password="root123";
			String url="jdbc:mysql://localhost:3306/hospital_management";
			Connection connection=null;
			PreparedStatement stmt=null;
			try
			{
				connection=DriverManager.getConnection(url,userName,password);
				String query="INSERT INTO patient_bill_details (date,patient_id,room_number,scan_id,bill_amount)VALUES(?,?,?,?,?)";
				stmt=connection.prepareStatement(query);
				stmt.setDate(1,vo.getDate());
				stmt.setLong(2,vo.getPatient_id());
				stmt.setInt(3,vo.getRoom_number());
				stmt.setInt(4,vo.getScan_id());
				stmt.setFloat(5,vo.getBill_amount());
	            stmt.executeUpdate();
				flag = true;
			}
			catch(SQLException e){
				throw new Patient_Bill_DetailsManagementException("Ërror when adding patient bill details"+e.getMessage());
				
			}
			finally{
				try{
					stmt.close();
					connection.close();
				
				
				}
				catch(SQLException e){
					throw new Patient_Bill_DetailsManagementException("Ërror when adding patient bill details"+e.getMessage());

				}
				
			}
			return flag;
	}
		public boolean updatePatient_Bill_Details(Patient_Bill_DetailsVO vo)throws Patient_Bill_DetailsManagementException
		{
			boolean flag=false;
			String userName="root";
			String password="root123";
			String url="jdbc:mysql://localhost:3306/hospital_management";
			Connection connection=null;
			PreparedStatement stmt=null;
			try{
				connection=DriverManager.getConnection(url,userName,password);
				String query="UPDATE patient_bill_details SET date=?,patient_id=?,room_number=?,scan_id=?,bill_amount=? WHERE bill_id=?";
				stmt=connection.prepareStatement(query);
				
				stmt.setDate(1,vo.getDate());
				stmt.setInt(2,vo.getPatient_id());
				stmt.setInt(3, vo.getRoom_number());
				stmt.setInt(4, vo.getScan_id());
				stmt.setFloat(5, vo.getBill_amount());
				stmt.setInt(6,vo.getBill_id());
				

				stmt.executeUpdate();
				flag=true;
			}catch(SQLException e){
				throw new Patient_Bill_DetailsManagementException("Ërror when Updating patient bill details"+e.getMessage());

			}finally{
				try{
					stmt.close();
					connection.close();
				}catch(SQLException e){
					throw new Patient_Bill_DetailsManagementException("Ërror when Updating patient bill details"+e.getMessage());

				}
			}
			return flag;
			
		}
		public Patient_Bill_DetailsVO fetchBillDetailsByPatientId(int patient_id)throws Patient_Bill_DetailsNotFoundException
		{
			String userName="root";
			String password="root123";
			String url="jdbc:mysql://localhost:3306/hospital_management";
			Connection connection=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Patient_Bill_DetailsVO vo=new Patient_Bill_DetailsVO();
			try{
				connection=DriverManager.getConnection(url,userName,password);
				String query="select * from patient_bill_details where patient_id=?";
				stmt=connection.prepareStatement(query);
				stmt.setInt(1, patient_id);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					vo.setBill_id(rs.getInt("bill_id"));
					vo.setDate(rs.getDate("date"));
					vo.setPatient_id(rs.getInt("patient_id"));
					vo.setRoom_number(rs.getInt("room_number"));
					vo.setScan_id(rs.getInt("scan_id"));
					vo.setBill_amount(rs.getFloat("bill_amount"));
					
				}
			}
			catch(SQLException e)
			{
				throw new Patient_Bill_DetailsNotFoundException("Error when fetching"+e.getMessage());
			}
			finally
			{
				try{
					stmt.close();
					connection.close();
				}catch(SQLException e){
					throw new Patient_Bill_DetailsNotFoundException("Error when fetching"+e.getMessage());

					
				}
			}
			return vo;
		}
		public Patient_Bill_DetailsVO fetchBillDetailsByBillId(int bill_id)throws Patient_Bill_DetailsNotFoundException
		{
			String userName="root";
			String password="root123";
			String url="jdbc:mysql://localhost:3306/hospital_management";
			Connection connection=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Patient_Bill_DetailsVO vo=new Patient_Bill_DetailsVO();
			try{
				connection=DriverManager.getConnection(url,userName,password);
				String query="select * from patient_bill_details where bill_id=?";
				stmt=connection.prepareStatement(query);
				stmt.setInt(1, bill_id);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					vo.setBill_id(rs.getInt("bill_id"));
					vo.setDate(rs.getDate("date"));
					vo.setPatient_id(rs.getInt("patient_id"));
					vo.setRoom_number(rs.getInt("room_number"));
					vo.setScan_id(rs.getInt("scan_id"));
					vo.setBill_amount(rs.getFloat("bill_amount"));
					
				}
			}
			catch(SQLException e)
			{
				throw new Patient_Bill_DetailsNotFoundException("Error when fetching"+e.getMessage());
			}
			finally
			{
				try{
					stmt.close();
					connection.close();
				}catch(SQLException e){
					throw new Patient_Bill_DetailsNotFoundException("Error when fetching"+e.getMessage());

					
				}
			}
			return vo;
		}
		
	}

