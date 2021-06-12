package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_titles")
@EqualsAndHashCode

public class JobTitle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="title_name")
	private String titleName;
	
	
	
	@Column(name="description")
	private String description;
	
	
	
	@Column(name="created_date",columnDefinition = "Date default CURRENT_DATE")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	
	
	
	@Column(name="is_active",columnDefinition ="boolean default true")
	private Boolean isActive=true;
	
	
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	
	
	@OneToMany(mappedBy="jobTitle")
	private List<JobAdvertisement> jobAdvertisements;

}
