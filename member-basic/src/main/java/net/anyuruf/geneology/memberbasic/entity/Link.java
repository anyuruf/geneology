package net.anyuruf.geneology.memberbasic.entity;

import java.util.UUID;

import net.anyuruf.geneology.memberbasic.entity.ParentEnum.Parent;

public record Link(UUID id, UUID source, UUID target, Parent parent) {
}