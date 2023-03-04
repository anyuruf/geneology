package net.anyuruf.geneology.familyservice.domain;

import java.util.UUID;

import net.anyuruf.geneology.familyservice.domain.ParentEnum.Parent;

public record Link(UUID id, UUID source, UUID target, Parent parent) {
}