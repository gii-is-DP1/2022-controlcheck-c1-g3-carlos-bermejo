package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	@Autowired
	private final RecoveryRoomService rService;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService rService) {
		this.rService = rService;
	}
	
    @Override
    public String print(RecoveryRoomType rType, Locale locale) {
    	return rType.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType rrt = this.rService.getRecoveryRoomType(text);
        if(rrt!=null) return rrt;
        else throw new ParseException("type not found: "+ text, 0);
    }
    

}
