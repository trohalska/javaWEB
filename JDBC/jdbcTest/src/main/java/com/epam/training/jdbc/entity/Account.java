package com.epam.training.jdbc.entity;

import java.util.Date;

public class Account {
	private long id;
	private String login;
	private String password;
	private long roleId;
	private Date createDate;
	private Date lastUpdate;

	static Account createAccount(String login, String password, long roleId) {
		Account account = new Account();
		account.setLogin(login);
		account.setPassword(password);
		account.setRoleId(roleId);
		return account;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		return "Account [login=" + login + ", password=<PROTECTED>, roleId=" + roleId 
				+ ", createTime=" + createDate 
				+ ", lastUpdate=" + lastUpdate + "]";
	}

	
}
