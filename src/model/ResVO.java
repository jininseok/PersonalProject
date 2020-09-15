package model;

public class ResVO {
	Integer no;
	String title;
	String content;
	String name;
	String tel;
	String address;
	String regdate;
	String userID;
	String userPassword;
	String userName;
	String userGender;
	String userEmail;
	String first;
	String last;
	
	public ResVO() {
		
	}
	
	
	
	public ResVO(String userID, String userPassword, String userName, String userGender, String userEmail) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
	}



	public ResVO(Integer no, String title, String content, String name, String tel, String address, String regdate,
			String first, String last) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.regdate = regdate;
		this.first = first;
		this.last = last;
	}


	
	

	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserGender() {
		return userGender;
	}



	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	
	
}