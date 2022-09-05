package seb39_pre_002.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.auth.PrincipalDetails;

import seb39_pre_002.member.entity.Member;
import seb39_pre_002.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RestController
@RequiredArgsConstructor // 추가
public class MemberController {


    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }


    @PostMapping("/join")
    public String join(@RequestBody Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRole("ROLE_USER");
        memberRepository.save(member);
        return "회원 가입 완료";
    }

    // 추가
    @GetMapping("/api/v1/user")
    public String user() {
        return "user";
    }
    // 추가
    @GetMapping("/api/v1/admin")
    public String admin() {
        return "admin";
    }
}


//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Controller
//public class MemberController {
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    MemberRepository memberRepository;
//
//    @GetMapping("/")
//
//    public String index(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
//
//        try {
//            if(principalDetails.getUsername() != null) {
//                model.addAttribute("username", principalDetails.getUsername());
//            }
//        } catch (NullPointerException e) {}
//        return "index";
//    }
//
//    @GetMapping("/user")
//    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//        System.out.println(principalDetails.getMember());
//
//        return "user";
//    }
//
//    @GetMapping("/admin")
//    public @ResponseBody String admin() {
//        return "admin";
//    }
//
//    @GetMapping("/manager")
//    public @ResponseBody String manager() {
//        return "manager";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "loginForm";
//    }
//
//    @GetMapping("/join")
//    public String join() {
//        return "joinForm";
//    }
//
////    @PostMapping("/join")
////    public String join(Member member) {
////        member.setRole("ROLE_USER");
////        String rawPassword = member.getPassword();
////        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
////        member.setPassword(encPassword);
////
////        memberRepository.save(member);
////
////        return "redirect:/login";
////    }
//
//    @Secured("ROLE_ADMIN")
//    @GetMapping("/info")
//    public @ResponseBody String info() {
//        return "info";
//    }
//
//    @GetMapping("/loginTest")
//    public @ResponseBody String loginTest(Authentication authentication) {
//        System.out.println("==================/loginTest=============");
//        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//        System.out.println("authentication : " + principalDetails.getMember());
//        return "세션 정보 확인"; //영어로 쓰는게 좋음
//    }
//
//    @GetMapping("/loginTest2")
//    public @ResponseBody String loginTest2(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//        System.out.println("============/loginTest2===========");
//        System.out.println("userDetails : " + principalDetails.getMember());
//        return "세션 정보 확인2";
//    }
//
//    @GetMapping("/loginTest3")
//    public @ResponseBody String loginOAuthTest(
//            Authentication authentication,
//            @AuthenticationPrincipal OAuth2User oauth) {
//        System.out.println("============/loginOAuthTest===========");
//        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
//        System.out.println("authenticaion : " + oauth2User.getAttributes());
//        System.out.println("oauth2User : " + oauth.getAttributes());
//        return "세션 정보 확인3";
//    }
//
//    // 추가
//
//    @PostMapping("/join")
//    public String join(@RequestBody Member member) {
//        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
//        member.setRole("ROLE_USER");
//        memberRepository.save(member);
//        return "회원 가입 완료";
//    }
//
//
//    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//    @GetMapping("/data")
//    public @ResponseBody String data() {
//        return "data";
//    }
//}