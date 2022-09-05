package seb39_pre_002.member.mapper;

import seb39_pre_002.member.dto.MemberDto;
import seb39_pre_002.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post requestBody);
    Member memberPatchDtoToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponse(Member member); //Member를 MemberResponseDto로 변환
    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
