package com.demos.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet Called...");
		PrintWriter writer = null;
		JSONArray jArray = new JSONArray();
		UserDetails userDetailsObj;
		ArrayList<UserDetails> userDetailArray = new ArrayList<UserDetails>();
		ResultSet resultSet = new DBConnection().executeSQLQuery("select * from user_details");
		try {
			if (resultSet.next()) {
				do {
					ImageDetails imageDetails;
					ArrayList<ImageDetails> imageArray = new ArrayList<ImageDetails>();
					userDetailsObj = CreateMap(resultSet);
					String query = "SELECT * FROM image_details where col_img_id in (SELECT col_image_id FROM purchase_details where col_user_info_id="
							+ userDetailsObj.getU_id() + ")";
					ResultSet resultSet1 = new DBConnection().executeSQLQuery(query);
					if (resultSet1.next()) {
						do {
							imageDetails = new ImageDetails();
							imageDetails.setImg_id(resultSet1.getInt(ImageDetails.IMG_ID));
							imageDetails.setImg_name(resultSet1.getString(ImageDetails.IMG_NAME));
							imageDetails.setImg_artist(resultSet1.getString(ImageDetails.IMG_ARTIST));
							imageDetails.setImg_category(resultSet1.getString(ImageDetails.IMG_CATEGORY));
							imageDetails.setImg_clkdate(resultSet1.getString(ImageDetails.IMG_CLICKED_DATE));
							imageArray.add(imageDetails);
						} while (resultSet1.next());

					} else {
						imageDetails = new ImageDetails();
						imageArray.add(imageDetails);
					}
					userDetailsObj.setImages(imageArray);

					userDetailArray.add(userDetailsObj);
				} while (resultSet.next());
			}
			for (int i = 0; i < userDetailArray.size(); i++) {
				jArray.add(userDetailArray.get(i).getJSON());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("application/json");
		writer = response.getWriter();
		writer.print(jArray);
		writer.flush();
	}

	private UserDetails CreateMap(ResultSet resultSet) throws SQLException {

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
