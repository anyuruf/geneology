package net.anyuruf.geneology.memberbasic.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import net.anyuruf.geneology.memberbasic.entity.Link;
import net.anyuruf.geneology.memberbasic.entity.MemberBasic;
import net.anyuruf.geneology.memberbasic.entity.MemberBasicInput;
import net.anyuruf.geneology.memberbasic.repository.LinkRepository;
import net.anyuruf.geneology.memberbasic.repository.MemberBasicRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MemberBasicController {

	private final MemberBasicRepository memberRepository;
	private final LinkRepository linkRepository;

	public MemberBasicController(MemberBasicRepository memRepo, LinkRepository linkRepo) {
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

		MemberBasic memberBasic = new MemberBasic(memberBasicInput.getFirstName(), memberBasicInput.getLastName(),
				memberBasicInput.getDescription(), memberBasicInput.getGender(), memberBasicInput.getDob());
		return this.memberRepository.save(memberBasic);
	}

	@MutationMapping
	public Mono<MemberBasic> editMember(@Argument MemberBasicInput memberBasicInput) {
		MemberBasic memberBasic = new MemberBasic(memberBasicInput.getId(), memberBasicInput.getFirstName(),
				memberBasicInput.getLastName(), memberBasicInput.getDescription(), memberBasicInput.getGender(),
				memberBasicInput.getDob());
		return this.memberRepository.save(memberBasic);
	}

}
