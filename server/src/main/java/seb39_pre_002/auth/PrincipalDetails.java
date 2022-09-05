package seb39_pre_002.auth;

import seb39_pre_002.member.entity.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
//UserDetails 와 OAuth2User 기능 동일 ... 여러개의 클래스를 상속 받기 불가능, 인터페이스는 다중구현 가능
    //서비스 두개를 뭉칠거야?

    private Member member;
    private Map<String, Object> attributes;

    //기존 폼롤러
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    //새로운애 오워스2
    public PrincipalDetails(Member member, Map<String, Object> attributes){
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        member.getRoleList().forEach(n -> {
            authorities.add(() -> n);
        });
        return authorities;
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collection = new ArrayList<>();
//        collection.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return member.getRole();
//            }
//        });
//        return collection;
//    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
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

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }
}
