package org.mel.generic.system.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.request.AbstractRequest;

public class UserCreateRequest extends AbstractRequest {
	private UserDTO user;
	private SecurityUserDTO securityUser;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public SecurityUserDTO getSecurityUser() {
		return securityUser;
	}

	public void setSecurityUser(SecurityUserDTO securityUser) {
		this.securityUser = securityUser;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
