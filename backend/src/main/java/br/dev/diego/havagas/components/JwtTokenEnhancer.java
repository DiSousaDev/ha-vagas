package br.dev.diego.havagas.components;

import br.dev.diego.havagas.entities.User;
import br.dev.diego.havagas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

  @Autowired
  private UserRepository userRepository;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
    Optional<User> user = userRepository.findByEmail(oAuth2Authentication.getName());

    if(user.isPresent()) {
      Map<String, Object> map = new HashMap<>();
      map.put("userId", user.get().getId());
      map.put("userFirstName", user.get().getFirstName());
      map.put("userLastName", user.get().getLastName());
      DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;
      token.setAdditionalInformation(map);
    }
    return oAuth2AccessToken;
  }
}
