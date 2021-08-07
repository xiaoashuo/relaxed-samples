// package com.relaxed.samples.tenant.controller;
//
// import com.relaxed.common.model.result.R;
//
// import com.relaxed.samples.tenant.holder.TenantHolder;
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.*;
//
// import java.util.List;
//
/// **
// * @author Yakir
// * @Topic UserController
// * @Description
// * @date 2021/7/25 17:11
// * @Version 1.0
// */
//
// @RequiredArgsConstructor
// @RestController
// @RequestMapping("/user")
// public class UserController {
//
// private final UserMapper userMapper;
//
// @GetMapping("/list")
// public R list(@RequestParam Integer pid) {
//
// List<User> data;
// try {
// TenantHolder.set(pid.equals(1) ? "1" : "2");
// data = userMapper.listUser();
// }
// finally {
// TenantHolder.remove();
// }
// return R.ok(data);
// }
//
// @PostMapping()
// public R insert(@RequestBody User user) {
// try {
// TenantHolder.set(user.getId() > 1 ? "1" : "2");
// userMapper.insert(user);
// }
// finally {
// TenantHolder.remove();
// }
// return R.ok();
// }
//
// }
