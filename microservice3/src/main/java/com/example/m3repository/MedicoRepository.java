package com.example.m3repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.m3modelo.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Long>{

    List<Medico> findByName(String name);


}
