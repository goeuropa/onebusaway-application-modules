/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
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
package org.onebusaway.transit_data.model;

import org.onebusaway.realtime.api.OccupancyStatus;
import org.onebusaway.transit_data.HistoricalRidershipBean;

import java.io.Serializable;
import java.util.List;

public class TripStopTimeBean implements Serializable {

  private static final long serialVersionUID = 2L;

  private int arrivalTime;

  private int departureTime;

  private StopBean stop;

  private String stopHeadsign;
  
  private double distanceAlongTrip;

  private OccupancyStatus historicalOccupancy; // Intended to be 1 element

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public int getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(int departureTime) {
    this.departureTime = departureTime;
  }

  public StopBean getStop() {
    return stop;
  }

  public void setStop(StopBean stop) {
    this.stop = stop;
  }

  public String getStopHeadsign() {
    return stopHeadsign;
  }

  public void setStopHeadsign(String stopHeadsign) {
    this.stopHeadsign = stopHeadsign;
  }

  public double getDistanceAlongTrip() {
    return distanceAlongTrip;
  }

  public void setDistanceAlongTrip(double distanceAlongTrip) {
    this.distanceAlongTrip = distanceAlongTrip;
  }

  public OccupancyStatus getHistoricalOccupancy() {return historicalOccupancy; }

  public void setHistoricalOccupancy(List<HistoricalRidershipBean> historicalOccupancy) {
    if (historicalOccupancy != null && historicalOccupancy.size() > 0) {
      this.historicalOccupancy = OccupancyStatus.toEnum(historicalOccupancy.get(0).getLoadFactor());
    } else {
      this.historicalOccupancy = null;
    }
  }
}
