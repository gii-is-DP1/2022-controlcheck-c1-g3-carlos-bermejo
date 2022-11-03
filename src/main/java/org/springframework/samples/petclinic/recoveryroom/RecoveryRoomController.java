package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private static final String WELCOME = "welcome";
	private static final String VIEWS_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private RecoveryRoomService rService;
    
    @Autowired
    public RecoveryRoomController(RecoveryRoomService rService) {
    	this.rService = rService;
    }
    
    @GetMapping("/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryroom= new RecoveryRoom();
		model.put("recoveryRoom", recoveryroom);
		model.put("types", rService.getAllRecoveryRoomTypes());
		return VIEWS_ROOM_CREATE_OR_UPDATE_FORM;
	}
    
    @PostMapping("/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) throws DuplicatedRoomNameException {
		if (result.hasErrors()) {
			return VIEWS_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.rService.save(recoveryRoom);
			return WELCOME;
		}
	}
    
}
