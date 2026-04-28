Feature: Crud ejercicios

  Scenario: Crear un nuevo ejercicio correctamente
    Given que el usuario abre la app GymTracker
    When presiona el boton de agregar ejercicio
    And ingresa el nombre "Press Banca"
    And selecciona el grupo muscular "Pecho"
    And selecciona el tipo "Fuerza"
    And guarda el ejercicio
    Then deberia ver el ejercicio "Press Banca" en la lista



  Scenario: Crear un ejercicio de tipo Cardio
    Given que el usuario abre la app GymTracker
    When presiona el boton de agregar ejercicio
    And ingresa el nombre "Correr en cinta"
    And selecciona el grupo muscular "Piernas"
    And selecciona el tipo "Cardio"
    And guarda el ejercicio
    Then deberia ver el ejercicio "Correr en cinta" en la lista

  Scenario: Editar el nombre de un ejercicio existente
    Given que el usuario abre la app GymTracker
    And existe el ejercicio "Press Banca" en la lista
    When selecciona el ejercicio "Press Banca"
    And cambia el nombre a "Press Inclinado"
    And guarda el ejercicio
    Then deberia ver el ejercicio "Press Inclinado" en la lista

  Scenario: Eliminar un ejercicio existente
    Given que el usuario abre la app GymTracker
    And existe el ejercicio "Press Banca" en la lista
    When elimina el ejercicio "Press Banca"
    Then no deberia ver el ejercicio "Press Banca" en la lista
