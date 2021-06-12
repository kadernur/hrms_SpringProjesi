package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")

public class Candidate extends User {
	
	@NotNull
	@NotBlank(message = "Missing information...")
	@Column(name="first_name")
	private String firstName;
	
	
	@NotNull
	@NotBlank(message = "Missing information...")
	@Column(name="last_name")
	private String lastName;
	

	@NotBlank
	@NotNull
	@Column(name="identification_number")
	private String identificationNumber;
	

	@NotBlank
	@NotNull
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	
	
	
	@Column(name="is_email_verified_by_email")
	@Nullable
	private Boolean isEmailVerified;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isDeleted=false;

	
	
	//ilişkiler
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<School> schools;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Language> languages;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Link> links;
	
	
	
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate",optional=false, fetch=FetchType.LAZY)
	private Image image;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="candidate")
	private List<CoverLetter> coverLetters;
	
	
	
	
	
	
}
