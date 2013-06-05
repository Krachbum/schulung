Feature: Mitarbeiter und Manager anlegen.
  Damit das System funktioniert müssen Mitarbeiter und Manager angelegt werden können.

  Scenario: Mitarbeiter anlegen
    Given ich lege einen neuen Mitarbeiter mit Vorname "Herbert" und Nachname "Huber" an
    Then sollte der Mitarbeiter den Vornamen "Herbert" und den Nachnamen "Huber" haben.

  Scenario: Mitarbeiter umbenennen
    Given ich habe einen Mitarbeiter mit Vorname "Herbert" und Nachname "Huber" und Mitarbeiternummer 1
    When ich dem Mitarbeiter den neuen Nachnamen "Meier" gebe
    Then sollte der Mitarbeiter den Nachnamen "Meier" haben
    And die Mitarbeiternummer soll auf 1 bleiben

  Scenario: Manager umbenennen
    Given ich habe einen Manager mit Vorname "Sebastian" und Nachname "Meier" und Mitarbeiternummer 2
    When ich dem Manager den neuen Nachnamen "Müller" gebe
    Then sollte der Manager den Nachnamen "Müller" haben
    And die Mitarbeiternummer soll auf 2 bleiben
    And ein Manager bleiben

  Scenario: Manager speichern
    Given ich habe einen Manager mit Vorname "Herbert" und Nachname "Meier" und Mitarbeiternummer 2
    When ich den Manager speichere
    And ich dem Manager den neuen Nachnamen "Müller" gebe
    And den Manager wieder lade
    Then sollte der Manager den Nachnamen "Meier" haben
