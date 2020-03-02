//package com.so_mini.service;
//
//import com.so_mini.repository.BoardRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
////서비스로 이용 할 컴포넌트 정의
//@Service
//public class BoardService {
//    private final BoardRepository boardRepository;
//
//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
//
//    //pageable로 넘어온 page 객체가 0 이하일때 0으로 초기화
//    public Page<Board> findBoardList(Pageable pageable){
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0: pageable.getPageNumber() -1, pageable.getPageSize());
//        return boardRepository.findAll(pageable);
//    }
//    //idx 사용해 board 객체 반환
//    public Board findBoardByIdx(Long idx){
//        return boardRepository.findById(idx).orElse(new Board());
//    }
//}
