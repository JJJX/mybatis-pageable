package org.buzheng.mybatis.pageable.domain;

public class User {
	private String username;
	
	private String firstName;
	
	private String lasterName;
	
	private int age;
	
	public User() {
		System.out.println("User init ===============================");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasterName() {
		return lasterName;
	}

	public void setLasterName(String lasterName) {
		this.lasterName = lasterName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName
				+ ", lasterName=" + lasterName + ", age=" + age + "]";
	}
	
	
}
