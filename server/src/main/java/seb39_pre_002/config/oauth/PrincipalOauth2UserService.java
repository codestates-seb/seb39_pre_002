package seb39_pre_002.config.oauth;

import seb39_pre_002.auth.PrincipalDetails;
import seb39_pre_002.member.entity.Member;
import seb39_pre_002.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
//우리가 만든거 커스텀마이징 되어있겠구나
    //DefaultOAuth2UserService을 상속받아야 기능 수행
    @Autowired
    private MemberRepository memberRepository;
    //우리가 만든거

    @Override//OAuth2UserRequest 들어가서 봐보기
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        System.out.println("userRequest : " + userRequest);
//        return super.loadUser(userRequest);

        OAuth2User oauth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oauth2User.getAttribute("sub"); //미리 설정되어 있음
        String username = oauth2User.getAttribute("name");
        String email = oauth2User.getAttribute("email");
        String role = "ROSE_USER";

        Member memberEntity = memberRepository.findByUsername(username);

        if(memberEntity == null) {
            // OAuth로 처음 로그인한 유저 - 회원가입 처리
            memberEntity = Member.builder()
                    .username(username)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            memberRepository.save(memberEntity);
        }

        return new PrincipalDetails(memberEntity, oauth2User.getAttributes());
    }
}
