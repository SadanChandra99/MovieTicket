package com.customer.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.customer.security.CustomerLoginDetails;
import com.customer.security.CustomerLoginDetailsService;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtills jwtUtills;
	
	@Autowired
	private CustomerLoginDetailsService customerLoginDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String auth = request.getHeader("Authorization");
		String token = null;
		String username = null;
		if(auth != null && auth.startsWith("Bearer")) {
			token = auth.substring(6);
			username = jwtUtills.getUsernameFromToken(token);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			CustomerLoginDetails currentcustomer = (CustomerLoginDetails) customerLoginDetailsService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken userauthToken = new UsernamePasswordAuthenticationToken(currentcustomer, null , currentcustomer.getAuthorities());
			userauthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(userauthToken);
		}
		
		filterChain.doFilter(request, response);
		
		
	}

}
