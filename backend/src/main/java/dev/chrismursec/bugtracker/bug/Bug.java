package dev.chrismursec.bugtracker.bug;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bug")
public class Bug {

  @Transient
  public static final String SEQUENCE_NAME = "bugs_sequence";
  @Id
  private long id;
  private String name;
  private String description;
  private int severity;
  private LocalDate logDate;
  private String notes;
  private boolean complete;

  public Bug() {}

  public Bug(String name, String description, int severity, LocalDate logDate, String notes, boolean complete) {
    this.name = name;
    this.description = description;
    this.severity = severity;
    this.logDate = logDate;
    this.notes = notes;
    this.complete = complete;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getSeverity() {
    return this.severity;
  }

  public void setSeverity(int severity) {
    this.severity = severity;
  }

  public LocalDate getLogDate() {
    return this.logDate;
  }

  public void setLogDate(LocalDate logDate) {
    this.logDate = logDate;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public boolean isComplete() {
    return this.complete;
  }

  public boolean getComplete() {
    return this.complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", description='" + getDescription() + "'" +
      ", severity='" + getSeverity() + "'" +
      ", logDate='" + getLogDate() + "'" +
      ", notes='" + getNotes() + "'" +
      ", complete='" + isComplete() + "'" +
      "}";
  }  
}
