package org.onebusaway.transit_data_federation.impl.offline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.transit_data_federation.services.AgencyAndIdLibrary;
import org.onebusaway.transit_data_federation.services.offline.EntityReplacementStrategy;

public class EntityReplacementStrategyFactory {

  private Map<Class<?>, File> _mappings = new HashMap<Class<?>, File>();

  public void setEntityMappings(Map<Class<?>, File> mappings) {
    _mappings.putAll(mappings);
  }

  public EntityReplacementStrategy create() throws IOException {
    EntityReplacementStrategyImpl impl = new EntityReplacementStrategyImpl();
    for (Map.Entry<Class<?>, File> entry : _mappings.entrySet()) {

      Class<?> entityClass = entry.getKey();
      File file = entry.getValue();

      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if( line.length() == 0 || line.startsWith("#"))
          continue;
        String[] tokens = line.split("\\s+");
        List<AgencyAndId> ids = new ArrayList<AgencyAndId>();
        for (String token : tokens)
          ids.add(AgencyAndIdLibrary.convertFromString(token));
        for (int i = 1; i < ids.size(); i++)
          impl.addEntityReplacement(entityClass, ids.get(i), ids.get(0));
      }
    }
    return impl;
  }

}
