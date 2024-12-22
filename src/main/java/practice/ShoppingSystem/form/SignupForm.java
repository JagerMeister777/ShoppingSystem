package practice.ShoppingSystem.form;

import lombok.Data;

/**
 * ログイン画面　form
 * @author shoujiyuuki
 */

@Data
public class LoginForm {

  /**ログインID*/
  private String loginId;

  /**パスワード*/
  private String password;
}
