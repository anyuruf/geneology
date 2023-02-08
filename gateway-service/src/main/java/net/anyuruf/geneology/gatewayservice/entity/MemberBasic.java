package net.anyuruf.geneology.gatewayservice.entity;

import java.time.LocalDate;
import java.util.UUID;

import net.anyuruf.geneology.gatewayservice.entity.GenderEnum.Gender;

public class MemberBasic {

	private UUID id;
	private String firstName;
	private String lastName;
	private String description;
	private Gender gender;
	private LocalDate dob;

	public MemberBasic() {
	}

	public MemberBasic(String firstName, String last, String desc, Gender gen, LocalDate dob) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = last;
		this.description = desc;
		this.gender = gen;
		this.dob = dob;
	}

	public MemberBasic(UUID id, String first, String last, String desc, Gender gen, LocalDate dob) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.firstName = first;
		this.lastName = last;
		this.description = desc;
		this.gender = gen;
		this.dob = dob;
	}

}
