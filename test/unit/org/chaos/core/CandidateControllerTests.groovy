package org.chaos.core

import grails.test.mixin.*

@TestFor(CandidateController)
@Mock(Candidate)
class CandidateControllerTests {

    def populateValidParams(params) {
        assert params != null

        params['firstName'] = 'Tom'
        params['lastName'] = 'Smith'

    }

    void testIndex() {
        controller.index()
        assert "/participant/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.participantInstanceList.size() == 0
        assert model.participantInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.participantInstance != null
    }

    void testSave() {
        controller.save()

        assert model.participantInstance != null
        assert view == '/participant/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/participant/show/1'
        assert controller.flash.message != null
        assert Candidate.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/participant/list'

        populateValidParams(params)
        def participant = new Candidate(params)

        assert participant.save() != null

        params.id = participant.id

        def model = controller.show()

        assert model.participantInstance == participant
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/participant/list'

        populateValidParams(params)
        def participant = new Candidate(params)

        assert participant.save() != null

        params.id = participant.id

        def model = controller.edit()

        assert model.participantInstance == participant
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/participant/list'

        response.reset()

        populateValidParams(params)
        def participant = new Candidate(params)

        assert participant.save() != null

        // test invalid parameters in update
        params.id = participant.id
        params['firstName'] = ''
        params['lastName'] = ''

        controller.update()

        assert view == "/participant/edit"
        assert model.participantInstance != null

        participant.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/participant/show/$participant.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        participant.clearErrors()

        populateValidParams(params)
        params.id = participant.id
        params.version = -1
        controller.update()

        assert view == "/participant/edit"
        assert model.participantInstance != null
        assert model.participantInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/participant/list'

        response.reset()

        populateValidParams(params)
        def participant = new Candidate(params)

        assert participant.save() != null
        assert Candidate.count() == 1

        params.id = participant.id

        controller.delete()

        assert Candidate.count() == 0
        assert Candidate.get(participant.id) == null
        assert response.redirectedUrl == '/participant/list'
    }
}
