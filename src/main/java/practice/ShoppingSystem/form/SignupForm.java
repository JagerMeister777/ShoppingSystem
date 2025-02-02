package practice.ShoppingSystem.form;

import lombok.Data;

/**
 * ユーザー登録画面　form
 * @author shoujiyuuki
 */

@Data
public class SignupForm {

  /**ログインID*/
  private String loginId;

  /**パスワード*/
  private String password;
}
