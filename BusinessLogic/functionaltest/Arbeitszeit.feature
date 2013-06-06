Feature: Arbeitszeit anlegen.
  Damit das System funktioniert müssen Arbeitszeiten angelegt werden können.

  Scenario: Arbeitszeit anlegen
    Given ich lege eine neue Arbeitszeit mit von "01.01.2013 09:00" und bis "01.01.2013 10:00" an
    Then sollte die Arbeitszeit von "01.01.2013 09:00" und bis "01.01.2013 10:00"  als Zeiten haben.

  Scenario: Arbeitszeit zu einem Projekt anlegen
    Given ich lege eine neue Arbeitszeit mit von "01.01.2013 09:00" und bis "01.01.2013 10:00" an
    When ich ein Projekt habe
    And ich die Arbeitszeit einem Projekt zuordne
    Then sollte das Projekt die Arbeitszeit haben
    Then sollte die Arbeitszeit von "01.01.2013 09:00" und bis "01.01.2013 10:00"  als Zeiten haben.

  Scenario: Arbeitszeit zu einem Projekt anlegen mit speichern
    Given ich lege eine neue Arbeitszeit mit von "01.01.2013 09:00" und bis "01.01.2013 10:00" an
    When ich ein Projekt habe
    And ich die Arbeitszeit einem Projekt zuordne
    And ich das Projekt speichere
    And ich das Projekt neu lade
    Then sollte das Projekt die Arbeitszeit haben
    Then sollte die Arbeitszeit von "01.01.2013 09:00" und bis "01.01.2013 10:00"  als Zeiten haben.

  Scenario: Arbeitszeit zu einem überbuchten Projekt zuordnen
    Given ich lege eine neue Arbeitszeit mit von "01.01.2013 09:00" und bis "01.01.2013 19:00" an
    And ich habe ein Projekt mit 8 Stunden Kontingent
    Then kann ich dem Projekt die Arbeitszeit nicht zuordnen
