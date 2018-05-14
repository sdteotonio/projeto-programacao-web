package com.ufab.servico.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufab.dao.IUsuarioDAO;
import com.ufab.entidade.Usuario;

@Service
public class AppUserDetailsService implements UserDetailsService {

	protected final Logger LOGGER = Logger.getLogger(UserDetailsService.class);

	@Autowired
	IUsuarioDAO userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Usuario user = userDao.recuperarPorCpf(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new UserDetails() {

			private static final long serialVersionUID = 2059202961588104658L;

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public String getPassword() {
				return user.getSenha();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
				auths.add(new SimpleGrantedAuthority(user.getPerfil().getTipoPerfil().toString()));
				return auths;
			}
		};
	}

}