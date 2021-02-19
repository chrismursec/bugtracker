package dev.chrismursec.bugtracker.project;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "project")
public class Project {

  public static final String SEQUENCE_NAME = "projects_sequence";
  @Id
  private long id;
  private String name;
  private String description;
  private ArrayList<Long> bugs;

  protected Project() {
    this.bugs = new ArrayList<Long>();
  }

  public Project(String name, String description, ArrayList<Long> bugs) {
    this.name = name;
    this.description = description;
    this.bugs = bugs;
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

  public ArrayList<Long> getBugs() {
    return this.bugs;
  }

  public void setBugs(ArrayList<Long> bugs) {
    this.bugs = bugs;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'"
        + ", bugs='" + getBugs() + "'" + "}";
  }

}
