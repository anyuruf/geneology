package net.anyuruf.geneology.memberbasic.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.anyuruf.geneology.memberbasic.entity.GenderEnum.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberBasicInput {
	private UUID id;
	@Nonnull
	private String firstName;
	@Nonnull
	private String lastName;
	private String description;
	@Nonnull
	private Gender gender;
	private LocalDate dob;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getDescription() {
		return description;
	}

	public UUID getId() {
		return id;
	}

}
