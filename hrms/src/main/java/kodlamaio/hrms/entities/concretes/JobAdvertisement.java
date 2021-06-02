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
@Table(name="job_advertisements")

public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	
	@Column(name="appeal_deadline")
	private LocalDate appealDeadLine;
	
	
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate;
	
	
	@Column(name="is_active",columnDefinition = "boolean default true")
	@JsonIgnore
	private Boolean isActive=true;
	
	
	
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;
	
	
	@Column(name="is_opened",columnDefinition = "boolean default true")
	private Boolean isOpened=true;
	
	
	
	//ilişkisel özellikler
	//birden cok ilan bir sehirde olabilir

    @ManyToOne()
    @JoinColumn(name="city_id")
	private City city;
	
	
    @ManyToOne()
    @JoinColumn(name="employer_id") 
    private Employer employer;
    
    
    
    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
