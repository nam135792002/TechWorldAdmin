package r2s.com.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import r2s.com.models.AdminEntity;


public class UserDetailsDTO implements UserDetails {
	private AdminEntity adminEntity;
	
        public UserDetailsDTO(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) adminEntity.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getRoleName().toString()))
				.collect(Collectors.toList());
	}

	public AdminEntity getUserDetails() {
		return adminEntity;
	}
	
	@Override
	public String getPassword() {		
		return adminEntity.getPassword();
	}

	@Override
	public String getUsername() {		
		return adminEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
