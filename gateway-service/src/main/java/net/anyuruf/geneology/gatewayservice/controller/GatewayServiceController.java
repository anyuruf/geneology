package net.anyuruf.geneology.gatewayservice.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import net.anyuruf.geneology.gatewayservice.WebClient.XWebClient;
import net.anyuruf.geneology.gatewayservice.entity.MemberBasic;
import reactor.core.publisher.Flux;

@Controller
public class GatewayServiceController {
	// Building a new Mocca client
	private XWebClient xClient;

	public GatewayServiceController(XWebClient xClient) {
		this.xClient = xClient;
	}
	// Getting a book by id

	@QueryMapping
	public Flux<MemberBasic> getNodes() {
		return this.xClient.getNodes();
	}

}
