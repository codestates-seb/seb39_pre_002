package seb39_pre_002.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seb39_pre_002.member.entity.Member;

import java.util.Optional;

//데이터베이스 연동
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
