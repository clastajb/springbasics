package com.antsrl.formazione.springbasics.repository;

import com.antsrl.formazione.springbasics.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
