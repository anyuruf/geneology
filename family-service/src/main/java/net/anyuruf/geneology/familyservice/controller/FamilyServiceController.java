package net.anyuruf.geneology.familyservice.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import net.anyuruf.geneology.familyservice.domain.Link;
import net.anyuruf.geneology.familyservice.domain.MemberBasic;
import net.anyuruf.geneology.familyservice.domain.MemberBasicInput;
import net.anyuruf.geneology.familyservice.repository.LinkRepository;
import net.anyuruf.geneology.familyservice.repository.MemberBasicRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FamilyServiceController {

	private final MemberBasicRepository memberRepository;
	private final LinkRepository linkRepository;

	public FamilyServiceController(MemberBasicRepository memRepo, LinkRepository linkRepo) {
		this.memberRepository = memRepo;
		this.linkRepository = linkRepo;
	}

	@QueryMapping
	public Flux<MemberBasic> getNodes() {
		return this.memberRepository.findAll();
	}

	@QueryMapping
	public Flux<Link> links() {
		return this.linkRepository.findAll();
	}

	@MutationMapping
	public Mono<MemberBasic> addMember(@Argument MemberBasicInput memberBasicInput) {
		MemberBasic memberBasic = new MemberBasic(null, memberBasicInput.firstName(), memberBasicInput.lastName(),
				memberBasicInput.description(), memberBasicInput.gender(), memberBasicInput.dob());
		return this.memberRepository.save(memberBasic);

	}

	@MutationMapping
	public Mono<MemberBasic> editMember(@Argument MemberBasicInput memberBasicInput) {
		MemberBasic memberBasic = new MemberBasic(memberBasicInput.id(), memberBasicInput.firstName(),
				memberBasicInput.lastName(), memberBasicInput.description(), memberBasicInput.gender(),
				memberBasicInput.dob());
		return this.memberRepository.save(memberBasic);
	}

}
