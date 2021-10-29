package com.web.songtan.domain;

import java.sql.Date;

public class BoardVO {
	private String no;
	private String id;
	private String pw;
	private String name;
	private String tel_no;
	private String delete_yn;
	private Date create_date;
	private Date update_date;
	
	public BoardVO()
	{
		
	}

	public BoardVO(String no, String id, String pw, String name, String tel_no, String delete_yn, Date create_date,
			Date update_date) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel_no = tel_no;
		this.delete_yn = delete_yn;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
}
