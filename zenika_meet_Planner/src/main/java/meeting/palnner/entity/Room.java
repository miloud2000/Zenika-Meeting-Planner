package meeting.palnner.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	// id of the room
	
	@Column(name = "name", unique = true)
	private String name;   // name of the room
	
	@Column(name = "number_places")
	private int nbrplaces;   // number of available places 
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	@JoinTable(name = "room_equipments",joinColumns = { @JoinColumn(name = "room_id") },inverseJoinColumns = { @JoinColumn(name = "equipment_id") })
	private Set<Equipment> equipments ;
	
	

	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	@JoinTable(name = "room_requests",joinColumns = { @JoinColumn(name = "room_id") },inverseJoinColumns = { @JoinColumn(name = "request_id") })
	private Set<Request> requests ;
	
	 
   
}
