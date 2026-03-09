package com.example.restapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.restapi.domain.User;
import com.example.restapi.exception.UserNotFoundException;

/**
 * ユーザー情報を管理するサービスクラス
 */
@Service
public class UserService {

    // メモリ内でユーザーデータを管理（IDをキーとしたMap）
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    // IDの自動採番用
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserService() {
        // 初期データを作成
        initializeUsers();
    }

    /**
     * 初期ユーザーデータを作成
     */
    private void initializeUsers() {
        User user1 = new User("田中太郎", "tanaka@example.com");
        user1.setId(nextId.getAndIncrement());
        users.put(user1.getId(), user1);
        
        User user2 = new User("佐藤花子", "sato@example.com");
        user2.setId(nextId.getAndIncrement());
        users.put(user2.getId(), user2);
        
        User user3 = new User("鈴木一郎", "suzuki@example.com");
        user3.setId(nextId.getAndIncrement());
        users.put(user3.getId(), user3);
    }

    /**
     * IDでユーザーを検索
     * 
     * @param id 検索対象のユーザーID
     * @return 指定されたIDのユーザー情報
     * @throws UserNotFoundException 指定されたIDのユーザーが見つからない場合
     */
    public User findById(Integer id) {
        User user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException("ユーザーID " + id + " が見つかりません");
        }
        return user;
    }

    /**
     * ユーザーを作成
     * 
     * @param user 作成するユーザー情報（IDは自動採番される）
     * @return 作成されたユーザー情報（IDが設定済み）
     */
    public User createUser(User user) {
        user.setId(nextId.getAndIncrement());
        user.setCreatedAt(LocalDateTime.now());
        users.put(user.getId(), user);
        return user;
    }

    /**
     * ユーザーを更新
     * 
     * @param id   更新対象のユーザーID
     * @param user 更新するユーザー情報
     * @return 更新されたユーザー情報
     * @throws UserNotFoundException 指定されたIDのユーザーが見つからない場合
     */
    public User updateUser(Integer id, User user) {
        User existingUser = users.get(id);
        if (existingUser == null) {
            throw new UserNotFoundException("ユーザーID " + id + " が見つかりません");
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUpdatedAt(LocalDateTime.now());

        return existingUser;
    }

    /**
     * 条件に一致するユーザーを検索
     * 
     * @param user 検索条件となるユーザー情報（nullのフィールドは検索条件から除外）
     * @return 検索条件に一致するユーザー一覧
     */
    public List<User> searchUsers(User user) {
        return users.values().stream()
                .filter(u -> (user.getName() == null || u.getName().contains(user.getName())))
                .filter(u -> (user.getEmail() == null || u.getEmail().contains(user.getEmail())))
                .collect(Collectors.toList());
    }

    /**
     * ユーザーを削除
     *
     * @param id 削除対象のユーザーID
     * @throws UserNotFoundException 指定されたIDのユーザーが見つからない場合
     */
    public void deleteUser(Integer id) {
        User existingUser = users.get(id);
        if (existingUser == null) {
            throw new UserNotFoundException("ユーザーID " + id + " が見つかりません");
        }
        users.remove(id);
    }
}
