package practice.ShoppingSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.ShoppingSystem.constant.ErrorMessageConst;
import practice.ShoppingSystem.form.LoginForm;
import practice.ShoppingSystem.service.LoginService;
import practice.ShoppingSystem.util.AppUtil;

/**
 * ログイン画面 Controller
 * @author shoujiyuuki
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

  /**ログイン画面 Service*/
  private final LoginService service;

  /**PasswordEncoder*/
  private final PasswordEncoder passwordEncoder;

  /** メッセージソース */
  private final MessageSource messageSource;

  /**
   * 初期表示
   * @param model モデル
   * @param form 入力情報
   * @return 表示画面
   */

  @GetMapping("/login")
  public String view(Model model, LoginForm form){
    return "login";
  }

  /**
   * ログイン
   * @param model モデル
   * @param form 入力情報
   * @return 表示画面
   */

  @PostMapping("/login")
  public String login(Model model, LoginForm form){
    //入力されたログインIDがDBに保管されているか検索
    var userInfo = service.searchUserById(form.getLoginId());
    //値があるかどうか && 生のパスワードとエンコードされたパスワードが一致するか
    var isCorrectUserAuth = userInfo.isPresent()
        && passwordEncoder.matches(form.getPassword(), userInfo.get().getPassword());

    if(isCorrectUserAuth) {
      return "redirect:/menu";
    }else{
      //エラーメッセージを表示する
      var errorMsg = AppUtil.getMessage(messageSource, ErrorMessageConst.LOGIN_WRONG_INPUT);
      model.addAttribute("errorMsg",errorMsg);
      return "login";
    }
  }
}
