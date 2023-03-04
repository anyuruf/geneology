package net.anyuruf.geneology.familyservice.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import net.anyuruf.geneology.familyservice.domain.Link;

public interface LinkRepository extends ReactiveCrudRepository<Link, UUID> {
}