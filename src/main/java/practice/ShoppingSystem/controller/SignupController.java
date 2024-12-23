package practice.ShoppingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.ShoppingSystem.constant.ErrorMessageConst;
import practice.ShoppingSystem.form.LoginForm;
import practice.ShoppingSystem.form.SignupForm;
import practice.ShoppingSystem.service.LoginService;
import practice.ShoppingSystem.service.SignupService;
import practice.ShoppingSystem.util.AppUtil;

/**
 * ユーザー登録画面 Controller
 * @author shoujiyuuki
 */

@Controller
@RequiredArgsConstructor
public class SignupController {

  /**ユーザー登録画面 Service*/
  private final SignupService service;

  /**
   * 初期表示
   * @param model モデル
   * @param form 入力情報
   * @return 表示画面
   */

  @GetMapping("/signup")
  public String view(Model model, SignupForm form){
    return "signup";
  }

  /**
   * ユーザー登録
   * @param model モデル
   * @param form 入力情報
   * @return 表示画面
   */

  @PostMapping("/signup")
  public void signup(Model model, SignupForm form){
    service.resistUserInfo(form);

  }
}
