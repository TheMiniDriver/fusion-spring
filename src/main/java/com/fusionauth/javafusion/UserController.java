package com.fusionauth.javafusion;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.StringUtils;

@Controller
public class UserController {

  private final OAuth2AuthorizedClientService authorizedClientService;

  public UserController(OAuth2AuthorizedClientService authorizedClientService) {
    this.authorizedClientService = authorizedClientService;
  }

  @RequestMapping("/user")
  public String userPage(Model model, @AuthenticationPrincipal OidcUser principal) {
    model.addAttribute("name", "SUPER USER");
    if (principal != null) {
      model.addAttribute("profile", principal.getClaims());
    }
    //return "index";
    return "user";
  }

  // @RequestMapping("/userinfo")
  // public String userinfo(Model model, OAuth2AuthenticationToken authentication)
  // {
  // OAuth2AuthorizedClient authorizedClient =
  // this.getAuthorizedClient(authentication);
  // Map userAttributes = Collections.emptyMap();
  // String userInfoEndpointUri = authorizedClient.getClientRegistration()
  // .getProviderDetails().getUserInfoEndpoint().getUri();
  // if (!StringUtils.isEmpty(userInfoEndpointUri)) { // userInfoEndpointUri is
  // optional for OIDC Clients
  // userAttributes = WebClient.builder()
  // .filter(oauth2Credentials(authorizedClient)).build()
  // .get().uri(userInfoEndpointUri)
  // .retrieve()
  // .bodyToMono(Map.class).block();
  // }
  // model.addAttribute("userAttributes", userAttributes);
  // return "userinfo";
  // }

  // private OAuth2AuthorizedClient getAuthorizedClient(OAuth2AuthenticationToken
  // authentication) {
  // return this.authorizedClientService.loadAuthorizedClient(
  // authentication.getAuthorizedClientRegistrationId(),
  // authentication.getName());
  // }

  // private ExchangeFilterFunction oauth2Credentials(OAuth2AuthorizedClient
  // authorizedClient) {
  // return ExchangeFilterFunction.ofRequestProcessor(
  // clientRequest -> {
  // ClientRequest authorizedRequest = ClientRequest.from(clientRequest)
  // .header(HttpHeaders.AUTHORIZATION,
  // "Bearer " + authorizedClient.getAccessToken().getTokenValue())
  // .build();
  // return Mono.just(authorizedRequest);
  // });
  // }

}
