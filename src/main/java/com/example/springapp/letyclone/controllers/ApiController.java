package com.example.springapp.letyclone.controllers;

import com.example.springapp.bse.services.CashbackService;
import com.example.springapp.bse.services.ShopService;
import com.example.springapp.bse.services.UserService;
import com.example.springapp.letyclone.messages.*;
import com.example.springapp.letyclone.repository.ItemRepository;
import com.example.springapp.letyclone.repository.ShopRepository;
import com.example.springapp.letyclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("studs");
//    @PersistenceContext
//    EntityManager em;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserService userService;
    @Autowired
    ShopService shopService;

    @Autowired
    CashbackService cashbackService;

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetAccountInfoResponse getAccountInfo(@RequestParam(required = false) Integer userId) {
        try {
            return GetAccountInfoResponse.ok(userService.getAccountInfo(userId));
        } catch (RuntimeException ex) {
            return GetAccountInfoResponse.error(ex.getLocalizedMessage());
        }
    }

    @GetMapping(value = "shops", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetShopsResponse getShops() {
        return GetShopsResponse.ok(shopService.getShops());
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody LoginRequest req) {
        try {
            return LoginResponse.ok(userService.login(req.username, req.password));
        } catch (RuntimeException ex) {
            return LoginResponse.error(ex.getLocalizedMessage());
        }
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterResponse register(@RequestBody RegisterRequest req) {
        try {
            return RegisterResponse.ok(userService.register(req.username, req.password));
        } catch (RuntimeException ex) {
            return RegisterResponse.error(ex.getLocalizedMessage());
        }
    }

    @PostMapping(value = "private/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserResponse withdraw(@RequestBody GetUserRequest req) {
        try {
            cashbackService.withdraw(req.userId);
            return GetUserResponse.ok();
        } catch (RuntimeException ex) {
            return GetUserResponse.error(ex.getLocalizedMessage());
        }
    }

    /*
    @GetMapping("user_list")
    public UserListResponse userList() {
        List<User> users = userRepository.findAll();
        return new UserListResponse(users.stream().map(User::getUsername).collect(Collectors.toList()));
    }
    */
}
