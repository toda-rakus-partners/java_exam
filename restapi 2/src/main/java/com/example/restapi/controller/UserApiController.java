package com.example.restapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.domain.User;
import com.example.restapi.dto.UserRequest;
import com.example.restapi.dto.UserResponse;
import com.example.restapi.service.UserService;

import jakarta.validation.Valid;

/**
 * ユーザー情報を管理するREST APIコントローラー
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET,
    RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    // パスパラメータを使ったGETメソッド（GET /users/{id}）
    // 引数や戻り値は適宜修正してください
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        UserResponse response = new UserResponse(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(response);
    }

    // クエリパラメータを使ったGETメソッド（GET /users/search）
    // 引数や戻り値は適宜修正してください
    @GetMapping("/search")
    public ResponseEntity<List<UserResponse>> searchUsers(@Validated @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        if ((name == null || name.isEmpty()) && (email == null || email.isEmpty())) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        List<User> users = userService.searchUsers(user);

        List<UserResponse> responseList = users.stream().map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail())).collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    // POSTメソッドによるユーザー作成（POST /users）
    // 引数や戻り値は適宜修正してください
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Validated @RequestBody UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        if ((user.getName() == null || user.getName().isEmpty()) && (user.getEmail() == null || user.getEmail().isEmpty())) {
            return ResponseEntity.badRequest().build();
        }

        User createdUser = userService.createUser(user);

        UserResponse response = new UserResponse(createdUser.getId(), createdUser.getName(), createdUser.getEmail());
        return ResponseEntity.status(201).body(response);
    }

    // PUTメソッドによるユーザー更新（PUT /users/{id}）
    // 引数や戻り値は適宜修正してください
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @Validated @RequestBody UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        if ((user.getName() == null || user.getName().isEmpty()) && (user.getEmail() == null || user.getEmail().isEmpty())) {
            return ResponseEntity.badRequest().build();
        }

        User updatedUser = userService.updateUser(id, user);

        UserResponse response = new UserResponse(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());

        return ResponseEntity.ok(response);
    }

}
