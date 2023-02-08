package net.anyuruf.geneology.gatewayservice.WebClient;

import org.springframework.stereotype.Component;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import net.anyuruf.geneology.gatewayservice.entity.MemberBasic;
import reactor.core.publisher.Flux;

@HttpExchange(url = "", accept = "application/graphql+json", contentType = "application/json")
@Component
public interface XWebClient {
	// private final WebClient xClient;

	/*
	 * public XWebClient(WebClient xClient) { this.xClient = xClient; }
	 */

	@PostExchange
	public Flux<MemberBasic> getNodes();

	/*
	 * String query = """ { getNodes { id firstName lastName description gender dob
	 * """; return
	 * this.xClient.post().syncBody(query).retrieve().bodyToFlux(MemberBasic.class).
	 * subscribe();
	 * 
	 * }
	 */
}
