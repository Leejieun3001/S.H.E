//package com.so_mini.controller;
//
//import com.so_mini.domain.Board;
//import com.so_mini.repository.BoardRepository;
//import com.so_mini.service.BoardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.data.web.PagedResourcesAssembler;
//import org.springframework.hateoas.PagedModel;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.print.attribute.standard.Media;
//import java.awt.*;
//
//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;
//
//@Controller
//@RequestMapping("/api/boards") //API URL 경로지정 (/board)
//public class BoardController {
//
//    private BoardRepository boardRepository;
//
//    public BoardController(BoardRepository boardRepository){
//        this.boardRepository = boardRepository;
//
//    }
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getBoards(@PageableDefault Pageable pageable) {
//        Page<Board> boards = boardRepository.findAll(pageable);
//        PagedModel.PageMetadata pageMetadata =
//                new PagedModel.PageMetadata(pageable.getPageSize(), boards.getNumber(), boards.getTotalElements());
//        PagedModel<Board> resources = new PagedModel<Board>(boards.getContent(), pageMetadata);
//        resources.add(linkTo(methodOn(BoardController.class).getBoards(pageable)).withSelfRel());
//        return ResponseEntity.ok(resources);
//    }
//
//}
