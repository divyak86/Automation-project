package com.mycompany.app;

public class TestProperties {

	public String URL;
	public String userId;
	public String password;
	public String emptyId;
	public String emptyPwd;
	
	public TestProperties() {
		java.util.Properties props = ReadConfigFile.readFromFile();
		URL = props.getProperty("URL");
		userId = props.getProperty("userId");
		password = props.getProperty("password");
		emptyId=props.getProperty("emptyuserId");
		emptyPwd=props.getProperty("emptypassword");
	}

	public String getEmptyId() {
		return emptyId;
	}

	public void setEmptyId(String emptyId) {
		this.emptyId = emptyId;
	}

	public String getEmptyPwd() {
		return emptyPwd;
	}

	public void setEmptyPwd(String emptyPwd) {
		this.emptyPwd = emptyPwd;
	}

	public String getURL() {
		
		return URL;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}

	
}
