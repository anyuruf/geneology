package net.anyuruf.geneology.familyservice.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import net.anyuruf.geneology.familyservice.domain.MemberBasic;

public interface MemberBasicRepository extends ReactiveCrudRepository<MemberBasic, UUID> {
}
