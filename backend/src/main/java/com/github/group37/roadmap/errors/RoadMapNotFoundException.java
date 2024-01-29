package com.github.group37.roadmap.errors;

import java.util.UUID;

public class RoadMapNotFoundException extends RuntimeException{

    public RoadMapNotFoundException(){
        super("roadmap couldnt be found");
    }
}
