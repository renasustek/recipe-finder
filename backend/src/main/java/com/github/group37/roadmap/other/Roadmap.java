package com.github.group37.roadmap.other;

import com.github.group37.roadmap.percistance.models.RevisionRecourceDao;

import java.util.ArrayList;

public class Roadmap {
    private String name;

    private ArrayList<RevisionRecourceDao> revisionRecourceDaos;

    public String getName() {
        return name;
    }

    public ArrayList<RevisionRecourceDao> getRevisionRecourceDaos() {
        return revisionRecourceDaos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRevisionRecourceDaos(ArrayList<RevisionRecourceDao> revisionRecourceDaos) {
        this.revisionRecourceDaos = revisionRecourceDaos;
    }

    public void addToList (RevisionRecourceDao revisionRecourceDao){
        revisionRecourceDaos.add(revisionRecourceDao);
    }
}
