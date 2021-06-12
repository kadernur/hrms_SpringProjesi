package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")


public class Employer extends User {
	
	@NotBlank
	@NotNull
	@Column(name="web_site")
	private String webSite;
	
	@NotBlank
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@NotBlank
	@NotNull
	@Column(name="is_email_verified",columnDefinition = "boolean default false")
	private Boolean isEmailVerified;
	
	@Column(name="is_verified_by_employee",columnDefinition = "boolean default false" )
	private Boolean isVerifiedByEmployee;
	
	
	@NotBlank
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	
	
	 @OneToMany(mappedBy="employer")
     private List<JobAdvertisement> jobAdvertisements;

}
