package seb39_pre_002.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seb39_pre_002.member.mapper.MemberMapper;
import seb39_pre_002.member.dto.MemberPatchDto;
import seb39_pre_002.member.dto.MemberPostDto;
import seb39_pre_002.member.service.MemberService;
import seb39_pre_002.member.entity.Member;
import seb39_pre_002.dto.MultiResponseDto;
import seb39_pre_002.dto.SingleResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

//예외 안 넣음
//데이터베이스 연결해야됨 서비스에 더비 데이터 삭제
@RestController
@RequestMapping("/v1/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;

    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }


    @PostMapping //제이슨 바디로 등록
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {

        Member member = memberMapper.memberPostDtoToMember(memberDto);

        Member createMember = memberService.createMember(member);

        return new ResponseEntity<>(new SingleResponseDto<>(memberMapper.memberToMemberResponseDto(createMember)), HttpStatus.CREATED);
    }


    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member member = memberService.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(new SingleResponseDto<>(memberMapper.memberToMemberResponseDto(member)),
                HttpStatus.OK);

    }


    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        return new ResponseEntity<>(new SingleResponseDto<>(memberMapper.memberToMemberResponseDto(member)), HttpStatus.OK);
    }


    @GetMapping //확인 필요 //팜스 page , size 입력
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(memberMapper.membersToMemberResponseDtos(members),
                        pageMembers),
                HttpStatus.OK);
    }

//    @GetMapping 리스트만..
//    public ResponseEntity getMembers() {
//        List<Member> members = memberService.findMembers();
//        return new ResponseEntity(
//                new SingleResponseDto<>(memberMapper.membersToMemberResponseDtos(members)), HttpStatus.OK);
//   }


    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# delete member");
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
