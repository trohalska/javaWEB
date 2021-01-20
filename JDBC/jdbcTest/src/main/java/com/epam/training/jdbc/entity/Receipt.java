package com.epam.training.jdbc.entity;

import java.util.Date;

public class Receipt {
	private long id;
	private String total;
	private long accountId;
	private long aprovedById;
	private long status_id;
	private String description;
	private Date create_date;
	private Date last_update;

	public static Receipt createReceipt(String description, int statusId) {
		Receipt r = new Receipt();
		r.setDescription(description);
		r.setStatus_id(statusId);
		return r;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAprovedById() {
		return aprovedById;
	}

	public void setAprovedById(long aprovedById) {
		this.aprovedById = aprovedById;
	}

	public long getStatusId() {
		return status_id;
	}

	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", total=" + total + ", accountId=" + accountId + ", aprovedById=" + aprovedById
				+ ", status_id=" + status_id + ", description=" + description + ", create_date=" + create_date
				+ ", last_update=" + last_update + "]";
	}

}
