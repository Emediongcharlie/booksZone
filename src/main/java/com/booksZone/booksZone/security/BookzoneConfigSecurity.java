package com.booksZone.booksZone.security;

import com.booksZone.booksZone.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
public class BookzoneConfigSecurity {


        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider(UserServiceImpl userService) {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userService);
            provider.setPasswordEncoder(passwordEncoder());
            return provider;
        }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(configurer -> configurer
                    .requestMatchers(HttpMethod.POST, "/book/register/seller/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/book/login/seller/").permitAll()
                    .requestMatchers(HttpMethod.POST, "/book/register/customer/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/book/login/customer/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/product/search-product/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/product/get-all-products/").permitAll()

                    .requestMatchers(HttpMethod.GET, "/book/get-all-sellers").hasAnyRole("SELLER", "ADMIN")
                    .requestMatchers(HttpMethod.GET, "/book/search/seller/").hasAnyRole("SELLER", "ADMIN")
                    .requestMatchers(HttpMethod.POST, "/product/add-new-product/").hasAnyRole("SELLER", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/product/delete-product/{id}").hasAnyRole("SELLER", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/product/edit-product/").hasAnyRole("SELLER", "ADMIN")

                    .requestMatchers(HttpMethod.GET, "/book/get-all-customers").hasRole("ADMIN")

                    .anyRequest().authenticated()
            );

            http.httpBasic(Customizer.withDefaults());
            http.csrf(csrf -> csrf.disable());

            return http.build();
        }
    }