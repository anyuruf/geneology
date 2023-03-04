package net.anyuruf.geneology.familyservice;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import net.anyuruf.geneology.familyservice.domain.GenderEnum.Gender;
import net.anyuruf.geneology.familyservice.domain.MemberBasic;
import net.anyuruf.geneology.familyservice.repository.MemberBasicRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
		"spring.cloud.discovery.enabled = false" })
@ActiveProfiles("test")
class FamilyServiceApplicationTests {

	@Autowired
	MemberBasicRepository memberRepository;

	@Autowired
	WebTestClient webTestClient;

	/*
	 * @Test public void testAddCar() { MemberBasic danny = new MemberBasic(null,
	 * "Daniel", "Omodo", "Artist n Musician", Gender.MALE, LocalDate.of(2012,
	 * Month.DECEMBER, 24));
	 * 
	 * webTestClient.post().uri("/members").contentType(MediaType.APPLICATION_JSON).
	 * accept(MediaType.APPLICATION_JSON) .body(Mono.just(danny),
	 * MemberBasic.class).exchange().expectStatus().isCreated().expectHeader()
	 * .contentType(MediaType.APPLICATION_JSON).expectBody().jsonPath("$.id").
	 * isNotEmpty() .jsonPath("$.firstName").isEqualTo("Daniel"); }
	 */

	@Test
	public void testGetAllCars() {
		webTestClient.get().uri("/members").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(MemberBasic.class);
	}

	@Test
	public void testAddDeleteMember() {
		MemberBasic atim = memberRepository.save(new MemberBasic(null, "Elijah", "Atim", "Artist n Musician",
				Gender.MALE, LocalDate.of(2012, Month.DECEMBER, 24))).block();

		webTestClient.delete().uri("/members/{id}", Collections.singletonMap("id", atim.id())).exchange().expectStatus()
				.isOk();

	}

}
