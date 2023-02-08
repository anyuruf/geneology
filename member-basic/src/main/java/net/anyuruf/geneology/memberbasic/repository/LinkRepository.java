package net.anyuruf.geneology.memberbasic.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import net.anyuruf.geneology.memberbasic.entity.Link;

public interface LinkRepository extends ReactiveCrudRepository<Link, UUID> {
}