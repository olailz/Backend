    package com.example.m3modelo;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name="doctor")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Medico {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id_doctor")
        private Long id;

        @ManyToOne
        @JoinColumn(name="id_speciality")
        private Especiality especiality;
        
        private String name;
        private String lastname;
        private int phone;
        private String adress;
        private String email;

    }
