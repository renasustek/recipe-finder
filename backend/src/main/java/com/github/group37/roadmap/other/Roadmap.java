package com.github.group37.roadmap.other;

import com.github.group37.roadmap.percistance.models.RevisionResourceDao;

import java.util.ArrayList;

public class Roadmap {
    private String name;

    private ArrayList<RevisionResourceDao> revisionResourceDaos;

    public String getName() {
        return name;
    }

    public ArrayList<RevisionResourceDao> getRevisionResources() {
        return revisionResourceDaos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRevisionResources(ArrayList<RevisionResourceDao> revisionResource) {
        this.revisionResourceDaos = revisionResource;
    }

    public void addToList (RevisionResourceDao revisionResourceDao){
        revisionResourceDaos.add(revisionResourceDao);
    }
}
