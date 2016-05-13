package org.mel.generic.system.ctrl;

import javax.annotation.Resource;

import org.mel.framework.request.GeneralPageRequest;
import org.mel.framework.response.AbstractObjectResponse;
import org.mel.framework.response.AbstractPageResponse;
import org.mel.framework.response.AbstractResponse;
import org.mel.security.dto.SecurityRoleCreateRequest;
import org.mel.security.dto.SecurityRoleDTO;
import org.mel.security.dto.SecurityRoleUpdateRequest;
import org.mel.security.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class RoleController {
	protected static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Resource
	private SecurityService securityService;

	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public AbstractPageResponse<SecurityRoleDTO> search(@RequestBody GeneralPageRequest request) {
		logger.debug("Role search->{}", request);
		return securityService.searchRole(request);
	}

	@RequestMapping(value = "role", method = RequestMethod.POST)
	public AbstractResponse createRole(@RequestBody SecurityRoleCreateRequest request) {
		logger.debug("Role create ->{}", request);
		securityService.createSecurityRoleService(request);
		return AbstractResponse.createResponse(true, "Create success!");
	}

	@RequestMapping(value = "role", method = RequestMethod.PATCH)
	public AbstractResponse updateRole(@RequestBody SecurityRoleUpdateRequest request) {
		logger.debug("Role update ->{}", request);
		securityService.updateSecurityRoleService(request);
		return AbstractResponse.createResponse(true, "Update success!");
	}

	@RequestMapping(value = "role/{id}", method = RequestMethod.GET)
	public AbstractObjectResponse getRole(@PathVariable("id") Long id) {
		return new AbstractObjectResponse(true, "", securityService.findRoleById(id)) {
		};
	}

	@RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
	public AbstractObjectResponse deleteRole(@PathVariable("id") Long id) {
		return new AbstractObjectResponse(true, "", securityService.findRoleById(id)) {
		};
	}
}
