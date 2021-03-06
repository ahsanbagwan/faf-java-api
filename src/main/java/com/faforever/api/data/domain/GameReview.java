package com.faforever.api.data.domain;

import com.faforever.api.data.checks.IsReviewOwner;
import com.yahoo.elide.annotation.CreatePermission;
import com.yahoo.elide.annotation.DeletePermission;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.UpdatePermission;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Setter
@Include(rootLevel = true, type = "gameReview")
@Entity
@Table(name = "game_review")
@PrimaryKeyJoinColumn(name = "review_id", referencedColumnName = "id")
@CreatePermission(expression = "Prefab.Role.All")
@DeletePermission(expression = IsReviewOwner.EXPRESSION)
public class GameReview extends Review {

  private Game game;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "game_id")
  @UpdatePermission(expression = "Prefab.Role.All and Prefab.Common.UpdateOnCreate")
  public Game getGame() {
    return game;
  }
}
