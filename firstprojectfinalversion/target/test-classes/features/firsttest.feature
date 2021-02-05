Feature: Test Booking

  @login
  Scenario: Login to Booking  
    Given booking page is opened 
		When I click on login button
		Then connection page is displayed
		When I enter valid email 
		And I click on next button
		Then password page is displayed
		When I enter valid password 
		And I click on login button1
		Then I am connected
    
  @currency @language
  Scenario: change currency and language
    Given user is connected to Booking0
    When I click on currency icon
    Then currency list is shown
    When I choose usa dollar currency
    Then currency should change to usa dollar
    When I click on currency icon 
    Then currency list is shown
    When I choose euro currency
    Then currency should change to euro
    When I click on language icon 
    Then language list is shown
    When I choose english language
    Then language should change to english
    When I click on language icon 
    Then language list is shown
    When I choose french language
    Then language should change to french
    
  
   @profile
   Scenario: my profile
    Given user is connected to Booking1
    When I click on username
    Then options list is shown
    When I click on manage account
    Then account settings page is displayed
    And three blocs are shown
    When I click on personal details
    Then updating information page is displayed
    When I click on edit name
    And I enter the new name
    And I click on save
    Then modification is saved
    When I click on booking.com logo
    Then home page is shown
    And name is changed
    
   @stays
   Scenario: search of stay
   Given user is connected to Booking2
   When I click on stays in the page header
   Then text what will be your next destination is shown
   When I enter paris in where are you going box
   When I click on check-in
   Then calendar is shown0
   When I select date of arrival
   Then date of arrival is changed to selected date
   When I select date of departure
   Then date of departure is changed to selected date
   And calendar is gone0
   When I choose adults children and rooms
   And I click on search button0
   Then page of establishments found is shown
   And search criteria shown in the left are correct
   And number of establishments is more than 20
   When I click on the first establishment image
   Then new window of establishment is opened
   When I click on equipment
   Then new block of establishment equipments is shown
   When I close window
   Then search page is shown
   When I click on booking logo
   Then home page is shown1
   
    
   @flight
   Scenario: search of flight
   Given Booking page is open
   When I click on flights in the page header
   Then text find and book your next flight is shown
   When I select one way ticket
   Then radio button one way ticket is selected
   When I click on select departure airport
   Then menu to select departure airport is shown
   When I select departure airport
   Then field to select arrival airport is shown
   When I select arrival airport 
   Then calendar is shown1
   When I select date
   Then calendar is gone1
   When I click on select number of persons
   Then menu to select number of persons is shown
   When I select adults and children
   Then number of person is shown
   When I click on ok
   Then menu is gone
   When I click on search button1
   Then list of flights is shown
   