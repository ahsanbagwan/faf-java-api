package com.faforever.api.featuredmods;

import com.faforever.api.config.FafApiProperties;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.PostLoad;

@Component
public class FeaturedModFileEnricher {

  private static FafApiProperties fafApiProperties;

  @Inject
  public void init(FafApiProperties fafApiProperties) {
    FeaturedModFileEnricher.fafApiProperties = fafApiProperties;
  }

  @PostLoad
  public void enhance(FeaturedModFile featuredModFile) {
    String filename = featuredModFile.getName();
    String folder = featuredModFile.getFolderName();
    String urlFormat = fafApiProperties.getFeaturedMods().getFileUrlFormat();

    featuredModFile.setUrl(String.format(urlFormat, folder, filename));
  }
}
