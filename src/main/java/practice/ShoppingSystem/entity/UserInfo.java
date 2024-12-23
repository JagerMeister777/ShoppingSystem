package practice.ShoppingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報テーブル Entity
 * @author shoujiyuuki
 */

@Entity
@Table(name = "user_info")
@Data //ゲッターセッターなど自動生成
public class UserInfo {

  /**ログインID*/
  @Id //プライマリーキー
  @Column(name = "login_id") //テーブル名とフィールド名の照合
  private String loginId;

  /**パスワード*/
  private String password;

}
