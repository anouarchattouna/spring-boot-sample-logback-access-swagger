package org.anotherdev.sample.domain;

/**
 * @author Anouar
 *
 */
public class Sample {

  private String country;

  private String currentTime;

  public Sample(String country, String currentTime) {
    this.country = country;
    this.currentTime = currentTime;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(String currentTime) {
    this.currentTime = currentTime;
  }

  @Override
  public String toString() {
    return "Sample [country=" + country + ", currentTime=" + currentTime + "]";
  }

}
