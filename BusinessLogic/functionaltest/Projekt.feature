Feature: Projekt anlegen
  Damit das System funktioniert müssen Projekte angelegt werden können.

  Scenario: Projekt anlegen
    Given ich lege ein neues Projekt mit Name "Java-Kurs" und Kontingent 20 und Projektleiter 
    Then sollte das Projekt den Namen "Java-Kurs" und Kontingent 20 haben und einen Projektleiter

  Scenario: Projekt umbenennen
    Given ich lege ein neues Projekt mit Name "Java-Kurs" und Kontingent 20 und Projektleiter 
    When ich dem Projekt den neuen Namen "Kurs-Java" gebe
    Then sollte das Projekt den Namen "Kurs-Java" haben
    And das Kontingent soll auf 20 bleiben 
    And der Projektleiter gleich bleiben

  Scenario: Projektleiter ändern
    Given ich lege ein neues Projekt mit Name "Java-Kurs" und Kontingent 20 und Projektleiter 
    When ich dem Projekt den neuen Projektleiter uebergebe 
    Then soll das Projekt den neuen Projektleiter haben
    And das Kontingent soll auf 20 bleiben
    And der Name soll auf "Java-Kurs" bleiben
