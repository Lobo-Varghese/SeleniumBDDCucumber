Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|lobovarghese15@gmail.com|Test@1234|

Scenario: Account Page Title
Given user is on Accounts Page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account section count 
Given user is on Accounts Page
Then user gets account section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6

