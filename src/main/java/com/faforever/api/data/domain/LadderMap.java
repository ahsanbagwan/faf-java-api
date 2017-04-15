package com.faforever.api.data.domain;

import com.faforever.api.data.checks.IsLadderManager;
import com.yahoo.elide.annotation.CreatePermission;
import com.yahoo.elide.annotation.DeletePermission;
import com.yahoo.elide.annotation.Include;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@CreatePermission(expression = IsLadderManager.EXPRESSION)
@DeletePermission(expression = IsLadderManager.EXPRESSION)
@Entity
@Setter
@Table(name = "ladder_map")
@Include(rootLevel = true, type = "ladderMap")
@Immutable
public class LadderMap {
  private int id;
  private MapVersion mapVersion;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public int getId() {
    return id;
  }

  @OneToOne
  @JoinColumn(name = "idmap")
  public MapVersion getMapVersion() {
    return mapVersion;
  }
}
