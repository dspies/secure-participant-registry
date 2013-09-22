package org.chaos.core

import com.bloomhealthco.jasypt.GormEncryptedDateAsStringType
import com.bloomhealthco.jasypt.GormEncryptedLongAsStringType
import com.bloomhealthco.jasypt.GormEncryptedStringType

class Candidate {

    String firstName
    String lastName
    Date birthDate
    Long patientId
    Date lastUpdated
    Date dateCreated

    static constraints = {
        firstName blank: false, maxSize: 35    //This will enforce the maxSize, but not change the column width
        lastName blank: false, maxSize: 35
        birthDate nullable: true
        patientId nullable: true
    }

    static mapping = {
        firstName type: GormEncryptedStringType, sqlType: 'varchar', length: 500
        lastName type: GormEncryptedStringType, sqlType: 'varchar', length: 500
        birthDate type: GormEncryptedDateAsStringType
        patientId type: GormEncryptedLongAsStringType
    }

    String toString(){
        return "${firstName} ${lastName}"
    }
}