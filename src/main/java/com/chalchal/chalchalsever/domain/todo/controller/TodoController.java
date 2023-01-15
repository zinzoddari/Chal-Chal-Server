package com.chalchal.chalchalsever.domain.todo.controller;

import com.chalchal.chalchalsever.domain.auth.entity.User;
import com.chalchal.chalchalsever.domain.todo.dto.TodoListSaveRequest;
import com.chalchal.chalchalsever.domain.todo.dto.TodoListUpdateRequest;
import com.chalchal.chalchalsever.domain.todo.service.TodoService;
import com.chalchal.chalchalsever.global.dto.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/todo")
@Api(tags = {"TODO"})
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /**
     * 할 일 조회
     */
    @GetMapping(value = "/")
    @ApiOperation(value = "TODO 조회")
    public ResponseEntity selectAll(@AuthenticationPrincipal User user) {
        return ResultResponse.ok(ResultResponse.builder()
                    .data(todoService.findTodoListByRegId(user.getId()))
                .build());
    }

    /**
     * 할 일 등록하는 메소드
     */
    @PostMapping(value = "/")
    @ApiOperation(value = "TODO 작성")
    public ResponseEntity save(@RequestBody TodoListSaveRequest todoListSaveRequest) {
        return ResultResponse.ok(ResultResponse.builder()
                    .message("등록 되었습니다.")
                    .data(todoService.createTodoList(todoListSaveRequest))
                .build());
    }

    /**
     * 할 일 수정하는 메소드
     */
    @PatchMapping(value = "/{svcNo}")
    @ApiOperation(value = "TODO 수정")
    public ResponseEntity<ResultResponse<Void>> update(@RequestBody TodoListUpdateRequest todoListUpdateRequest) {
        todoService.updateTodoList(todoListUpdateRequest);
        return ResultResponse.ok();
    }

    /**
     * 할 일 삭제하는 메소드
     */
    @DeleteMapping(value = "/{svcNo}")
    @ApiOperation(value = "TODO 삭제")
    public ResponseEntity delete(@PathVariable String svcNo) {
        return ResultResponse.ok(ResultResponse.builder()
                    .data(todoService.deleteTodoList(svcNo))
                    .message("삭제 되었습니다.")
                .build());
    }
}
