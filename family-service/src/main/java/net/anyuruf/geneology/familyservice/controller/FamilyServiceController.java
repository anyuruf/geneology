package net.anyuruf.geneology.familyservice.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.anyuruf.geneology.familyservice.domain.MemberBasic;
import net.anyuruf.geneology.familyservice.repository.MemberBasicRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FamilyServiceController {

	private MemberBasicRepository memberRepository;

	public FamilyServiceController(MemberBasicRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@PostMapping("/members")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<MemberBasic> addMember(@RequestBody MemberBasic member) {
		return memberRepository.save(member);
	}

	@GetMapping("/members")
	public Flux<MemberBasic> getMembers() {
		return memberRepository.findAll();
	}

	@DeleteMapping("/members/{id}")
	public Mono<ResponseEntity<Void>> deleteMember(@PathVariable("id") UUID id) {
		return memberRepository.findById(id).flatMap(
				member -> memberRepository.delete(member).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
