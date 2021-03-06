package edu.aws.pwgenerator.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="events")
@Component
@Getter
@Setter
@EqualsAndHashCode
public class Event {

    @Id
    private Long idevents;
    private String event;
    private String eventyear;

}
