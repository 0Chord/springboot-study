package hello.member;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Test
	@Transactional
	void memberTest() {
		Member member = new Member("idA", "memberA");
		memberRepository.initTable();
		memberRepository.save(member);
		Member findMember = memberRepository.find(member.getMemberId());
		assertThat(findMember.getName()).isEqualTo(member.getName());
		assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());

	}
}