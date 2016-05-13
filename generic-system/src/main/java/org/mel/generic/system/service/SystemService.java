package org.mel.generic.system.service;

import java.util.List;

import org.mel.security.domain.Node;
import org.mel.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {
	@Autowired
	private SecurityService securityService;

	public List<Node> getAllMenu() {
		return securityService.getAllMenu();
	}
	
}
