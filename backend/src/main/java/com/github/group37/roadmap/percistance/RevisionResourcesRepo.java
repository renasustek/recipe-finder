package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.percistance.models.RevisionResourceDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RevisionResourcesRepo extends JpaRepository<RevisionResourceDao, UUID> {


}
