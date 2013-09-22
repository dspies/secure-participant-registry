package org.chaos.core

import grails.test.mixin.TestFor
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Candidate)
class CandidateTests {

	Candidate participant

	@Before
	void setup(){
        mockForConstraintsTests Candidate

        //Test for null fields
        participant = new Candidate()
	}

    void testNullConstraints() {
       assertFalse participant.validate()
       assertEquals 'nullable', participant.errors['firstName']
       assertEquals 'nullable', participant.errors['lastName']
    }

    void testBlankConstraints() {
    	participant.firstName = ''
    	participant.lastName = ''

		assertFalse participant.validate()
		assertEquals 'blank', participant.errors['firstName']
		assertEquals 'blank', participant.errors['lastName']
    }

	void testMaxSizeConstraints(){
        //Test for maxSize of firstName(35), lastName(35)
        participant.firstName = 'Lorem ipsum dolor sit amet, consecte'
        participant.lastName = 'Lorem ipsum dolor sit amet, consecte'

        assertFalse participant.validate()
        assertEquals 'maxSize', participant.errors['firstName']
        assertEquals 'maxSize', participant.errors['lastName']
    }

    void testValidConstraints() {
        //Test for good values
        participant.firstName = 'Tom'
        participant.lastName = 'Jones'

        assertTrue participant.validate()
    }

}
