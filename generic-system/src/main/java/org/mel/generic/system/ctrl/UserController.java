package org.mel.generic.system.ctrl;

import javax.annotation.Resource;

import org.mel.framework.response.AbstractResponse;
import org.mel.generic.system.dto.UserCreateRequest;
import org.mel.generic.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class UserController {
	protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping(value="users", method = RequestMethod.POST)
	public AbstractResponse create(@RequestBody final UserCreateRequest request) {
		logger.debug("CreateUserParams->{}", request);
		userService.saveUser(request);
		return AbstractResponse.createResponse(true, "Create success!");
	}
}
