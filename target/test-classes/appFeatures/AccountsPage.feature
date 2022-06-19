Feature: Account Page Feature

Background:
Given user has already logged in to application
|usename|password|
|lobovarghese15@gamil.com|Test@1234|

Scenario: Account Page Title
Given user is on Accounts Page
When user gets the title of the Page
Then page title should be "My Account - My Store"

Scenario: Account section count 
Given user is on Accounts Page
Then user gets account section
|Order history and details|
|My credit slips|
|My addresses|
|My personal information|
|My wishlists|
And accounts section count should be 5

