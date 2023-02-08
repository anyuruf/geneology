package net.anyuruf.geneology.gatewayservice.entity;

import java.util.UUID;

import net.anyuruf.geneology.gatewayservice.entity.ParentEnum.Parent;

public record Link(UUID id, UUID source, UUID target, Parent parent) {
}