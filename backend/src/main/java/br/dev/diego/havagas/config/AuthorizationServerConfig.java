package br.dev.diego.havagas.config;

import br.dev.diego.havagas.components.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

import static br.dev.diego.havagas.utils.HaVagasConstants.PASSWORD;
import static br.dev.diego.havagas.utils.HaVagasConstants.READ;
import static br.dev.diego.havagas.utils.HaVagasConstants.WRITE;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Value("${security.oauth2.client.client-id}")
  private String clientId;

  @Value("${security.oauth2.client.client-secret}")
  private String clientSecret;

  @Value("${jwt.duration}")
  private Integer jwtDuration;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private JwtAccessTokenConverter accessTokenConverter;

  @Autowired
  private JwtTokenStore jwtTokenStore;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenEnhancer jwtTokenEnhancer;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
        .withClient(clientId)
        .secret(bCryptPasswordEncoder.encode(clientSecret))
        .scopes(READ, WRITE)
        .authorizedGrantTypes(PASSWORD)
        .accessTokenValiditySeconds(jwtDuration);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

    TokenEnhancerChain chain = new TokenEnhancerChain();
    chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, jwtTokenEnhancer));

    endpoints.authenticationManager(authenticationManager)
        .tokenStore(jwtTokenStore)
        .accessTokenConverter(accessTokenConverter)
        .tokenEnhancer(chain);
  }
}