package com.restapi.restapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteDao, String> {
    List<NoteDao> findAllByOrderByTitleDesc();
}
