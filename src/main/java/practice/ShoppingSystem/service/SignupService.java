package practice.ShoppingSystem.service;

import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.ShoppingSystem.entity.UserInfo;
import practice.ShoppingSystem.form.SignupForm;
import practice.ShoppingSystem.repository.UserInfoRepository;

/**
 * ユーザー登録画面 Service
 * @author shoujiyuuki
 */

@Service
@RequiredArgsConstructor //自動でDIしてくれるLombokのアノテーション
public class SignupService {

  /**ユーザー情報テーブルDAO*/
  private final UserInfoRepository repository;

  /** DozerMapper */
  private final Mapper mapper;

  /**PasswordEncoder*/
  private final PasswordEncoder passwordEncoder;

  /**
   * ユーザー情報テーブル　新規登録
   * @param form 入力情報
   * @return 登録情報(ユーザー情報Entity)
   */

  public UserInfo resistUserInfo(SignupForm form){
    var userInfo = mapper.map(form, UserInfo.class);

    var encodedPassword = passwordEncoder.encode(form.getPassword());
    userInfo.setPassword(encodedPassword);

    return repository.save(userInfo);
  }
}
