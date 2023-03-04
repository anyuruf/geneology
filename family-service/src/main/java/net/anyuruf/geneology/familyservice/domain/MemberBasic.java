package net.anyuruf.geneology.familyservice.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import net.anyuruf.geneology.familyservice.domain.GenderEnum.Gender;

public record MemberBasic(@Id UUID id, String firstName, String lastName, String description, Gender gender,
		LocalDate dob) {
}
