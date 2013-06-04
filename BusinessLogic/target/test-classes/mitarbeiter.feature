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