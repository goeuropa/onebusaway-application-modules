/**
 * Copyright (C) 2016 Cambridge Systematics, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.admin.model.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the stop count summary for a particular mode and route.
 * The summary data is contained in the DataValidaionHeadsignCts
 * elements.
 *
 * @author jpearson
 *
 */
public class DataValidationRouteCounts {
  private String routeName;
  List<DataValidationHeadsignCts> headsignCounts;
  private String srcCode;  // Used in diff files to indicate the source.

  public DataValidationRouteCounts() {
    super();
  }
  public DataValidationRouteCounts(String routeName, String headsign, String direction) {
    super();
    this.routeName = routeName;
    this.headsignCounts = new ArrayList<DataValidationHeadsignCts>();
    this.headsignCounts.add(new DataValidationHeadsignCts(headsign, direction));
  }

  public String getRouteName() {
    return routeName;
  }
  public void setRouteName(String routeName) {
    this.routeName = routeName;
  }
  public List<DataValidationHeadsignCts> getHeadsignCounts() {
    return headsignCounts;
  }
  public void setHeadsignCounts(List<DataValidationHeadsignCts> headsignCounts) {
    this.headsignCounts = headsignCounts;
  }
  public String getSrcCode() {
    return srcCode;
  }
  public void setSrcCode(String srcCode) {
    this.srcCode = srcCode;
  }
}
