package seb39_pre_002.auth;

import seb39_pre_002.member.entity.Member;
import seb39_pre_002.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Member memberEntity = memberRepository.findByUsername(username);
//        System.out.println("username : " + username);
//        if(memberEntity != null) {
//            return new PrincipalDetails(memberEntity);
//        }
//        return null;
//    }
//}
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Member memberEntity = memberRepository.findByUsername(username);
    return new PrincipalDetails(memberEntity);
}
}