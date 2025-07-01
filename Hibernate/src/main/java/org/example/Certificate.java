package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "studentCertificate")
public class Certificate {
    @Column(name = "certificateId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateId ;
    @Column(name = "certificateName")
    private String certificateName ;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student ;

    public long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(long certificateId) {
        this.certificateId = certificateId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
}
