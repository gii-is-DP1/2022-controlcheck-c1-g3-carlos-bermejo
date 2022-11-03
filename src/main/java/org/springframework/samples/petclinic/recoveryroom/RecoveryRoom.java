package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryrooms")
public class RecoveryRoom extends BaseEntity{

	@Column(name = "name")
	@Size(max = 50, min = 3)
	@NotEmpty
    String name;
    
	@Column(name = "size")
    @PositiveOrZero
    @NotEmpty
    double size;
    
    @Column(name = "secure")
    @NotEmpty
    boolean secure;
    
    
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    RecoveryRoomType roomType;
}
