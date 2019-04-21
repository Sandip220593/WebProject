package com.demos.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Action() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Called...");
		PrintWriter writer = null;
		JSONArray jArray = new JSONArray();
		UserDetails userDetailsObj;
		ArrayList<Integer> usersID = new ArrayList<Integer>();
		ArrayList<UserDetails> userDetailArray = new ArrayList<UserDetails>();
		//response.setContentType("application/json");
		String user_name = request.getParameter("userName");
		ResultSet resultSet = new DBConnection().executeSQLQuery("select * from user_details");
		try {
			/*resultSet.last();
			System.out.println("ResultSet Size : "+resultSet.getRow());
			resultSet.beforeFirst();*/
			if(resultSet.next())
			{
				do{
					userDetailsObj = CreateMap(resultSet);
					userDetailArray.add(userDetailsObj);
					usersID.add(resultSet.getInt(UserDetails.USER_INFO_ID));
				}while(resultSet.next());
			}
			
			for(int i=0;i<userDetailArray.size();i++)
			{
				jArray.add(userDetailArray.get(i).getJSON());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(usersID);
		response.setContentType("application/json");
		writer = response.getWriter();
        writer.print(jArray);
        writer.flush();			
	}
	
	private UserDetails CreateMap(ResultSet resultSet) throws SQLException
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setU_id(resultSet.getInt(UserDetails.USER_INFO_ID));
		userDetails.setU_name(resultSet.getString(UserDetails.USER_NAME));
		userDetails.setU_age(resultSet.getInt(UserDetails.USER_AGE));
		userDetails.setU_occupation(resultSet.getString(UserDetails.USER_OCCUPATION));
		userDetails.setU_street(resultSet.getString(UserDetails.USER_ADDRESS_STREET));
		userDetails.setU_city(resultSet.getString(UserDetails.USER_ADDRESS_CITY));
		userDetails.setU_pincode(resultSet.getString(UserDetails.USER_ADDRESS_PINCODE));
		
		return userDetails;
	}

}
