package dev.chrismursec.bugtracker.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import dev.chrismursec.bugtracker.bug.Bug;


@Component
public class BugModelListener extends AbstractMongoEventListener<Bug> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public BugModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Bug> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Bug.SEQUENCE_NAME));
        }
    }


}