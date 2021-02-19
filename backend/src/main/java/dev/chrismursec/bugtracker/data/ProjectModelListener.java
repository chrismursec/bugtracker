package dev.chrismursec.bugtracker.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import dev.chrismursec.bugtracker.project.Project;

@Component
public class ProjectModelListener extends AbstractMongoEventListener<Project> {

  private SequenceGeneratorService sequenceGenerator;

  @Autowired
  public ProjectModelListener(SequenceGeneratorService sequenceGenerator) {
    this.sequenceGenerator = sequenceGenerator;
  }

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Project> event) {
    if (event.getSource().getId() < 1) {
      event.getSource().setId(sequenceGenerator.generateSequence(Project.SEQUENCE_NAME));
    }
  }

}
