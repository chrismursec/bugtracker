package dev.chrismursec.bugtracker.bug;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Bug {

  @Id
  @SequenceGenerator(name = "bug_sequence", sequenceName = "bug_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bug_sequence")
  private Long id;
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


  public Bug(Long id, String name, String description, int severity, LocalDate logDate, String notes, boolean complete) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.severity = severity;
    this.logDate = logDate;
    this.notes = notes;
    this.complete = complete;

  }



  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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
