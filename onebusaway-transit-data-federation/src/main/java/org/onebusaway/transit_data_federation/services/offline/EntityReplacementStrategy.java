package org.onebusaway.transit_data_federation.services.offline;

import java.io.Serializable;

public interface EntityReplacementStrategy {
  
  public boolean hasReplacementEntities(Class<?> entityType);

  public boolean hasReplacementEntity(Class<?> entityType, Serializable id);

  public Serializable getReplacementEntityId(Class<?> entityType,
      Serializable id);
}
