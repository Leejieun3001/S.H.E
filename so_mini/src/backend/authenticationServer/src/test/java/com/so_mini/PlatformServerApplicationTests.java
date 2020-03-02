package com.so_mini;

import com.so_mini.domain.Board;
import com.so_mini.domain.User;
import com.so_mini.domain.enums.BoardType;
import com.so_mini.repository.BoardRepository;
import com.so_mini.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class PlatformServerApplicationTests {
	private final String boardTestTitle = "테스트";
	private final String email = "test@gmail.com";

	@Autowired
	UserRepository userRepository;

	@Autowired
	BoardRepository boardRepository;

	@Before
	public void init() {
		User user = userRepository.save(User.builder()
				.name("havi")
				.password("test")
				.email(email)
				.createdDate(LocalDateTime.now())
				.build());

		boardRepository.save(Board.builder()
				.title(boardTestTitle)
				.subTitle("서브 타이틀")
				.content("컨텐츠")
				.boardType(BoardType.free)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.user(user).build());
	}

	@Test
	void contextLoads() {
		User user = userRepository.findByEmail(email);
		assertThat(user.getName(), is("havi"));
		assertThat(user.getPassword(), is("test"));
		assertThat(user.getEmail(), is(email));

		Board board = boardRepository.findByUser(user);
		assertThat(board.getTitle(), is(boardTestTitle));
		assertThat(board.getSubTitle(), is("서브 타이틀"));
		assertThat(board.getContent(), is("컨텐츠"));
		assertThat(board.getBoardType(), is(BoardType.free));
	}

}
