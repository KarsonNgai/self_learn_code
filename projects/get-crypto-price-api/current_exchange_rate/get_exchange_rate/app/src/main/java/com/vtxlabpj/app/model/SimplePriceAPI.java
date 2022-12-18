package com.vtxlabpj.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimplePriceAPI {
  
  @JsonProperty
  Double usd;

  @JsonProperty
  Double hkd;
}
