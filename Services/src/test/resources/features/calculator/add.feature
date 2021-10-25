Feature: Buscar moneda con CodigoISO
  Como usuario de una applicacion
  necesito buscar Con el codigoISO
  para poder traer el tipo de moneda con ese codigoISO



  Scenario: Buscar Moneda con condigoISO valido
    Given que el usuario de la aplicacion ha definido como codigoISO el "USD"
    When el usuario de la aplicacion ejecuta la busqueda
    Then el usuario debería obtener el resultado "USD" y "Dollars"

  Scenario: Buscar Moneda con condigoISO fallido
    Given que el usuario de la aplicacion ha definido como codigoISO el "perros"
    When el usuario de la aplicacion ejecuta la busqueda
    Then el usuario debería obtener el resultado "Country not found in the database"