package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.Patient_InfoManagementException;
import com.demo.exception.Patient_InfoNotFoundException;
import com.demo.vo.Patient_InfoVO;

public class Patient_InfoDAO {
	public boolean addPatientdetails(Patient_InfoVO vo)throws Patient_InfoManagementException
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
			String query="INSERT INTO patient_info (patient_name,address,contact_number,in_out_online,doctor_id)VALUES(?,?,?,?,?)";
			stmt=connection.prepareStatement(query);
			
			stmt.setString(1,vo.getPatient_name());
			stmt.setString(2,vo.getAddress());
			stmt.setLong(3,vo.getContact_number());
			stmt.setInt(4,vo.getIn_out_online());
			stmt.setInt(5,vo.getDoctor_id());
            stmt.executeUpdate();
			flag = true;
		}
		catch(SQLException e){
			throw new Patient_InfoManagementException("Error when Adding Patient"+e.getMessage());
			
		}
		finally{
			try{
				stmt.close();
				connection.close();
			
			
			}
			catch(SQLException e){
				throw new Patient_InfoManagementException("Error when Adding Patient"+e.getMessage());

			}
			
		}
		return flag;
}

public boolean updatePatientDetails(Patient_InfoVO vo)throws Patient_InfoManagementException
{
	boolean flag=false;
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/hospital_management";
	Connection connection=null;
	PreparedStatement stmt=null;
	try{
		connection=DriverManager.getConnection(url,userName,password);
		String query="UPDATE patient_info SET patient_name=?,address=?,contact_number=?,in_out_online=?,doctor_id=? WHERE patient_id=?";
		stmt=connection.prepareStatement(query);
		stmt.setString(1,vo.getPatient_name());
		stmt.setString(2,vo.getAddress());
		stmt.setLong(3,vo.getContact_number());
		stmt.setInt(4, vo.getIn_out_online());
		stmt.setInt(5, vo.getDoctor_id());
		stmt.setInt(6, vo.getPatient_id());

		stmt.executeUpdate();
		flag=true;
	}catch(SQLException e){
		throw new Patient_InfoManagementException("Error when Updating Patient"+e.getMessage());
	}finally{
		try{
			stmt.close();
			connection.close();
		}catch(SQLException e){
			throw new Patient_InfoManagementException("Error when Updating Patient"+e.getMessage());

		}
	}
	return flag;
	
}
public Patient_InfoVO fetchPatientById(int patient_id)throws Patient_InfoNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/hospital_management";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	Patient_InfoVO vo=new Patient_InfoVO();
	try{
		connection=DriverManager.getConnection(url,userName,password);
		String query="select * from patient_info where patient_id=?";
		stmt=connection.prepareStatement(query);
		stmt.setInt(1, patient_id);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			vo.setPatient_id(rs.getInt("patient_id"));
			vo.setPatient_name(rs.getString("patient_name"));
			vo.setAddress(rs.getString("address"));
			vo.setContact_number(rs.getLong("contact_number"));
			vo.setIn_out_online(rs.getInt("in_out_online"));
			vo.setDoctor_id(rs.getInt("doctor_id"));
			
		}
	}
	catch(SQLException e)
	{
		throw new Patient_InfoNotFoundException("Error when Fetching Patient"+e.getMessage());
	}
	finally
	{
		try{
			stmt.close();
			connection.close();
		}catch(SQLException e){
			throw new Patient_InfoNotFoundException("Error when Fetching Patient"+e.getMessage());

			
		}
	}
	return vo;
}
public Map<Integer,Patient_InfoVO> fetchPatientByName(String patient_name)throws Patient_InfoNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/hospital_management";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	Patient_InfoVO vo=new Patient_InfoVO();
	Map<Integer,Patient_InfoVO> map=new HashMap<Integer,Patient_InfoVO>();
	try{
		connection=DriverManager.getConnection(url,userName,password);
		String query="select * from patient_info where patient_name=?";
		stmt=connection.prepareStatement(query);
		stmt.setString(1, patient_name);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			vo.setPatient_id(rs.getInt("Patient_id"));
			vo.setPatient_name(rs.getString("patient_name"));
        	vo.setAddress(rs.getString("address"));
			vo.setContact_number(rs.getLong("contact_number"));
			vo.setIn_out_online(rs.getInt("in_out_online"));
			vo.setDoctor_id(rs.getInt("doctor_id"));
			Integer patient_id=vo.getPatient_id();
			map.put(patient_id, vo);
		}
	}
	catch(SQLException e){
		throw new Patient_InfoNotFoundException("Error when Fetching Patient"+e.getMessage());
	}finally{
		try{
			stmt.close();
			connection.close();
		}catch(SQLException e){
			throw new Patient_InfoNotFoundException("Error when Fetching Patient"+e.getMessage());

		}
	}
	return map;
}

}
	
