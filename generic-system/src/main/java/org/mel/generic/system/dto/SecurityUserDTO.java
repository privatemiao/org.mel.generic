package org.mel.generic.system.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.domain.UserStatus;

public class SecurityUserDTO {
	private String loginId;
	private String password;
	private UserStatus userStatus;
	private Date lastLogin;

	public SecurityUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
