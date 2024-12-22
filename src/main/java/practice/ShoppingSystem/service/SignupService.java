package practice.ShoppingSystem.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.ShoppingSystem.entity.UserInfo;
import practice.ShoppingSystem.repository.UserInfoRepository;

/**
 * ログイン画面 Service
 * @author shoujiyuuki
 */

@Service
@RequiredArgsConstructor //自動でDIしてくれるLombokのアノテーション
public class LoginService {

  /**ユーザー情報テーブルDAO*/
  private final UserInfoRepository repository;

  /**
   * ユーザー情報テーブル　主キー検索
   * @param loginId ログインID
   * @return ユーザー情報テーブルを主キー検索した結果（1件）
   */

  public Optional<UserInfo> searchUserById(String loginId){
    return repository.findById(loginId);
  }
}
