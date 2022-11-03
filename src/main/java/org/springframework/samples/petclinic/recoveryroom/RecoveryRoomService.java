package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository rRepo;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository rRepo) {
		this.rRepo = rRepo;
	}
	
	
    public List<RecoveryRoom> getAll(){
        return rRepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return rRepo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
    	return rRepo.getRecoveryRoomType(typeName);
    }
    
    @Transactional(rollbackOn = DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
    	List<RecoveryRoom> ls = rRepo.findAll();
    	for (RecoveryRoom room: ls) {
    		if(room.getName().equals(p.getName())) throw new DuplicatedRoomNameException();
    	}
        return rRepo.save(p);       
    }

    
}
