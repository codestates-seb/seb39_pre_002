package seb39_pre_002.member.mapper;


import org.mapstruct.Mapper;
import seb39_pre_002.member.dto.MemberPatchDto;
import seb39_pre_002.member.dto.MemberPostDto;
import seb39_pre_002.member.dto.MemberResponseDto;
import seb39_pre_002.member.entity.Member;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members);
}
