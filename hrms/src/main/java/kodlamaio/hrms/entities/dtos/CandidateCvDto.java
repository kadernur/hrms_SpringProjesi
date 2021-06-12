package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Skill;

public class CandidateCvDto {
	
public Candidate candidate;
	
	public List<School> schools;
	
	public List<Skill> skills;
	
	public List<Link> links;
	
	public List<Language> languages;
	
	public List<JobExperience> jobExperiences;
	
	public List<CoverLetter> coverLetters;
	
	public Image image;


}
