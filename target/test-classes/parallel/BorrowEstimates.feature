Feature: User details

Scenario: Successful navigation to application home page  
Given User opens application url 
When User gets application url as "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/" 
Then Page title should be "Home loan borrowing power calculator | ANZ"
And "How much could I borrow?" header should be displayed

Scenario: Home loan borrowing power calculator feature
Given User opens application url 
When User select "single", dependents "0", property type "Home to live in" and User enters annual income "80000", other income "10000", monthly expense "500", homeloanRepay "0", otherloan "100", otherCommitement "0" and creditlimit "10000" and User clicks Work out how much I could borrow button
Then User gets estimates results "429,000"

Scenario: Home loan borrowing power calculator feature for Living expenses as "$1"
Given User opens application url 
When User provides details
 |Application Type|Number of dependents|Property type|Annual income|Other income|Living expenses|Monthly home loan|Other loans|Other monthly commitments|Credit limits|
 |single|0|Home to live in|0|0|1|0|0|0|0|
Then User gets estimates error "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."


Scenario: To check failed reports: UI test-verify all fields like forms, textbox, headers, footers etc are properly visible on the page 
Given User opens application url 
When User is on home page

 
Scenario: Mandatory fields
Scenarios: Only digits should be allowed
Scenarios: Commercial property type
Scenarios: User has 1 or more number of dependents
Scenarios: Test data from excel sheet
Scenarios: Successful login with valid credetials
Scenarios: Login with invalid credentials
Scenarios: Find ANZ location
Scenarios: Contact feature
