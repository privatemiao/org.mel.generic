package org.mel.generic.system.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.mel.generic.system.service.SystemService;
import org.mel.security.domain.Node;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system")
public class SystemController {
	@Resource
	private SystemService systemService;

	@RequestMapping(value = "resources", method = RequestMethod.GET)
	@ResponseBody
	public List<Node> resources() {
		return systemService.getAllMenu();
	}
	
	@RequestMapping(value = "personalresources", method = RequestMethod.GET)
	@ResponseBody
	public List<Node> personalResources(){
		return systemService.getAllMenu();
	}
}
