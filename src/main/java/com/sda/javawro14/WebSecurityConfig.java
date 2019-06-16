package com.sda.javawro14;

import com.sda.javawro14.user.model.User;
import com.sda.javawro14.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/").permitAll()

                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .permitAll()

                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<com.sda.javawro14.user.model.User> allUsers = userService.getAllUsers();
        Optional<User> admin = allUsers.stream()
                .filter(user -> user.getName().equals("admin"))
                .findAny();
        if (!admin.isPresent()) {
            User user =
                    new User("admin", new Date());
            userService.saveUser(user);
        }
        UserDetails[] users = allUsers.stream()
                .map(this::createUser)
                .toArray(UserDetails[]::new);
        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails createUser(User userDocument) {
        if (userDocument.getName().equals("admin")) {
            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                    .username(userDocument.getName())
                    .password(userDocument.getName())
                    .roles("USER", "ADMIN")
                    .build();
        } else {
            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                    .username(userDocument.getName())
                    .password(userDocument.getName())
                    .roles("USER")
                    .build();
        }
    }
}