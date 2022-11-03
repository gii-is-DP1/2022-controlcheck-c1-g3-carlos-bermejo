package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryroomtypes")
public class RecoveryRoomType extends BaseEntity{
    
	@Column(name = "name")
	@Size(max = 50, min = 3)
	@NotEmpty
	String name;
}
