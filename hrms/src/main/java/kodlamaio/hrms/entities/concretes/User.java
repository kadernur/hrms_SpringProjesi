package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)  // miras verdiği sınıfa ozelliklerini aktarır?

public class User {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //bunu vermeyince, hep api hem de pg adminden değişiklik yapmamıza izin veriyor. bunu koymadığımıza id'ler çakışıyor. ya veritabanı üzerinden ya da api üzerinden ekleme yapabiliyoruz.
	@Column(name="id")
	private int id;

	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	@JsonIgnore
	private String password;
	
	
	@Column(name="is_active",columnDefinition = "boolean default true") // default'u true der
	private Boolean isActive=true;
	
	
	@JsonIgnore
	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();
	
	
	@JsonIgnore
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted= false;

}
