package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")

public class JobExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="job_place")
	private String jobPlace;
	
	@Column(name="position_name")
	private String positionName;
	
	@Column(name="start_year")
	private LocalDate startYear;
	
	
	@Column(name="resignation_time",nullable = true)
	private LocalDate resignationTime;
	
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	

	
	
	
	
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
